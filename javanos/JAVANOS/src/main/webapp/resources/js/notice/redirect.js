
/* 인수로 전달된 값을 기반으로 url 경로를 설정, 해당 경로로 페이지를 이동시킴 */
/* 작성페이지 이동 */
function moveLocation(insert) {
	
	// movePath 변수에 기본경로 /jsp 로 설정
	var movePath = "/jsp";
	
	// insert 값에 따라 경로에 url 추가
	switch(insert) {
		
		case "/" : movePath += "/"; break;
		case "insertNotice" : movePath += "/notice/insert"; break;
		
	}
	
	// location.href = 해당 경로 : 경로로 현재 페이지 이동시킴
	location.href = movePath;
	
}