<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Vehicle-Registered-With-Us-By-${username}</h3>
<table border="2">
	<tr>
		<td>RegNo</td><td>Brand</td><td>VType</td><td>Capacity</td><td>TName</td><td>TAddress</td>
	</tr>
	
	<jstl:forEach  var="vehicle" items="${vehicles}">
		<tr>
			<td>${vehicle.regno}</td>
			<td>${vehicle.brand}</td>
			<td>${vehicle.vtype }</td>
			<td>${vehicle.capacity}</td>
			<td>${vehicle.transporter.tname}</td>
			<td>${vehicle.transporter.address}</td>
			<td><a href="updatevehicle?regno=${vehicle.regno}">change</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="transporterhome">Transporter-Home</a>
</body>
</html>