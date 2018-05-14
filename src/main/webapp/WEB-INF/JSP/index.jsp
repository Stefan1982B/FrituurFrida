<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url='/WEB-INF/JSP/head.jsp'>  
 <c:param name='title' value='Frituur Frida'/> 
  </c:import>
</head>
<body>
<c:import url='/WEB-INF/JSP/menu.jsp'/> 
	<h1>Frituur Frida</h1>
	<img src="images/${boodschap}.png" alt= "${boodschap}"/>
	<h3>Adres</h3>
	<dl>
	<dt>Straat</dt><dd>${adres.straat}</dd>
	<dt>huisNr</dt><dd>${adres.huisNr}</dd>
	<dt>postcode</dt><dd>${adres.gemeente.postcode}</dd>
	<dt>gemeente</dt><dd>${adres.gemeente.naam}</dd>
	</dl>
	
	<c:if test='${not empty laatstBezocht}'> 
	  <p>welkom terug</p>
	   </c:if>
</body>
</html>