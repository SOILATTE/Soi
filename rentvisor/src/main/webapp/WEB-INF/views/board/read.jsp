<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="board.header.read" /></h2>

<form:form modelAttribute="board">
	<form:hidden path="boardNo" />
	
	<input type="hidden" name="page" value="${pgrq.page}">
	<input type="hidden" name="searchType" value="${pgrq.searchType}">
	<input type="hidden" name="keyword" value="${pgrq.keyword}">
	
	<table>
		<tr>
			<td><spring:message code="board.title" /></td>
			<td><form:input path="title" readonly="true" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="board.writer" /></td>
			<td><form:input path="writer" readonly="true" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="board.content" /></td>
			<td><form:textarea path="content" readonly="true" /></td>
			<td></td>
		</tr>
	</table>
</form:form>
<button type="submit" id="btnList"><spring:message code="action.list" /></button><br>
<div>
	<sec:authentication property="principal" var="pinfo"/>

	<sec:authorize access="hasRole('ADMIN')">
		<button type="submit" id="btnRemove"><spring:message code="action.remove" /></button>
	</sec:authorize>

	<sec:authorize access="hasRole('MEMBER')">
       <c:if test="${pinfo.username eq board.writer}">
       	<button type="submit" id="btnEdit"><spring:message code="action.edit" /></button>
       	<button type="submit" id="btnRemove"><spring:message code="action.remove" /></button>
       </c:if>
	</sec:authorize>
	
	<div id="commentBox"><table>
			<c:forEach items="${list}" var="com" varStatus="number">
				<tr>
					<td align="left">${com.userId}</td>
					<td align="center">${com.content}</td>
					<td align="right">${com.writeDate}</td>
				</tr>
					<div id=box${com.commentId}/>
				<tr>
					<td colspan="2"><input type="text" id=contents${com.commentId}></td>
					<td><button onClick="test(${com.commentId})">댓글에 댓글</button></td>
				</tr>
			</c:forEach>
			</table></div><br>
	
	
	<div><input type="text" id="con"/>
	<button id="commetTable">댓글</button>
	</div>
	
	
<script>
		
	function test(commentId) {
		
		var boardNo = $("#boardNo").val();
		var contentVal = $("#contents"+commentId).val();
		if(contentVal == ""){
			return "/board/read/"+boardNo;
		};
		$.ajax({
		type:"GET",
		async:"true",
		url:"/comment/plus/"+boardNo+","+commentId,
		data:{content:contentVal},
		success:function(data){
		alert(data);
		var output = "<table>";
		for(var i in data){
		output += "<tr>";
		output += "<td align=right>"+ data[i].userId + "</td>";
		output += "<td align=center>"+ data[i].content + "</td>";
		output += "<td align=right>"+ data[i].writeDate +"</td></tr>";
		}
		output += "</table>";
		$("#box"+commentId).html(output);
		}
		
		});
	}
	
	$(document).ready(function() {

		var formObj = $("#board");
			
			
			$("#commetTable").on("click",function(){
			var contents = $("#con").val();
			var boardNo = $("#boardNo").val();
			if(contents == ""){
			return "/board/read/"+boardNo;
			};
			$.ajax({
			type:"GET",
			async: "true",
			url:"/comment/add/"+boardNo,
			data:{contents:contents},
			success:function(result){
			var output = "<table>";
			var button = "";
			var commentId;
			for(var i in result){
				output += "<tr border=1px align=center>";
				output += "<td>"+result[i].userId+"</td>";
				output += "<td>"+result[i].content+"</td>";
				output += "<td>"+result[i].writeDate+"</td>";
				output += "<tr><td><div id=box"+result[i].commentId+"></div></td></tr>";
				output += "<tr><td colspan=2><input type=text id=contents"+result[i].commentId+"></td>";
				output += "<td><button onClick=test("+result[i].commentId+")>대댓글</button></td></tr>";
			}
			output += "</table>";
			
			alert(result);
			$("#commentBox").html(output);
			}
			
			});
			
		});
		
				
		$("#plusCon").on("click",function(){
			var contents = $("#commentsPl").val();
			$.ajax({
			type:"GET",
			url:"/comment/plus",
			data:{content:contents},
			success:function(data){
				alert("success");
			}
			});
		});	
		$("#btnEdit").on("click", function() {
			var boardNo = $("#boardNo");
			var boardNoVal = boardNo.val();
			
			self.location = "/board/modify${pgrq.toUriString()}" + "&boardNo=" + boardNoVal;
		});

		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/board/remove");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/board/list${pgrq.toUriString()}";
		});

	});
</script>
