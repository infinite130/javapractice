package com.javanos.project.community.model.dao;

import java.util.List;

import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.dto.PictureDTO;

public interface CommunityDAO {

	/* List<CommunityDTO> selectThumbnailList(); */
	
	CommunityDTO selectOneThumbnailList(int communityNo);

	// delete 기능을 하지만 실제로는 update문을 진행시킴(게시글 삭제일 때)
	int deleteCommunity(int communityNo);
	int deletePicture(int communityNo);
	
	// update 기능을 하지만 실제로는 해당 picNo 삭제후 새로 들어오는 사진들을 추가함(게시글 수정)
	//사진 있는 게시글인지 파악 하기 위해 사용함-> 사진이 있으면 삭제버튼 클릭시 삭제하기 위해
	int selectCountPicture(int communityNo);
	int deletePictures(int removedPicNo);
	int updatePicture(PictureDTO pictureDTO);
	int updateCommunity(CommunityDTO community);

	// 게시글 insert 기능 
	int insertCommunityTitleAndBody(CommunityDTO community);
	int insertPicture(PictureDTO pictureDTO);
	
	// 조회수 카운트 기능
	int incrementCommunityCount(int communityNo);


	// 조회하기
	List<CommunityDTO> selectThumbnailList(SelectCriteria selectCriteria);

	int selectTotalCount();





}
