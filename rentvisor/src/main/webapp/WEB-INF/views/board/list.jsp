<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



        
<h2><spring:message code="board.header.list" /></h2>
<h3>렌트바이저 고객님들의 이용후기들입니다.</h3>
<form:form modelAttribute="pgrq" method="get" action="list${pgrq.toUriStringForSearchAction(1)}">		
	<form:select path="searchType" items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" />
	<form:input path="keyword" />
	<button id='searchBtn'><spring:message code="action.search" /></button>
</form:form>



<sec:authorize access="hasRole('MEMBER')">
	<a href="register"><spring:message code="action.new" /></a>
</sec:authorize>

<table border="1">

	<tr>
		<th align="center" width="80"><spring:message code="board.no" /></th>
		<th align="center" width="320"><spring:message code="board.title" /></th>
		<th align="center" width="100"><spring:message code="board.writer" /></th>
		<th align="center" width="180"><spring:message code="board.regdate" /></th>
		<th align="center" width="50"><spring:message code="board.hits" /></th>
	</tr>
	
	<c:choose>
	
		<c:when test="${empty list}">
			<tr>
				<td colspan="4">
					<spring:message code="common.listEmpty" />
				</td>
			</tr>
		</c:when>
		
		<c:otherwise>
			<c:forEach items="${list}" var="board">
				<tr>
					<c:choose>
						<c:when test="${board.groupLayer == 1}">
							<td align="center">-</td>
							<td align="left"><span>&nbsp[답변]&nbsp</span><a href="/board/read${pgrq.toUriString()}&boardNo=${board.boardNo}&originNo=${board.originNo}"><c:out value="${board.title}" /></a></td>
						</c:when>
						<c:otherwise>
							<td align="center">${board.boardNo}</td>
							<td align="left"><a href="/board/read${pgrq.toUriString()}&boardNo=${board.boardNo}&originNo=${board.originNo}"><c:out value="${board.title}" /></a></td>	
						</c:otherwise>
					</c:choose>
					<td align="right">${board.writer}</td>
					<td align="center"><javatime:format pattern="yyyy-MM-dd HH:mm" value="${board.regDate}" /></td>
					<td align="center">${board.hitsNo }</td> 
				</tr>
			</c:forEach>
		</c:otherwise>
		
	</c:choose>
	
</table>

<div>
	<c:if test="${pagination.prev}">
		<a href="/board/list${pgrq.toUriStringByPage(pagination.startPage - 1)}">PREV</a>
	</c:if>

	<c:forEach begin="${pagination.startPage }" end="${pagination.endPage }" var="idx">
		<a href="/board/list${pgrq.toUriStringByPage(idx)}">${idx}</a>
	</c:forEach>
	
	<c:if test="${pagination.next && pagination.endPage > 0}">
		<a href="/board/list${pgrq.toUriStringByPage(pagination.endPage + 1)}">NEXT</a>
	</c:if>
</div>

<script>
	var result = "${msg}";

	if (result === "SUCCESS") {
		alert("<spring:message code='common.processSuccess' />");
	}
</script>
