<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<link href='<jstl:url value="/css/style.css"/>' rel="stylesheet" />

<body>
<h2 class="color2">Spring Web MVC Java Conf</h2>
<h2 class="color1">Transporter App</h2>
<hr>
	<pre>
		<form action="verify">
		Email Id 	<input type="text" name="email"/>	
		Password	<input type="password" name="password"/>
		UserType	<select name="utype">
						<option>Admin</option>
						<option>Transporter</option>
						<option>Customer</option>
					</select>
				<input type="submit" value="Login"/>
		</form>
<hr>
<pre>
	<a href="customerentry">New-Customer-Registration</a>
	<a href="transporterentry">New-Transporter-Registration</a>
</pre>

<img  src="<jstl:url value="/images/x.png"/>" width="50" height="50">
<hr>
</body>
</html>
