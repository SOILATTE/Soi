<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="board.header.modify" /></h2>

<form:form modelAttribute="board" action="modify">
	<form:hidden path="boardNo" />

	<input type="hidden" name="page" value="${pgrq.page}">
	<input type="hidden" name="searchType" value="${pgrq.searchType}">
	<input type="hidden" name="keyword" value="${pgrq.keyword}">
	
	<table>
		<tr>
			<td><spring:message code="board.title" /></td>
			<td><form:input path="title" /></td>
			<td><form:errors path="title" class="error_message" /></td>
		</tr>
		<tr>
			<td><spring:message code="board.writer" /></td>
			<td><form:input path="writer" readonly="true" /></td>
			<td><form:errors path="writer" class="error_message" /></td>
		</tr>
		<tr>
			<td><spring:message code="board.content" /></td>
			<td><form:textarea path="content" /></td>
			<td><form:errors path="content" class="error_message" /></td>
		</tr>
	</table>
</form:form>

<div>
	<sec:authentication property="principal" var="pinfo" />

	<sec:authorize access="hasRole('MEMBER')">
		<c:if test="${pinfo.username eq board.writer}">
			<button type="submit" id="btnModify"><spring:message code="action.modify" /></button>
		</c:if>
	</sec:authorize>

	<button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#board");

		$("#btnModify").on("click", function() {
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "list${pgrq.toUriString()}";
		});

	});
</script>
