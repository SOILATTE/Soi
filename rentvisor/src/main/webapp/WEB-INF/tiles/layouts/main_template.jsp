<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!-- 메인 화면 레이아웃 -->

<html>
<head>
	<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" href="/css/style.css" />
	<script src="/js/jQuery-2.1.4.min.js"></script>
</head>
<body>

	<tiles:insertAttribute name="header" />
	
	<tiles:insertAttribute name="menu" />
	
	<div align="center">
		<tiles:insertAttribute name="content" />
	</div>
	
	<tiles:insertAttribute name="footer" />

</body>
</html>
