package com.javanos.project.community.model.dao;

import java.util.List;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.dto.PictureDTO;

public interface CommunityDAO {

	List<CommunityDTO> selectAllCommunityList();

	CommunityDTO selectOneCommunity(int communityNo);

	int updateCommunity(CommunityDTO updateCommunity);

	int deleteCommunity(int communityNo);

	int insertCommunityTitleAndBody(CommunityDTO community);

	int insertPicture(PictureDTO pictureDTO);


}
