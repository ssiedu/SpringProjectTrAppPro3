<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Booking-Search-City-Wise</h3>
	<hr>
		<form:form action="searchcitybooking" modelAttribute="booking">
		<pre>
			SCity	<form:select path="sourceCity" items="${cities}"/>
			DCity	<form:select path="destCity" items="${cities}"/>
				<input type="submit" value="Search-Now"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporterhome">Home</a>
</body>
</html>