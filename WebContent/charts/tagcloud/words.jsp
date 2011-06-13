<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="org.mcavallo.opencloud.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OpenCloud - Example 2</title>
<link rel="stylesheet" type="text/css" href="charts/tagcloud/css/dailymotion.css" />
</head>
<body>

<h3 style="text-align: center">Tag cloud discrete levels</h3>

<br />

<%
	Cloud cloud = (Cloud)request.getAttribute("Cloud");
%>
<div class="tagcloud" style="margin: auto; width: 60%;">
	<%
	// Cycles through the output tags
	for (Tag tag : cloud.tags()) {
		// Writes a link for each tag.
		// We use the getWeightInt() to get the weight level of the tag and set the corresponding CSS class.
	%>
		<a href="<%= tag.getLink() %>" class="t<%= tag.getWeightInt() %>"><%= tag.getName() %></a>
	<%
	}
	%>
</div>

</body>
</html>