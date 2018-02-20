<html>
<body>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

	<c:set var="x" value="${sessionScope.errorMsg }" scope="session"></c:set>
	<span style="color: red"><c:out value="${x }"></c:out></span>
	<c:remove var="x" scope="session" />
</body>
</html>