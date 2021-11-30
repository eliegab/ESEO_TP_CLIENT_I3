<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
	<body>
		<h2>Editer </h2>
		<div>
			<form method="post">
				<input type="hidden" name="codeCommune" value='<c:out value="${city.codeCommune}"></c:out>' required/>
				<label for="nomCommune"> Nom de la commune </label> 
				<input type="text" name="nomCommune" value='<c:out value="${city.nomCommune}"></c:out>' required/>
				<br/>
				<label for="codePostal"> Code Postal </label>
				<input type="text" name="codePostal" value='<c:out value="${city.codePostal}"></c:out>' required/>
				<br/>
				<label for="ligne"> Ligne </label>
				<input type="text" name="ligne" value='<c:out value="${city.ligne}"></c:out>'/>
				<br/>
				<label for="libelleAcheminement"> Libelle Acheminement </label>
				<input type="text" name="libelleAcheminement" value='<c:out value="${city.libelleAcheminement}"></c:out>' required/>
				<br/>
				<label for="latitude"> Latitude </label>
				<input type="text" name="latitude" value='<c:out value="${city.latitude}"></c:out>' required/>
				<br/>
				<label for="longitude"> Longitude </label>
				<input type="text" name="longitude" value='<c:out value="${city.longitude}"></c:out>' required/>
				<br/>
				<input type="submit"/>
			</form>
		</div>
	</body>
</html>
