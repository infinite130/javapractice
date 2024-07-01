package com.javanos.project.community.model.service;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.community.model.dao.CommunityDAO;
import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.dto.PictureDTO;

import jakarta.servlet.annotation.WebServlet;

import static com.javanos.project.common.mybatis.Template.getSqlSession;

public class CommunityService {

	private CommunityDAO communityDAO;

	public int deleteCommunityWithPic(int communityNo) {

		SqlSession session = getSqlSession();

		communityDAO = session.getMapper(CommunityDAO.class);

		int result = communityDAO.selectCountPicture(communityNo);
		System.out.println("selectCountPicture : " + result);

		if (result > 0) {// 사진 있는 게시판
			result = communityDAO.deletePicture(communityNo);
			System.out.println("deletePicture : " + result);
		} else {
			System.out.println("사진 없는 게시판");
		}

		result = communityDAO.deleteCommunity(communityNo);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
			result = 0;
		}

		session.close();

		return result;

	}

	public int insertCommunityWithPic(CommunityDTO community) {

		System.out.println(community);

		SqlSession session = getSqlSession();
		communityDAO = session.getMapper(CommunityDAO.class);

		int result = communityDAO.insertCommunityTitleAndBody(community);

		if (result > 0) {
			List<PictureDTO> pictureList = community.getPictureList();
			int pictureResult = 0;
			for (PictureDTO pictureDTO : pictureList) {
				pictureDTO.setCommunityNo(community.getCommunityNo());
				pictureResult += communityDAO.insertPicture(pictureDTO);
			}

			if (pictureResult == pictureList.size()) {
				session.commit();
				result = 1;
			} else {
				session.rollback();
				result = 0;
			}
		} else {
			session.rollback();
			result = 0;
		}

		session.close();
		return result;

	}


	public CommunityDTO selectOneThumbnailList(int communityNo) {

		SqlSession session = getSqlSession();
		communityDAO = session.getMapper(CommunityDAO.class);

		CommunityDTO community = null;

		int result = communityDAO.incrementCommunityCount(communityNo);

		if (result > 0) {

			community = communityDAO.selectOneThumbnailList(communityNo);

			if (community != null) {
				session.commit();
			} else {
				session.rollback();
			}

		} else {
			session.rollback();
		}

		session.close();
		return community;
	}


	public int updateCommunityWithPic(CommunityDTO community, List<Integer> removedPicNos) {
		SqlSession session = getSqlSession();
		communityDAO = session.getMapper(CommunityDAO.class);

		int result = 0;
		
		//업데이트 할 제목이나 내용 있으면 하기
		if(community.getCommunityTitle()!=null || community.getCommunityBody()!=null ) {
			System.out.println("수정할 제목이나 내용이 있습니다.");
			result = communityDAO.updateCommunity(community);
			System.out.println("제목이나 내용을 수정했습니다!");
			
			if(result>0) {//제목이나 내용을 잘 수정했다면
				result=0;
				
				//삭제버튼 누른거 먼저 삭제하기
				if(removedPicNos.size()>0) {
					System.out.println("삭제 버튼을 누른 사진이 있어 삭제중입니다.");
					for (Integer removedPicNo : removedPicNos) { 
						result += communityDAO.deletePictures(removedPicNo); 
					}
					
					if(result>0) { //삭제를 잘 했다면
						System.out.println("삭제 버튼 누른 사진들 DB에 삭제완료!");
						
						//추가된 사진이 있으면 추가하기
						if(community.getPictureList().size()>0) {
							System.out.println("추가된 사진이 있어 추가 중입니다.");
							List<PictureDTO> pictureList = community.getPictureList();
							int pictureResult = 0;
							for (PictureDTO pictureDTO : pictureList) {
								System.out.println("pictureList 반복중");
								pictureDTO.setCommunityNo(community.getCommunityNo());
								pictureResult += communityDAO.insertPicture(pictureDTO);
							}
							if (pictureResult > 0) {
								System.out.println("수정 페이지에서 추가된 이미지 DB에 삽입 성공!");
								session.commit();
								result = 1;
							} else {
								System.out.println("수정 페이지에서 추가된 이미지 DB에 삽입 실패!XXXXXXXXXXXX");
								session.rollback();
								result = 0;
							}
						}else {
							System.out.println("추가된 사진이 업습니다 업데이트를 완료합니다");
							session.commit();
							result = 1;
						}
						
					}else {//삭제 사진 삭제 실패!
						System.out.println("삭제버튼 사진 DB에 수정 실패!XXXXXXXXXXXX");
						session.rollback();
						result = 0;
					}
				}else {
					System.out.println("삭제 버튼을 누른 사진이 없습니다.");
					
					//추가된 사진이 있으면 추가하기
					if(community.getPictureList().size()>0) {
						System.out.println("추가된 사진이 있어 추가 중입니다.");
						List<PictureDTO> pictureList = community.getPictureList();
						int pictureResult = 0;
						for (PictureDTO pictureDTO : pictureList) {
							System.out.println("pictureList 반복중");
							pictureDTO.setCommunityNo(community.getCommunityNo());
							pictureResult += communityDAO.insertPicture(pictureDTO);
						}
						if (pictureResult > 0) {
							System.out.println("수정 페이지에서 추가된 이미지 DB에 삽입 성공!");
							session.commit();
							result = 1;
						} else {
							System.out.println("수정 페이지에서 추가된 이미지 DB에 삽입 실패!XXXXXXXXXXXX");
							session.rollback();
							result = 0;
						}
					}else {
						System.out.println("추가된 사진이 없습니다. 수정을 완료합니다.");
						session.commit();
						result = 1;
					}
				}
			}else {//제목이나 내용 수정에 실패했다면
				System.out.println("제목이나 내용 DB에서 수정 실패!XXXXXXXXXXXX");
				session.rollback();
				result = 0;
			}
		}else {
			System.out.println("수정할 제목이나 내용이 없습니다.");
			
			//삭제버튼 누른거 있으면 삭제하기
			if(removedPicNos.size()>0) {
				System.out.println("삭제 버튼을 누른 사진이 있어 삭제중입니다.");
				for (Integer removedPicNo : removedPicNos) { 
					result += communityDAO.deletePictures(removedPicNo); 
				}
				if(result>0) { //삭제를 잘 했다면
					System.out.println("삭제 버튼 누른 사진들 DB에 삭제완료!");
					
					//추가된 사진이 있으면 추가하기
					if(community.getPictureList().size()>0) {
						System.out.println("추가된 사진이 있어 추가 중입니다.");
						List<PictureDTO> pictureList = community.getPictureList();
						int pictureResult = 0;
						for (PictureDTO pictureDTO : pictureList) {
							System.out.println("pictureList 반복중");
							pictureDTO.setCommunityNo(community.getCommunityNo());
							pictureResult += communityDAO.insertPicture(pictureDTO);
						}
						if (pictureResult > 0) {
							System.out.println("수정 페이지에서 추가된 이미지 DB에 삽입 성공!");
							session.commit();
							result = 1;
						} else {
							System.out.println("수정 페이지에서 추가된 이미지 DB에 삽입 실패!XXXXXXXXXXXX");
							session.rollback();
							result = 0;
						}
					}else {
						System.out.println("추가된 사진이 업습니다 업데이트를 완료합니다");
						session.commit();
						result = 1;
					}
					
				}else {//삭제 사진 삭제 실패!
					System.out.println("삭제버튼 사진 DB에 수정 실패!XXXXXXXXXXXX");
					session.rollback();
					result = 0;
				}
			}else {
				System.out.println("삭제 버튼을 누른 사진이 없습니다.");
				
				//추가된 사진이 있으면 추가하기
				if(community.getPictureList().size()>0) {
					System.out.println("추가된 사진이 있어 추가 중입니다.");
					List<PictureDTO> pictureList = community.getPictureList();
					int pictureResult = 0;
					for (PictureDTO pictureDTO : pictureList) {
						System.out.println("pictureList 반복중");
						pictureDTO.setCommunityNo(community.getCommunityNo());
						pictureResult += communityDAO.insertPicture(pictureDTO);
					}
					if (pictureResult > 0) {
						System.out.println("수정 페이지에서 추가된 이미지 DB에 삽입 성공!");
						session.commit();
						result = 1;
					} else {
						System.out.println("수정 페이지에서 추가된 이미지 DB에 삽입 실패!XXXXXXXXXXXX");
						session.rollback();
						result = 0;
					}
				}else {
					System.out.println("추가된 사진이 없습니다. 수정을 완료합니다.");
					session.commit();
					result = 1;
				}
			}
			
		} 


		
		session.close();
		
		return result;
		
	}
	
	

	public List<CommunityDTO> selectThumbnailList(SelectCriteria selectCriteria) {
		SqlSession session = getSqlSession();
		communityDAO = session.getMapper(CommunityDAO.class);

		selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);
		
		System.out.println(selectCriteria.getStartRow());
		List<CommunityDTO> communityList = communityDAO.selectThumbnailList(selectCriteria);

		session.close();
		return communityList;
	
	}

	public int selectTotalCount() {
		SqlSession session = getSqlSession();
		communityDAO = session.getMapper(CommunityDAO.class);
		
		int totalCount = communityDAO.selectTotalCount();
		
		session.close();
		return totalCount;
	
	
	}
}
