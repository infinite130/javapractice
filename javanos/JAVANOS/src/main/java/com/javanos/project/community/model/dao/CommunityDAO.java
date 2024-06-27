package com.javanos.project.community.model.dao;

import java.util.List;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.dto.PictureDTO;

public interface CommunityDAO {

	
	/*
	 * List<CommunityDTO> selectAllCommunityList();
	 * 
	 * CommunityDTO selectOneCommunity(int communityNo);
		int updateCommunity(CommunityDTO updateCommunity);
	 */
	List<CommunityDTO> selectThumbnailList();
	
	CommunityDTO selectOneThumbnailList(int communityNo);

	int deleteCommunity(int communityNo);

	int insertCommunityTitleAndBody(CommunityDTO community);

	int insertPicture(PictureDTO pictureDTO);

	int incrementCommunityCount(int communityNo);

	int updateCommunity(CommunityDTO community);

	int updatePicture(PictureDTO pictureDTO);

	int deletePicture(int communityNo);




}
