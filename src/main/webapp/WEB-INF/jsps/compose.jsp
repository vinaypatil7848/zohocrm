<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COMPOSE</title>
</head>
<body>
<div>
	${msg}
</div>

<form action="sendEmail" method="post">
	<pre>
		To<input type="text" name="to" value="${email}"/>
		Subject<input type="text" name="subject"/>
		Message
		<textarea name="message" cols="50" rows="4"></textarea>
		<input type="submit" value="send"/>
	</pre>
	
</form>


</body>
</html>