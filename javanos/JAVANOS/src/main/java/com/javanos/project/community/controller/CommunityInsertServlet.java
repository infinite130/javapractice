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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/community/insert.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파일이 여러 개 있는지 체크
		if(JakartaServletFileUpload.isMultipartContent(request)) {
			
			//------------------------------------경로설정 및 폴더 생성----------------------------------------
			String rootLocation = getServletContext().getRealPath("/");//해당 서블릿의 루트
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			
			// 사진들이 저장될 경로
			String fileUploadDirectory = rootLocation + "/resources/upload/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";
			
			//해당 경로에 접근할 수 있는 객체 생성
			File directoryFile = new File(fileUploadDirectory);
			File directoryThumbnail = new File(thumbnailDirectory);
			
			System.out.println("Root Location: " + rootLocation);
	        System.out.println("File Upload Directory: " + fileUploadDirectory);
	        System.out.println("Thumbnail Directory: " + thumbnailDirectory);
			
			//만약 해당경로의 파일이 존재하지 않는다면??
			if(!directoryFile.exists() || !directoryThumbnail.exists()) {
				//해당 파일을 만들자
				
				directoryFile.mkdirs();//mkdir은 폴더 하나만 만들지만 mkdirs는 상위폴더까지 만들어줌
				directoryThumbnail.mkdirs();
			}
			
			
			//-----------------------실질적으로 저장하는 과정-----------------------------------------------------
			//파일에 관한 정보는 List, 그외의 정보들은 Map에 담는다
			List<Map<String, String>> fileList = new ArrayList<Map<String,String>>();
			Map<String, String> parameter = new HashMap<String, String>();
			
			// 파일 자체에 대한 환경설정 느낌이다. 위에서 설정한 최대 크기나 파일저장경로 등을 포함하는 인스턴스 생성
			DiskFileItemFactory.Builder fileItemFactory = new DiskFileItemFactory.Builder();
			//위에서 설정해둔 File 형식의 경로를 가지고 있는 객체(길)
			fileItemFactory.setPath(directoryFile.getPath());//path 설정//original 디렉토리 
			fileItemFactory.setBufferSize(maxFileSize);//최대 사이즈 설정
			
			//설정한 환경을 JakartaServletFileUpload에 붙여준다.
			JakartaServletFileUpload fileUpload = new JakartaServletFileUpload(fileItemFactory.get());
			
			try {
				//multipart/form-data 형식으로 전달된 데이터를 FileItem 객체로 변환
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				//안에 어떤 순서대로 담겼는지 모르니까 출력해보자
				
				int countPicture = 0;
				for (FileItem fileItem : fileItems) { System.out.println(fileItem); }
				 
				// 해당 형식처럼 나오는 걸 확인할 수 있다.
				/*
				 * name=null, StoreLocation=null, size=5 bytes, isFormField=true, FieldName=communityTitle
				   name=스크린샷 2024-06-21 215724.png, StoreLocation=null, size=54307 bytes, isFormField=false, FieldName=thumbnailImg

				 * 위와 같이 텍스트 형식은 isFormField는 true형식이고, 파일형식은 false로 나오는 것을 알 수 있다.
				 * */
				
				for (int i = 0; i < fileItems.size(); i++) {
					FileItem fileitem = fileItems.get(i);//form태그에서 받아온 item들 하나씩 꺼내봐
					Map<String, String> fileMap = new HashMap();//사진들의 정보 담을 Map(PictureDTO요소)
					
					//텍스트 데이터가 아닌 경우 == 파일 데이터인 경우
					if(!fileitem.isFormField()) {
						//데이터 사이즈가 0이상이어야 전송된 파일이 있다는 의미이다.
						if(fileitem.getSize()>0) {
							//DTO를 참고해서 테이블에 저장될 정보들을 꺼내서 저장한다.
							String originalName = fileitem.getName();
							String inputTagname = fileitem.getFieldName();//내가 input태그의 속성으로 적은 name
							
							//확장자를 제외한 이름을 넣기
							int dot = originalName.lastIndexOf(".");
							String ext = originalName.substring(dot);//.jpg 같은 문자열
							
							//637c99eb-af10-41b2-adc7-44320f4ef9eb 이렇게 뜨는 걸 -를 빼고 숫자와 확장자만 보이게 바꿔준다.
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							//위에 설정한 randomFileName으로 설정한 경로에 파일을 저장한다.
							File storeFile = new File(fileUploadDirectory+"/"+randomFileName);
							fileitem.write(storeFile.toPath());//저장
							
							//하나씩 Map형식으로 만든 후 모든 파일을 다 만들었으면 리스트에 넣어준다
							
							fileMap.put("originalName", originalName);
							fileMap.put("inputTagname", inputTagname);
							fileMap.put("saveName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							
							int width = 0;
							int height = 0;
							
							//title인지 body인지 구분해서 넣는다
							if("thumbnailImg".equals(inputTagname)) {//썸네일이면
								fileMap.put("fileType", "TITLE");
								
								// 썸네일로 변환 할 사이즈 지정한다.
								width = 350;
								height = 200;
								
							}else {//BODY 타입이면
								fileMap.put("fileType", "BODY");
								
								width = 120;
								height = 100;
							}
							
							// 썸네일로 변환 후 저장한다.
							Thumbnails.of(fileUploadDirectory+randomFileName)//해당 파일을
										.size(width, height)//사이즈를 변경해서
										.toFile(thumbnailDirectory + "thumbnail_"+randomFileName);//해당 이름으로 저장해줌
							
							// 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다.
							fileMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_"+randomFileName);
							
							fileList.add(fileMap);
							
							countPicture++;
							
						}
					}else {
						// 폼 데이터인 경우
						// name 얻어오기 : getFieldName value 얻어오기 : getString
						// 기본적인 인코딩이 ISO-8859-1로 처리되므로 UTF-8로 바꿔준다.
						// FileItem fileitem = fileItems.get(i);
						parameter.put(fileitem.getFieldName(), fileitem.getString());
						parameter.put(fileitem.getFieldName(), new String(fileitem.getString().getBytes("ISO-8859-1"),"UTF-8"));
						
					}
					
				}
				
				
				System.out.println("fileList : "+fileList);
				System.out.println("parameter: "+parameter);
				
				//이제 해당 정보들로 DTO 객체 생성
				
				CommunityDTO community = new CommunityDTO(); 
				community.setCommunityTitle(parameter.get("communityTitle"));
				community.setCommunityBody(parameter.get("communityBody"));
				//세션에서 로그인 되어있는 회원의 userNo를 가지고 온다.
				community.setUserNo(((UserDTO)request.getSession().getAttribute("loginUser")).getUserNo());
				 
				//PictureDTO 형식의 List를 만들어서 넣는다.
				List<PictureDTO> pictureList = new ArrayList<PictureDTO>();
				
				// 만든 List에 fileList에 있는 것들을 꺼내서 담아준다.
				// List<Map<String, String>> fileList
				// fileList에는 사진의 정보들이 차례대로 들어가있다.
				for (int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					PictureDTO picture = new PictureDTO();
					picture.setOriginalName(file.get("originalName"));
					picture.setSaveName(file.get("saveName"));
					picture.setSavePath(file.get("savePath"));
					picture.setFileType(file.get("fileType"));
					picture.setThumbnailPath(file.get("thumbnailPath"));
					
					pictureList.add(picture);
					

				}
				community.setPictureList(pictureList);
				
				System.out.println("community board :" + community);
				
				int result = new CommunityService().insertCommunityWithPic(community);
				System.out.println(result);
				String path="";
				if(result>0) {
					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "communityInsert");
					request.setAttribute("message", "게시글이 등록되었습니다!");
				}else {
					path = "/WEB-INF/views/common/fail.jsp";
					request.setAttribute("code", "communityInsert");
					request.setAttribute("message", "게시글 등록에 실패했습니다");
				}
				request.getRequestDispatcher(path).forward(request, response);
				
			} catch (Exception e) {
				//어떤 종류의 Exception이 발생하더라도 실패 시 파일 삭제!
				int cnt = 0;
				for (int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					File deleteFile = new File(fileUploadDirectory + "/" + file.get("saveName"));
					boolean isDeleted = deleteFile.delete();
					
					if(isDeleted) {
						cnt++;
					}
				}
				
				if(cnt == fileList.size()) {
					System.out.println("업로드에 실패한 모든 사진 삭제 완료!");
					e.printStackTrace();
				}else {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
