
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<form action="registrationservice">
		Number : <input type="number" value='<%= request.getParameter("mob")%>' readonly="readonly" name="mob"><br>
		Enter Your name <input type="text" name="uname"><br>
		Enter Your Address <input type="text" name="addr"><br>
		Enter password <input type="password" name="pass"><br>
		Enter the initial amount you wan to submit <input type="number" name="amnt"><br>
		<input type="submit" value="register">
	</form>
</body>
</html>