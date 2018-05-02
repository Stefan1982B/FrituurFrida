<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url='/WEB-INF/JSP/head.jsp'>  
 <c:param name='title' value='Frituur Frida'/> 
  </c:import>
</head>
<body>
	<h1>Frituur Frida</h1>
	<img src="images/${boodschap}.png" alt= "${boodschap}"/>
	<h3>Adres</h3>
	<dl>
	<dt>Straat</dt><dd>${adres.straat}</dd>
	<dt>huisNr</dt><dd>${adres.huisNr}</dd>
	<dt>postcode</dt><dd>${adres.gemeente.postcode}</dd>
	<dt>gemeente</dt><dd>${adres.gemeente.naam}</dd>
	</dl>
</body>
</html>