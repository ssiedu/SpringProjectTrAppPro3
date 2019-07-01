<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Vehicle-Registration-Form</h3>
	<hr>
		<form:form action="savevehicle" modelAttribute="vehicle">
		<pre>
			RegNo.		<form:input path="regno"/>
			VType		<form:select path="vtype" items="${vtypes}"/>
			State		<form:select path="brand" items="${brands}"/>
			Capacity	<form:input path="capacity"/>
				<input type="submit" value="Register"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporterhome">Home</a>
</body>
</html>