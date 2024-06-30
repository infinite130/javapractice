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

@WebServlet("/community/insert")
public class CommunityInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/community/insert.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        System.out.println("Insert 처리 중입니다.");

        //파일이 여러 개 있는지 체크
        if (JakartaServletFileUpload.isMultipartContent(request)) {
            processMultipartRequest(request, response);
        }
    }
	//	경로 설정 및 폴더 생성
    private void processMultipartRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rootLocation = getServletContext().getRealPath("/");//해당 서블릿의 루트
        String fileUploadDirectory = rootLocation + "/resources/upload/original/";// 사진들이 저장될 경로
        String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";// 사진들이 저장될 경로
        
        //----------폴더 생성하는 메소드---------
        createDirectories(fileUploadDirectory, thumbnailDirectory);

        
        //--------------------실질적으로 데이베이스에 넣기 위한 구조 만들기--------------
        
        //파일에 관한 정보는 List, 그외의 정보들은 Map에 담는다
        List<Map<String, String>> fileList = new ArrayList<>();
        Map<String, String> parameter = new HashMap<>();

        // 파일 자체에 대한 환경설정
        DiskFileItemFactory.Builder fileItemFactory = new DiskFileItemFactory.Builder();
        fileItemFactory.setPath(fileUploadDirectory);//original 디렉토리
        fileItemFactory.setBufferSize(1024 * 1024 * 10);

        //설정한 환경을 JakartaServletFileUpload에 붙여준다.
        JakartaServletFileUpload fileUpload = new JakartaServletFileUpload(fileItemFactory.get());

        try {
        	//multipart/form-data 형식으로 전달된 데이터를 FileItem 객체로 변환
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            int countPicture = 0;

            for (FileItem fileItem : fileItems) {
            	System.out.println(fileItem);//안에 어떤 순서대로 담겼는지 모르니까 출력해보자
            	
            	// 해당 형식처럼 나오는 걸 확인할 수 있다.
            	
            	/*
            	 * name=null, StoreLocation=null, size=5 bytes, isFormField=true,FieldName=communityTitle
            	 * name=스크린샷 2024-06-21 215724.png, StoreLocation=null,size=54307 bytes, isFormField=false, FieldName=thumbnailImg
            	 * 
            	 * */
            	
            	//위와 같이 텍스트 형식은 isFormField는 true형식이고, 파일형식은 false로 나오는 것을 알 수 있다.
                //텍스트 데이터가 아닌 경우 == 파일 데이터인 경우
            	//데이터 사이즈가 0이상이어야 전송된 파일이 있다는 의미이다.
            	if (!fileItem.isFormField() && fileItem.getSize() > 0) {
                	//------파일에 관한 정보 처리하는 메소드-------
                    processFileItem(fileItem, fileList, fileUploadDirectory, thumbnailDirectory);
                    countPicture++;
                } else {// 폼 데이터인 경우
                	// name 얻어오기 : getFieldName 
                	// value 얻어오기 : getString 
                	//기본적인 인코딩이 ISO-8859-1로 처리되므로 UTF-8로 바꿔준다.
                    parameter.put(fileItem.getFieldName(), new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8"));
                }
            }

          //이제 해당 정보들로 DTO 객체 생성
            CommunityDTO community = createCommunityDTO(parameter, fileList, request);
            int result = new CommunityService().insertCommunityWithPic(community);;

            forwardResult(request, response, result);
        } catch (Exception e) {
            handleException(fileList, fileUploadDirectory, e);
        }
    }

    private void createDirectories(String... directories) {
        for (String directory : directories) {
            File dir = new File(directory);//해당 경로에 접근할 수 있는 객체 생성
            if (!dir.exists()) {//만약 해당경로의 파일이 존재하지 않는다면??
                dir.mkdirs();//해당 파일을 만들자
                /*
                 * mkdir은 폴더 하나만 만들지만 mkdirs는 상위폴더까지 만들어줌
                 * */
            }
        }
    }

    private void processFileItem(FileItem fileItem, List<Map<String, String>> fileList, String fileUploadDirectory, String thumbnailDirectory) throws Exception {
        String originalName = fileItem.getName();//파일데이터의 이름 받아오기
        String inputTagName = fileItem.getFieldName();//내가 input태그의 속성으로 적은 name

        //이름에서 확장자 뽑기
        String ext = originalName.substring(originalName.lastIndexOf("."));
        //637c99eb-af10-41b2-adc7-44320f4ef9eb 이렇게 뜨는 걸 -를 빼고 숫자와 확장자만 보이게 바꿔준다.
        String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;

        //위에 설정한 randomFileName으로 설정한 경로에 파일을 저장한다.
        File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
        fileItem.write(storeFile.toPath());

        //사진들의 정보 담을 Map(PictureDTO요소)
        //하나씩 Map형식으로 만든 후 모든 파일을 다 만들었으면 리스트에 넣어준다
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("originalName", originalName);
        fileMap.put("inputTagname", inputTagName);
        fileMap.put("saveName", randomFileName);
        fileMap.put("savePath", fileUploadDirectory);

        System.out.println(inputTagName);
        System.out.println("thumbnailImg".equals(inputTagName));
        //title인지 body인지 구분해서 넣는다-----------------------------------
        int width = "thumbnailImg".equals(inputTagName) ? 350 : 120;
        int height = "thumbnailImg".equals(inputTagName) ? 200 : 100;
        fileMap.put("fileType", "thumbnailImg".equals(inputTagName) ? "TITLE" : "BODY");

        // 썸네일로 변환 후 저장한다.
        Thumbnails.of(fileUploadDirectory + randomFileName)
                .size(width, height)//사이즈를 변경해서
                .toFile(thumbnailDirectory + "thumbnail_" + randomFileName);//해당 이름으로 저장해줌

     // 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다.
        fileMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_" + randomFileName);

        fileList.add(fileMap);
    }

    private CommunityDTO createCommunityDTO(Map<String, String> parameter, List<Map<String, String>> fileList, HttpServletRequest request) {
        CommunityDTO community = new CommunityDTO();
        community.setCommunityTitle(parameter.get("communityTitle"));
        community.setCommunityBody(parameter.get("communityBody"));
        
      //세션에서 로그인 되어있는 회원의 userNo를 가지고 온다.
        community.setUserNo(((UserDTO) request.getSession().getAttribute("loginUser")).getUserNo());

      //PictureDTO 형식의 List를 만들어서 넣는다.
        List<PictureDTO> pictureList = new ArrayList<>();
        
     // 만든 List에 fileList에 있는 것들을 꺼내서 담아준다. 
     // List<Map<String, String>> fileList
     // fileList에는 사진의 정보들이 차례대로 들어가있다.
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
        
        System.out.println(result);
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