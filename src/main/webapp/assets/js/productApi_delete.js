/**
 * 상품 삭제 (delete)
 */

 document.querySelector('#delete').addEventListener('click',function(){
	const pcode = prompt('삭제할 상품 코드를 입력하세요')	 
	 
	  console.log('삭제 상품 코드 :',pcode)
	  
	 //비동기 통신(ajax) delete 메소드로 삭제를 구현해 보세요.
	 // 	delete는 페이로드 전달 못 합니다. pcode는 url 파라미터로 보내세요
	 
	 const xhr = new XMLHttpRequest()
	 xhr.open('DELETE','api/product?pcode='+pcode)
	 xhr.send()
	 xhr.onload = function(){
		 	if(resultObj.result ===1){
				alert(' 상품 삭제가 완료되었습니다.')
				clear()
				modal.hide()
				selectAll();
				}else{
			alert('상품 등록 오류 입니다. pcode 중복 주의하세요')
	 }
	 }
 })