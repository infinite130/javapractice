package com.javanos.project.community.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.dto.PictureDTO;
import com.javanos.project.community.model.service.CommunityService;
import com.javanos.project.user.model.dto.UserDTO;

@WebServlet("/community/update")
public class CommunityUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int communityNo = Integer.valueOf(request.getParameter("communityNo"));

		CommunityDTO community = new CommunityService().selectOneThumbnailList(communityNo);

		request.setAttribute("community", community);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/community/updateform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("communityNo") == null) {
            System.out.println("Insert 처리 중입니다.");
        } else {
            System.out.println("Update 처리 중입니다.");
        }

        if (JakartaServletFileUpload.isMultipartContent(request)) {
            processMultipartRequest(request, response);
        }
    }

	private void processMultipartRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rootLocation = getServletContext().getRealPath("/");
        String fileUploadDirectory = rootLocation + "/resources/upload/original/";
        String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";

        List<Map<String, String>> fileList = new ArrayList<>();
        Map<String, String> parameter = new HashMap<>();

        DiskFileItemFactory.Builder fileItemFactory = new DiskFileItemFactory.Builder();
        fileItemFactory.setPath(fileUploadDirectory);
        fileItemFactory.setBufferSize(1024 * 1024 * 10);

        JakartaServletFileUpload fileUpload = new JakartaServletFileUpload(fileItemFactory.get());

        try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            int countPicture = 0;

            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField() && fileItem.getSize() > 0) {
                    processFileItem(fileItem, fileList, fileUploadDirectory, thumbnailDirectory);
                    countPicture++;
                } else {
                    parameter.put(fileItem.getFieldName(), new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8"));
                }
            }

            CommunityDTO community = createCommunityDTO(parameter, fileList, request);
            int result = new CommunityService().updateCommunityWithPic(community);;
            
            forwardResult(request, response, result);
        } catch (Exception e) {
            handleException(fileList, fileUploadDirectory, e);
        }
    }
	
	private void processFileItem(FileItem fileItem, List<Map<String, String>> fileList, String fileUploadDirectory, String thumbnailDirectory) throws Exception {
        String originalName = fileItem.getName();
        String inputTagName = fileItem.getFieldName();

        String ext = originalName.substring(originalName.lastIndexOf("."));
        String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;

        File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
        fileItem.write(storeFile.toPath());

        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("originalName", originalName);
        fileMap.put("inputTagname", inputTagName);
        fileMap.put("saveName", randomFileName);
        fileMap.put("savePath", fileUploadDirectory);

        System.out.println(inputTagName);
        System.out.println("thumbnailImg".equals(inputTagName));
        int width = "thumbnailImg".equals(inputTagName) ? 350 : 120;
        int height = "thumbnailImg".equals(inputTagName) ? 200 : 100;
        fileMap.put("fileType", "thumbnailImg".equals(inputTagName) ? "TITLE" : "BODY");

        Thumbnails.of(fileUploadDirectory + randomFileName)
                .size(width, height)
                .toFile(thumbnailDirectory + "thumbnail_" + randomFileName);

        fileMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_" + randomFileName);

        fileList.add(fileMap);
    }

    private CommunityDTO createCommunityDTO(Map<String, String> parameter, List<Map<String, String>> fileList, HttpServletRequest request) {
        CommunityDTO community = new CommunityDTO();
        
        community.setCommunityNo(Integer.parseInt(parameter.get("communityNo")));
        community.setCommunityModifyDate(LocalDateTime.now());
        community.setCommunityTitle(parameter.get("communityTitle"));
        community.setCommunityBody(parameter.get("communityBody"));
        community.setUserNo(((UserDTO) request.getSession().getAttribute("loginUser")).getUserNo());

        List<PictureDTO> pictureList = new ArrayList<>();
        for (Map<String, String> file : fileList) {
            PictureDTO picture = new PictureDTO();
            picture.setOriginalName(file.get("originalName"));
            picture.setSaveName(file.get("saveName"));
            picture.setSavePath(file.get("savePath"));
            picture.setFileType(file.get("fileType"));
            picture.setThumbnailPath(file.get("thumbnailPath"));

            pictureList.add(picture);
        }
        community.setPictureList(pictureList);

        return community;
    }
    

    private void forwardResult(HttpServletRequest request, HttpServletResponse response, int result) throws ServletException, IOException {
        String path;
        if (result > 0) {
            path = "/WEB-INF/views/common/success.jsp";
            request.setAttribute("successCode", "communityInsert");
            request.setAttribute("message", "게시글이 등록되었습니다!");
        } else {
            path = "/WEB-INF/views/common/fail.jsp";
            request.setAttribute("code", "communityInsert");
            request.setAttribute("message", "게시글 등록에 실패했습니다");
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    private void handleException(List<Map<String, String>> fileList, String fileUploadDirectory, Exception e) {
        for (Map<String, String> file : fileList) {
            File deleteFile = new File(fileUploadDirectory + "/" + file.get("saveName"));
            if (deleteFile.delete()) {
                System.out.println("Failed upload image deleted: " + file.get("saveName"));
            }
        }
        e.printStackTrace();
    }
}