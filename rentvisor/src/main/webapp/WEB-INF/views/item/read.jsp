<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="item.header.read" /></h2>

<form:form modelAttribute="item" action="buy">
	<form:hidden path="itemId" />
	<form:hidden path="pictureUrl" />
	<form:hidden path="previewUrl" />

	<table>
		<tr>
			<td><spring:message code="item.itemName" /></td>
			<td><form:input path="itemName" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="item.itemPrice" /></td>
			<td><form:input path="price" />&nbsp;원</td>
			<td></td>
		</tr>
		<sec:authorize access="hasRole('ADMIN')">
			<tr>
				<td><spring:message code="item.picture" /></td>
				<td><img src="picture?itemId=${item.itemId}" width="210"></td>
				<td></td>
			</tr>
		</sec:authorize>
		<tr>
			<td><spring:message code="item.preview" /></td>
			<td><img src="display?itemId=${item.itemId}" width="210"></td>
			<td></td>
		</tr>		
		<tr>
			<td><spring:message code="item.itemDescription" /></td>
			<td><form:textarea path="description" /></td>
			<td></td>
		</tr>
	</table>
</form:form>

<div>
	<sec:authorize access="hasRole('MEMBER')">
		<button type="submit" id="btnBuy"><spring:message code="action.buy" /></button>
	</sec:authorize>
	<button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#item");

		$("#btnBuy").on("click", function() {
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "list";
		});

	});
</script>
