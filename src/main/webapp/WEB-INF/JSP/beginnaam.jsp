<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>

<!doctype html>
<html lang='nl'>
<head>
<c:import url='/WEB-INF/JSP/head.jsp'>
	<c:param name='title' value='beginletter' />
</c:import>
</head>
<body>
<body>
<c:import url='/WEB-INF/JSP/menu.jsp'/> 
	<h1>Snacks (begin naam)</h1>
	<c:url value='/snacks' var='url' />
	<form:form action='${url}' modelAttribute='beginNaamForm' method='get'>
		<form:label path='beginnaam'>Begin naam: <form:errors path='beginnaam' /> </form:label>
		<form:input path='beginnaam' required="required" autofocus='autofocus' />
		<input type='submit' value='Zoeken'>
		<form:errors />
	</form:form>
	<c:if test='${not empty snacks}'>
		<ul>
			<c:forEach items='${snacks}' var='snack'>
				<li>${snack.naam}</li>
			</c:forEach>
		</ul>
	</c:if>
	<c:forEach var='snack' items='${snacks}'>
 <spring:url value='/snacks/{id}/wijzigen' var='url'>
 <spring:param name='id' value="${snack.id}"/>
 </spring:url>
 <li><a href='${url}'>${snack.naam}</a></li>
</c:forEach>
</body>
</html>
