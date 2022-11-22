<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="user.header.register" /></h2>

<form:form modelAttribute="member" action="setup">
	<table>
		<tr>
			<td><spring:message code="user.userId" /></td>
			<td><form:input path="userId" /></td>
			<td><form:errors path="userId" class="error_message" /></td>
		</tr>
		<tr>
			<td><spring:message code="user.userPw" /></td>
			<td><form:password path="userPw" /></td>
			<td><form:errors path="userPw" class="error_message" /></td>
		</tr>
		<tr>
			<td><spring:message code="user.userName" /></td>
			<td><form:input path="userName" /></td>
			<td><form:errors path="userName" class="error_message" /></td>
		</tr>
	</table>
</form:form>

<div>
	<button type="submit" id="btnRegister"><spring:message code="action.register" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#member");

		$("#btnRegister").on("click", function() {
			formObj.submit();
		});

	});
</script>
