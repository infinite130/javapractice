package com.javanos.project.community.model.service;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

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

	public List<CommunityDTO> selectThumbnailList() {
		SqlSession session = getSqlSession();
		communityDAO = session.getMapper(CommunityDAO.class);

		List<CommunityDTO> communityList = communityDAO.selectThumbnailList();

		session.close();
		return communityList;

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
		
		for (Integer removedPicNo : removedPicNos) { 
			  result += communityDAO.deletePictures(removedPicNo); 
		 }
		
		if(result>0) {
			System.out.println("삭제 버튼 누른 사진들 DB에 삭제완료!");
			result = communityDAO.updateCommunity(community);
			if (result > 0) {

				List<PictureDTO> pictureList = community.getPictureList();
				int pictureResult = 0;
				for (PictureDTO pictureDTO : pictureList) {
					System.out.println("pictureList 반복중");
					pictureDTO.setCommunityNo(community.getCommunityNo());
					pictureResult += communityDAO.insertPicture(pictureDTO);
				}

				if (pictureResult > 0) {
					System.out.println("새로 넣은 수정 이미지 DB에 삽입 성공!");
					session.commit();
					result = 1;
				} else {
					System.out.println("새로 넣은 수정 이미지 DB에 삽입 실패!");
					session.rollback();
					result = 0;
				}

			} else {
				session.rollback();
				System.out.println("DB에 수정 실패!");
				result = 0;
			}
		}else {
			session.rollback();
			System.out.println("DB에 수정 실패!");
			result = 0;
		}
		
		session.close();

		return result;

	}
}
