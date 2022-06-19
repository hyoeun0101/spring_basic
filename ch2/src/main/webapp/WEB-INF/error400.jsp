<%@ page contentType="text/html;charset=utf-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>400ERROR.jsp</title>
</head>
<body>
<h1>400 ERROR</h1>
발생한 예외 : ${ex}<br>
예외 메시지 : ${ex.message}<br>
<ol>
<c:forEach items="${ex.stackTrace}" var="i">
	<li>${i.toString()}</li>
</c:forEach>
</ol>
</body>
</html>

