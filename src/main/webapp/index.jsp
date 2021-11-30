<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
	<body>
		<h2>Calculateur de distance</h2>
		<div>
			<form method="post">
				<label for="villeDepart"> Ville de départ </label>
				<select name="villeDepart">
					<c:forEach items="${listCities}" var="city">
						<option value="<c:out value='${city.nomCommune};${city.longitude};${city.latitude}'/>"> <c:out value="${city.nomCommune}"/> </option>
					</c:forEach>
				</select>
				<br/>
				<label for="villeArrivee"> Ville d'arrivée </label>
				<select name="villeArrivee">
					<c:forEach items="${listCities}" var="city">
						<option value="<c:out value='${city.nomCommune};${city.longitude};${city.latitude}'/>"> <c:out value="${city.nomCommune}"/> </option>
					</c:forEach>
				</select>
				<input type="submit"/>
			</form>
		</div>
		<div>
			<c:if test="${not empty distance}"><p> <c:out value="La distance entre ${nomDepart} et ${nomArrivee} est de ${distance} km"/> </p></c:if>
		</div>
		<a href="http://localhost:8080/ESEO_TP_CLIENT_I3/VillesServlet"> Voir les villes </a>
	</body>
</html>
