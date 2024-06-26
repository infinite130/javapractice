-- TBL_USER
INSERT INTO TBL_USER (USER_ID, USER_PWD, USER_NAME, USER_NICKNAME, USER_EMAIL, USER_ROLE) 
VALUES ('admin', 'admin', '관리자', '관리자', 'admin@google.com', 'ROLE_ADMIN');

-- TBL_STATION
INSERT INTO TBL_STATION (STA_CODE, STA_NAME, STA_LINE) VALUES
(340, '가락시장', '3호선'),
(2548, '천호', '5호선');

-- TBL_LNF
INSERT INTO TBL_LNF (LNF_MISSING, LNF_FIND_DATE, LNF_FIND_TIME, LNF_KEEP, LNF_DESCRIPTION, LNF_WRITER_NO, LNF_STA_NO) VALUES 
('냉장고', '2024-06-20', '12:30:00', '가락시장역 3호선 역사', '냉장고를 어떻게 가지고 다니시죠?', 1, 1),
('지갑', '2024-06-21', '10:15:00', '발견 장소', '저 민증 3개 있어요. 잃어버려서 재발급 2번 했어요. 근데 집에서 다시 찾았어요.', 1, 2);


--- TBL_LNF
INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("제목1","내용1",2);
INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("제목2","내용2",2);

INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("사진있는 게시글 제목3","사진 있는 게시글 내용3",3);
INSERT INTO TBL_PIC(SAVED_NAME,SAVE_PATH,FILE_TYPE,THUMBNAIL_PATH,COMMUNITY_NO) VALUES("사진 저장되는 이름","로컬에 저장되는 주소","TITLE","서버에 저장되는 주소",3);

INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("사진있는 게시글 제목4","사진 있는 게시글 내용4",3);
INSERT INTO TBL_PIC(SAVED_NAME,SAVE_PATH,FILE_TYPE,THUMBNAIL_PATH,COMMUNITY_NO) VALUES("사진 저장되는 이름","로컬에 저장되는 주소","TITLE","서버에 저장되는 주소",4);
INSERT INTO TBL_PIC(SAVED_NAME,SAVE_PATH,FILE_TYPE,THUMBNAIL_PATH,COMMUNITY_NO) VALUES("사진 저장되는 이름","로컬에 저장되는 주소","BODY","서버에 저장되는 주소",4);
INSERT INTO TBL_PIC(SAVED_NAME,SAVE_PATH,FILE_TYPE,THUMBNAIL_PATH,COMMUNITY_NO) VALUES("사진 저장되는 이름","로컬에 저장되는 주소","BODY","서버에 저장되는 주소",4);

-- TBL_NOTICE
INSERT INTO TBL_NOTICE(NOTICE_NO, NOTICE_TITLE, NOTICE_BODY, NOTICE_ENROLL_DATE, NOTICE_MODIFY_DATE, NOTICE_COUNT, NOTICE_BOARD_STATUS, NOTICE_USER_NO)
VALUES (1, '첫 공지', '첫번째 공지글 입니다.', CURRENT_TIMESTAMP, NULL, DEFAULT, 'Y', 1);

-- TBL_REPORT 
INSERT INTO TBL_REPORT (REPORT_REASON, REPORT_DATE, REPORT_STATUS, REPORT_USER_NO, REPORTED_USER_NO, COMMUNITY_NO)
VALUES ('모욕적인 글 작성', CURRENT_TIMESTAMP, 'Y', 1, 2, 2);

-- TBL_DOWN
INSERT INTO TBL_DOWN (DOWN_ROOM , DOWN_FULL, DOWN_USER_NO, DOWN_STA_NO, IN_STA_NO) VALUES
         ('2-1칸', '상', 1,1,1),
			   ('3-2칸', '중', 1,2,2);

-- COMMIT;