<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<c:set var="result" value="${res}"/>
<c:choose>
	<c:when test="${result==true}">
		<script>
			alert("密码修改成功！");
			window.document.location.href="${pageContext.request.contextPath}/usersp/xgmm";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("密码错误，请重新输入！");
			window.document.location.href="${pageContext.request.contextPath}/usersp/xgmm";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>