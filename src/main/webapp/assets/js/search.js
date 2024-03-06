/**
 * 		상품 조회 검색어 입력을 확인하기 위한 내용입니다.
 */
document.querySelector('#search').addEventListener('click',function(){
const category = document.querySelector('select[name="category"]')
const keyword = document.querySelector('input[name="keyword"]')
const from = document.querySelector('input[name="from"]')
const to = document.querySelector('input[name="to"]')

console.log(category)
console.log(keyword)
console.log(from)
console.log(to)
if(category.length==0&& keyword.length==0
	&& from.length==0 && to.length==0
	){
		alert('검색어를 입력하세요.')
		return
	}
//2.입력값으로 자바스크립트 객체 생성
const jsonObj ={}

if(category.length !=0)jsonObj.category=category;
if(keyword.length !=0)jsonObj.keyword=keyword;
if(from.length !=0)jsonObj.from=from;
if(to.length !=0)jsonObj.to=to;

console.log("자바스크립트 객체 :" ,jsonObj)
//3.자바스크립트 객체를 json 전송을 위해 직렬화
const jsonData = JSON.stringify(jsonObj)
//put 요청 시작
search_product(jsonData)
})

const search_product = function(jsonData){
	console.log("json 문자열 :" , jsonData)
	//PUT 은 REST 방식에서 수정동작을 의미하지만, 검색값을 페이로드 전달하기 위해 사용해봅니다.
	// node.js 서버와 동작할 때는 주의해야 합니다. 우리 예제에서는 PUT 대신 POST 를 사용해도 됩니다
	// PUT,PATCH,DELETE등 다른 메소드 방식도 REST API 에 있다는 것을 보여주는 예시입니다.
	xhr.open('PUT','api/product')

	xhr.setReqeustHeader("Content-Type","application/json; charset = UTF-8")






}

