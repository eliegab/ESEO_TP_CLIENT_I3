<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>liste des villes</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th> Code Commune </th>
				<th> Nom Commune </th>
				<th> Code Postal </th>
				<th> Libelle Acheminement </th>
				<th> Ligne </th>
				<th> Latitude </th>
				<th> Longitude </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listCities}" var="city">
				<tr>
					<td> <a href="<c:out value='/ESEO_TP_CLIENT_I3/UpdateServlet?code=${city.codeCommune}'/>"><c:out value="${city.codeCommune}"/></a> </td>
					<td> <c:out value="${city.nomCommune}"/> </td>
					<td> <c:out value="${city.codePostal}"/> </td>
					<td> <c:out value="${city.libelleAcheminement}"/> </td>
					<td> <c:out value="${city.ligne}"/> </td>
					<td> <c:out value="${city.latitude}"/> </td>
					<td> <c:out value="${city.longitude}"/> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
	<p> 
		<c:if test="${page!=1}"> <a href="<c:out value='/ESEO_TP_CLIENT_I3/VillesServlet?page=${page-1}'/>"> Page précedente </a> </c:if> 
		Page <c:out value="${page}"/> 
		<c:if test="${not lastPage}"> <a href="<c:out value='/ESEO_TP_CLIENT_I3/VillesServlet?page=${page+1}'/>"> Page suivante </a> </c:if>
	</p>
	</div>
</body>
</html>