<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/header.jsp" %>

    <section>
       <div class="container">
            <div class="row">
                <div class="col-xs-12 content-wrap">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    
                    <form action="${pageContext.request.contextPath }/freeboard/freeRegist" method="post">
                        <table class="table">
                            <tbody class="t-control">
                                <tr>
                                    <td class="t-title">NAME</td>
                                    <td><input class="form-control input-sm" name="writer" value="${login }" readonly></td>
                                </tr>
                                <tr>
                                    <td class="t-title">TITLE</td>
                                    <td><input class="form-control input-sm" name="title"></td>
                                </tr>
                                <tr>
                                    <td class="t-title">COMMNET</td>
                                    <td>
                                    <textarea class="form-control" rows="7" name="content"></textarea>
                                    </td>
                                </tr>
                                <!-- 네임을 지정해야 들어간다 반드시 달아주어야 한다. -->
                            </tbody>
                        </table>
                        <div class="titlefoot">
                            <button type="submit" class="btn">등록</button>
                            <button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath }/freeboard/freeList'">목록</button>
                            <!-- 타입 기본: submit -->
                            
                        </div>
                    </form>
                    
                </div>
            </div>    
       </div>
    </section>
    
    <%@ include file="../include/footer.jsp" %>
  
  
  
  
  