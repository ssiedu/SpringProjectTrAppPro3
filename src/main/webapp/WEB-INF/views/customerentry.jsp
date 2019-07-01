<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Customer-Registration-Form</h3>
	<hr>
		<form:form action="savecustomer" modelAttribute="customer">
		<pre>
			Email		<form:input path="email"/>
			Password	<form:password path="password"/>
			CName		<form:input path="cname"/>
			Address		<form:input path="address"/>
			City		<form:select path="city" items="${cities}"/>
			State		<form:select path="state" items="${states}"/>
			Mobile		<form:input path="mobile"/>
				<input type="submit" value="Register"/>
			</pre>
		</form:form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>