window.onload = function() {
	
	if(document.getElementById("writeNotice")){
		const $writeNotice = document.getElementById("writeNotice");
		$writeNotice.onclick = function(){
				location.href = "/project/notice/insert";
		}
	}
	
	if(document.getElementById("cancleNotice")){
		const $cancleNotice = document.getElementById("cancleNotice");
		$writeNotice.onclick = function(){
				location.href = "/project/notice/list";
		}
	}
	
	
}