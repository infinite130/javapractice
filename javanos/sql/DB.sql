-- CREATE DATABASE JAVANOS;
-- GRANT ALL PRIVILEGES ON JAVANOS.* TO 'songpa'@'%';
-- USE javanos;

CREATE TABLE TBL_USER(
  USER_NO INT AUTO_INCREMENT PRIMARY KEY,
  USER_ID VARCHAR(50) UNIQUE,
  USER_PWD VARCHAR(255) NOT NULL,
  USER_NAME VARCHAR(50) NOT NULL,
  USER_NICKNAME VARCHAR(50) NOT NULL,
  USER_EMAIL VARCHAR(50) NOT NULL,
  USER_ROLE VARCHAR(15) DEFAULT 'ROLE_USER' CHECK(USER_ROLE IN ('ROLE_USER', 'ROLE_ADMIN')),
  USER_ENROLL_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
  USER_STATUS VARCHAR(2) DEFAULT 'Y' CHECK(USER_STATUS IN ('Y', 'N')),
  USER_STOP_DATE DATETIME
); 

/* TBL_USER 테이블에 관리자 계정 추가*/
INSERT INTO TBL_USER (USER_ID, USER_PWD, USER_NAME, USER_NICKNAME, USER_EMAIL, USER_ROLE) 
VALUES ('admin', 'admin', '관리자', '관리자', 'admin@google.com', 'ROLE_ADMIN');

CREATE TABLE TBL_STATION(
	STA_NO INT AUTO_INCREMENT PRIMARY KEY COMMENT '역 번호(PK)',
    STA_CODE VARCHAR(5) UNIQUE COMMENT '역 코드',
    STA_NAME VARCHAR(20) NOT NULL COMMENT '역명',
    STA_LINE VARCHAR(10) NOT NULL COMMENT '호선'
);

CREATE TABLE TBL_LNF(
  LNF_NO INT AUTO_INCREMENT PRIMARY KEY COMMENT '게시판 번호(PK)',
  LNF_MISSING VARCHAR(100) NOT NULL COMMENT '분실 품목 - 사용자 입력 받음',
  LNF_FIND_DATE DATE DEFAULT (CURRENT_DATE) NOT NULL COMMENT '발견일 - 사용자 입력 받음',
  LNF_FIND_TIME TIME DEFAULT (CURRENT_TIME) COMMENT '발견 시간 - 사용자 입력 받음',
  LNF_KEEP VARCHAR(100) NOT NULL COMMENT '보관 장소 - 사용자 입력 받음',
  LNF_DESCRIPTION VARCHAR(4000) COMMENT '내용 - 사용자 입력 받음',
  LNF_ENROLL_DATE DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '작성일',
  LNF_MODIFY_DATE DATETIME DEFAULT NULL COMMENT '수정일',
  LNF_BOARD_STATUS VARCHAR(2) DEFAULT 'Y' CHECK(LNF_BOARD_STATUS IN ('Y', 'N')) NOT NULL COMMENT '게시판 상태',
  LNF_WRITER_NO INT NOT NULL COMMENT '회원 번호(FK) - 사용자 입력 받음 (조회)',
  LNF_STA_NO INT NOT NULL COMMENT '역 번호(FK) - 사용자 입력 받음 (필터)',
  FOREIGN KEY (LNF_WRITER_NO) REFERENCES TBL_USER (USER_NO),
  FOREIGN KEY (LNF_STA_NO) REFERENCES TBL_STATION (STA_NO)
);

CREATE TABLE TBL_COMMUNITY (
    COMMUNITY_NO INT AUTO_INCREMENT PRIMARY KEY,
    COMMUNITY_TITLE VARCHAR(255) NOT NULL,
    COMMUNITY_BODY VARCHAR(255) NOT NULL,
    COMMUNITY_COUNT INT DEFAULT 0,
    COMMUNITY_ENROLL_DATE DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    COMMUNITY_MODIFY_DATE DATETIME,
    COMMUNITY_BOARD_STATUS VARCHAR(2) DEFAULT 'Y' NOT NULL,
    USER_NO INT NOT NULL,
    FOREIGN KEY (USER_NO) REFERENCES TBL_USER (USER_NO)
);

CREATE TABLE TBL_PIC (
    PIC_NO INT AUTO_INCREMENT PRIMARY KEY,
    ORIGINAL_NAME VARCHAR(255) NOT NULL,
    SAVED_NAME VARCHAR(255) NOT NULL,
    SAVE_PATH VARCHAR(1000) NOT NULL,
    FILE_TYPE VARCHAR(5) CHECK(FILE_TYPE IN ('TITLE', 'BODY')) NOT NULL,
	  THUMBNAIL_PATH VARCHAR(255) NOT NULL,
    PIC_BOARD_STATUS VARCHAR(1) DEFAULT 'Y',
    COMMUNITY_NO INT,
    FOREIGN KEY (COMMUNITY_NO) REFERENCES TBL_COMMUNITY (COMMUNITY_NO)
);

CREATE TABLE TBL_REPORT (
    REPORT_NO INT AUTO_INCREMENT PRIMARY KEY,
    REPORT_REASON VARCHAR(255),
    REPORT_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    REPORT_STATUS VARCHAR(255) DEFAULT 'Y' CHECK(REPORT_STATUS IN ('Y', 'N','계정정지완료')),
    REPORT_USER_NO INT,
    REPORTED_USER_NO INT,
    COMMUNITY_NO INT,
    FOREIGN KEY (REPORT_USER_NO) REFERENCES TBL_USER (USER_NO),
    FOREIGN KEY (REPORTED_USER_NO) REFERENCES TBL_USER (USER_NO),
    FOREIGN KEY (COMMUNITY_NO) REFERENCES TBL_COMMUNITY (COMMUNITY_NO)
);


CREATE TABLE TBL_NOTICE (
	NOTICE_NO INT AUTO_INCREMENT PRIMARY KEY,
	NOTICE_TITLE VARCHAR(100) NOT NULL,
	NOTICE_BODY VARCHAR(4000) NOT NULL,
	NOTICE_ENROLL_DATE DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	NOTICE_MODIFY_DATE DATETIME,
	NOTICE_COUNT INT DEFAULT 0,
	NOTICE_BOARD_STATUS VARCHAR(2) DEFAULT 'Y',
	NOTICE_USER_NO INT NOT NULL,
  FOREIGN KEY (NOTICE_USER_NO) REFERENCES TBL_USER (USER_NO)
);

CREATE TABLE TBL_DOWN(
	DOWN_NO INT AUTO_INCREMENT PRIMARY KEY,
	DOWN_ROOM  VARCHAR(20) NOT NULL,
	DOWN_FULL VARCHAR(15) NOT NULL,
	DOWN_ENROLL_DATE DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	DOWN_MODIFY_DATE DATETIME,
	DOWN_BOARD_STATUS VARCHAR(2) DEFAULT 'Y' CHECK(DOWN_BOARD_STATUS IN ('Y', 'N')),
	DOWN_USER_NO INT,
	DOWN_STA_NO INT,
	IN_STA_NO INT,
	FOREIGN KEY (DOWN_USER_NO) REFERENCES TBL_USER (USER_NO),
	FOREIGN KEY (DOWN_STA_NO) REFERENCES TBL_STATION (STA_NO),
	FOREIGN KEY (IN_STA_NO) REFERENCES TBL_STATION (STA_NO) 
);
