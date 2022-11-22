<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="board.header.register.reply" /></h2>

<form:form modelAttribute="board" action="register">


	<form:hidden path="originNo" value="${param.originNo}" />
	<form:hidden path="groupLayer" value="1" />

	<table>
		<tr>
			<td><spring:message code="board.title" /></td>
			<td>"${param.originNo}"<form:input path="title" /></td>
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
	<sec:authorize access="isAuthenticated()">
        <button type="submit" id="btnRegister">
        	<spring:message code="action.register" />
        </button>
	</sec:authorize>
	
	<button type="submit" id="btnList">
		<spring:message code="action.list" />
	</button>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		var formObj = $("#board");

		$("#btnRegister").on("click", function() {
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "list";
		});

	});

</script>
