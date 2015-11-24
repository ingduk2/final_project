<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>TeamD</title>
	<!-- Css  -->
	<link rel="stylesheet" type="text/css" href="resources/default.css">
</head>
<body>
	
	<div class="page">
		<tiles:insertAttribute name="header" flush="true"/>
		<div id="content">
			<tiles:insertAttribute name="menu" flush="true"/>
			<tiles:insertAttribute name="body" flush="true"/>
		</div>		
		<tiles:insertAttribute name="footer" flush="true"/>
	</div>
</body>
</html>