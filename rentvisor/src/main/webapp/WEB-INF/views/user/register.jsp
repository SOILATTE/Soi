<%@ page contentType="text/html;charset=UTF-8" %> <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>
	<spring:message code="user.header.register" />
</h2>

<form:form modelAttribute="member" action="register">
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
		<tr>
			<td><spring:message code="user.job" /></td>
			<td><form:select path="job" items="${jobList}" itemValue="value" itemLabel="label" /></td>
			<td><form:errors path="job" class="error_message" /></td>
		</tr>
	</table>
</form:form>

<div>
	<button type="submit" id="btnRegister">
		<spring:message code="action.register" />
	</button>

	<!-- 관리자에게만 회원 목록 보기 버튼을 보여준다. -->
	<sec:authorize access="hasRole('ADMIN')">
		<button type="submit" id="btnList">
			<spring:message code="action.list" />
		</button>
	</sec:authorize>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#member");

		$("#btnRegister").on("click", function() {
			formObj.submit();
		});

	// 관리자만이 회원 목록 보기 기능을 사용할 수 있다.
	<sec:authorize access="hasRole('ADMIN')">
		$("#btnList").on("click", function() {
			self.location = "list";
		});
	</sec:authorize>

	});
</script>
