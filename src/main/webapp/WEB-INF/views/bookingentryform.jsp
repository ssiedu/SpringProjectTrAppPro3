<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Booking-Entry-Form For ${email}</h3>
	<hr>
		<form:form action="savebooking" modelAttribute="booking">
		<pre>
			BDate	<form:input path="bdate"/>
			SCity	<form:select path="sourceCity" items="${cities}"/>
			DCity	<form:select path="destCity" items="${cities}"/>
			Fare	<form:input path="fare"/>
			Vehicle	<form:select path="vehicle.regno" items="${regnos}"/>
				<input type="submit" value="Post-Booking"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporterhome">Home</a>
</body>
</html>