-- TBL_USER
INSERT INTO TBL_USER (USER_ID, USER_PWD, USER_NAME, USER_NICKNAME, USER_EMAIL, USER_ROLE) 
VALUES ('admin', 'admin', '관리자', '관리자', 'admin@google.com', 'ROLE_ADMIN');
INSERT INTO TBL_USER (USER_ID, USER_PWD, USER_NAME, USER_NICKNAME, USER_EMAIL) 
VALUES ('user01', 'user01', '사용자1', '사용자1', 'user01@google.com');
INSERT INTO TBL_USER (USER_ID, USER_PWD, USER_NAME, USER_NICKNAME, USER_EMAIL) 
VALUES ('user02', 'user02', '사용자2', '사용자2', 'user02@google.com');

-- TBL_STATION
INSERT INTO TBL_STATION (STA_CODE, STA_NAME, STA_LINE) VALUES
(340, '가락시장', '3호선'),
(2548, '천호', '5호선');

-- TBL_LNF
INSERT INTO TBL_LNF (LNF_MISSING, LNF_FIND_DATE, LNF_FIND_TIME, LNF_KEEP, LNF_DESCRIPTION, LNF_WRITER_NO, LNF_STA_NO) VALUES 
('냉장고', '2024-06-20', '12:30:00', '가락시장역 3호선 역사', '냉장고를 어떻게 가지고 다니시죠?', 1, 1),
('지갑', '2024-06-21', '10:15:00', '발견 장소', '저 민증 3개 있어요. 잃어버려서 재발급 2번 했어요. 근데 집에서 다시 찾았어요.', 1, 2);


--- TBL_COMMUNITY
INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("제목1","내용1",2);
INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("제목2","내용2",2);
INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("사진있는 게시글 제목3","사진 있는 게시글 내용3",3);
INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("사진있는 게시글 제목4","사진 있는 게시글 내용4",2);
INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) VALUES("사진있는 게시글 제목4","사진 있는 게시글 내용4",2);

INSERT INTO TBL_PIC(ORIGINAL_NAME,SAVED_NAME,SAVE_PATH,FILE_TYPE,THUMBNAIL_PATH,COMMUNITY_NO) VALUES("원본이름","사진 저장되는 이름","로컬에 저장되는 주소","TITLE","서버에 저장되는 주소",3);
INSERT INTO TBL_PIC(ORIGINAL_NAME,SAVED_NAME,SAVE_PATH,FILE_TYPE,THUMBNAIL_PATH,COMMUNITY_NO) VALUES("원본이름","사진 저장되는 이름","로컬에 저장되는 주소","BODY","서버에 저장되는 주소",3);
INSERT INTO TBL_PIC(ORIGINAL_NAME,SAVED_NAME,SAVE_PATH,FILE_TYPE,THUMBNAIL_PATH,COMMUNITY_NO) VALUES("원본이름","사진 저장되는 이름","로컬에 저장되는 주소","BODY","서버에 저장되는 주소",3);

-- TBL_NOTICE
INSERT INTO TBL_NOTICE(NOTICE_NO, NOTICE_TITLE, NOTICE_BODY, NOTICE_ENROLL_DATE, NOTICE_MODIFY_DATE, NOTICE_COUNT, NOTICE_BOARD_STATUS, NOTICE_USER_NO)
VALUES (1, '첫 공지', '첫번째 공지글 입니다.', CURRENT_TIMESTAMP, NULL, DEFAULT, 'Y', 1);

-- TBL_REPORT 
INSERT INTO TBL_REPORT (REPORT_REASON, REPORT_DATE, REPORT_STATUS, REPORT_USER_NO, REPORTED_USER_NO, COMMUNITY_NO)
VALUES ('모욕적인 글 작성', CURRENT_TIMESTAMP, 'Y', 1, 2, 2);

