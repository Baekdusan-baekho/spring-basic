<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="../include/header.jsp" %>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form action="${pageContext.request.contextPath }/freeboard/modify" method="post" name="updateForm"> 
                            <!-- 폼 네임은 (document.updateFrom) 네임을 달면 요소를 지목할 수 있다 -->
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='bno' value="${article.bno }" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='writer' value="${article.writer }" readonly>
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${article.title }">
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content'>${article.content }</textarea>
                            </div>

                            <button id="list-btn" type="button" class="btn btn-dark">목록</button>    
                            <button id="update-btn" type="button" class="btn btn-primary">변경</button>
                            <button id="del-btn" type="button" class="btn btn-info">삭제</button>
                            <!-- 변경 삭제는 get / form에서는 action1개 밖에 못 씀 그래서 변경 삭제 액션을 자바스크립트로 변경 -->
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
        
        <%@ include file="../include/footer.jsp" %>

        <script>
            // 목록 이동 처리
            document.getElementById('list-btn').onclick = function(){
                location.href='${pageContext.request.contextPath }/freeboard/freeList';
            }

            // form 태그는 메서드 없이 form 태그의 name으로 요소를 바로 취득할 수 있습니다.
            const $form = document.updateForm;


            // 수정 버튼 이벤트
            document.getElementById('update-btn').onclick = function(){
                // form 내부의 요소를 지목할 때 name속성으로 바로 지목 가능
                if($form.title.valus === ''){
                    alert('제목은 필수 항목입니다.');
                    return;
                } else if($form.content.value === '' ){
                    alert('내용을 뭐라도 작성해 주세요!')
                    return;
                }
                //문제가 없다면 form을 submit
                $form.submit();
            }

            // 삭제 버튼 이벤트
            document.getElementById('del-btn').onclick = () => {
                // 화살표 함수로 function(익명함수)을 대체함
                if(confirm('정말 삭제하시겠습니까?')){
                    //confirm 확인 취소가 있는 alert같은 창

                    //$form.attr('action', '${pageContext.request.contextPath }.freeboard')
                    //제이쿼리로 속성 바꾸는 방법

                    // $form.setAttribute('method', 'get');
                    // 바닐라로 속성 작성하는 방법
                    $form.setAttribute('action', '${pageContext.request.contextPath }/freeboard/delete');
                    $form.submit();
                }
            }



        </script>
      