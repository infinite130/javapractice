
// 브라우저가 페이지 로딩된 후 이 함수 실행 

// onclick 버튼에 클릭이벤트 핸들러를 추가함. -> 버튼 클릭 시 특정 url로 이동함
// 작성 페이지에서 작성, 취소 버튼

window.onload = function() {
	
	// writeNotice id 있는지 확인
	if(document.getElementById("writeNotice")){
		const $writeNotice = document.getElementById("writeNotice");
		$writeNotice.onclick = function(){
				// 작성버튼 누르면 작성페이지로 이동함
				location.href = "/notice/insert";
		}
	}
	
	// cancleNotice id 있는지 확인
	if(document.getElementById("cancleNotice")){
		const $cancleNotice = document.getElementById("cancleNotice");
		$writeNotice.onclick = function(){
				// 취소버튼 누르면 공지사항 목록 으로 이동함
				location.href = "/notice/list";
		}
	}
	
}