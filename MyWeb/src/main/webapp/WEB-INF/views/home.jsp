<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>


<!--  주제정하기
	  어떤 서비스 구현할 것인지 의견 제시 블라블라블라
	  화면 어떤 식으로 나올지 와이어 프레임 뼈대 잡는다.
	  사용자에게 제공할 화면이 어떤 식으로 나올지 뼈대를 잡는다.
	  
	  우리사이트 사이트에서 어떤 기능을 구현해야 할 지 나옴
	  
	  데이터베이스 모델링 
	  작업 웹서비스에서 어떠한 테이블이 나와야 하는지 어떤 컬럼들이 나와야 하는지
	  어떠한 관계를 가지고 있는지 (회원테이블, 게시글테이블, 댓글 테이블) 회원->게시글 게시글->댓글 관계
	  foreign key primary key 지정 정규화하기
	  
	  DB 구축이 먼저!
	  와이어 프레임
	  DB 설계
	  데이터베이스 INSERT UPDATE DELETE SERECP 테스트
	  컨트롤러 서비스 생성
	  데이터베이스 연동 테스트 (가상 상태)
	  (화면 없는 상태)
	  매퍼 인터페이스 테스트 함 XML 파일을 만들어서
	  
	  다른 조원이 화면을 만들고 있음
	  
	  백엔드 준비 끝나면 프론트엔드에게 말해서 화면을 받는다.

 -->