INSERT INTO TBL_USER (USER_ID, USER_PWD, USER_NAME, USER_NICKNAME, USER_EMAIL, USER_ROLE) 
VALUES 
    ('user2', 'user2', 'user2', 'user2', 'user2@google.com', 'ROLE_USER'),
    ('user3', 'user3', 'user3', 'user3', 'user3@google.com', 'ROLE_USER'),
    ('user4', 'user4', 'user4', 'user4', 'user4@google.com', 'ROLE_USER'),
    ('user5', 'user5', 'user5', 'user5', 'user5@google.com', 'ROLE_USER'),
    ('user6', 'user6', 'user6', 'user6', 'user6@google.com', 'ROLE_USER'),
    ('user7', 'user7', 'user7', 'user7', 'user7@google.com', 'ROLE_USER'),
    ('user8', 'user8', 'user8', 'user8', 'user8@google.com', 'ROLE_USER'),
    ('user9', 'user9', 'user9', 'user9', 'user9@google.com', 'ROLE_USER'),
    ('user10', 'user10', 'user10', 'user10', 'user10@google.com', 'ROLE_USER'),
    ('user11', 'user11', 'user11', 'user11', 'user11@google.com', 'ROLE_USER'),
    ('user12', 'user12', 'user12', 'user12', 'user12@google.com', 'ROLE_USER'),
    ('user13', 'user13', 'user13', 'user13', 'user13@google.com', 'ROLE_USER'),
    ('user14', 'user14', 'user14', 'user14', 'user14@google.com', 'ROLE_USER'),
    ('user15', 'user15', 'user15', 'user15', 'user15@google.com', 'ROLE_USER'),
    ('user16', 'user16', 'user16', 'user16', 'user16@google.com', 'ROLE_USER');


INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) 
VALUES
("제목4","내용4",4),
("제목5","내용5",5),
("제목6","내용6",6),
("제목7","내용7",7),
("제목8","내용8",8),
("제목9","내용9",9),
("제목10","내용10",10),
("제목11","내용11",11);

INSERT INTO TBL_COMMUNITY(COMMUNITY_TITLE,COMMUNITY_BODY,USER_NO) 
VALUES
("사진있는 게시글 제목4","사진 있는 게시글 내용4",4),
("사진있는 게시글 제목5","사진 있는 게시글 내용5",5),
("사진있는 게시글 제목6","사진 있는 게시글 내용6",6),
("사진있는 게시글 제목7","사진 있는 게시글 내용7",7),
("사진있는 게시글 제목8","사진 있는 게시글 내용8",8),
("사진있는 게시글 제목9","사진 있는 게시글 내용9",9),
("사진있는 게시글 제목10","사진 있는 게시글 내용10",10),
("사진있는 게시글 제목11","사진 있는 게시글 내용11",11);


INSERT INTO TBL_REPORT (REPORT_REASON, REPORT_DATE, REPORT_STATUS, REPORT_USER_NO, REPORTED_USER_NO, COMMUNITY_NO)
VALUES  ('글 도배', CURRENT_TIMESTAMP, 'Y', 1, 3, 3),
('이상한 말을 함', CURRENT_TIMESTAMP, 'Y', 2, 5, 15),
('공지사항 위반', CURRENT_TIMESTAMP, 'Y', 3, 6, 16),
('모욕적인 글 작성', CURRENT_TIMESTAMP, 'Y', 4, 7, 17),
('Hello', CURRENT_TIMESTAMP, 'Y', 5, 8, 18),
('World :D', CURRENT_TIMESTAMP, 'Y', 6, 9, 19),
('모욕적인 글 작성', CURRENT_TIMESTAMP, 'Y', 7, 10, 20),
('그냥요', CURRENT_TIMESTAMP, 'Y', 8, 11, 21),
('신고하고 싶어서', CURRENT_TIMESTAMP, 'Y', 9, 5, 22),
('글 도배', CURRENT_TIMESTAMP, 'Y', 10, 1, 5),
('공지사항 위반', CURRENT_TIMESTAMP, 'Y', 11, 4, 6),
('공지사항 위반', CURRENT_TIMESTAMP, 'Y', 12, 5, 7),
('졸려요...', CURRENT_TIMESTAMP, 'Y', 13, 6, 8),
('모욕적인 글 작성', CURRENT_TIMESTAMP, 'Y', 14, 7, 9);

-- TBL_DOWN
INSERT INTO TBL_DOWN (DOWN_ROOM , DOWN_FULL, DOWN_USER_NO, DOWN_STA_NO, IN_STA_NO) VALUES
         ('2-1칸', '상', 1,1,1),
			   ('3-2칸', '중', 1,2,2);

-- COMMIT;
