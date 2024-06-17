package com.ohgiraffers.auth.admin.model.dto;

import java.util.Date;

public class MemberDTO  {
	
	// TODO 2+ 관리자는 회원번호, 회원ID, 회원명, 등록일자 정보만 봐도 되므로 관리자용 DTO 추가
	// 이때, DTO의 요건을 맞춰줘야 함
	
	private int memberNo;
	private String memberId;
	private String memberName;
	private Date enrollDate;
	
	
	public MemberDTO() {
		super();
	}


	public MemberDTO(int memberNo, String memberId, String memberName, Date registDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.enrollDate = registDate;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public Date getRegistDate() {
		return enrollDate;
	}


	public void setRegistDate(Date registDate) {
		this.enrollDate = registDate;
	}


	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", registDate=" + enrollDate + "]";
	}
	
	
	
	
	
	

}
