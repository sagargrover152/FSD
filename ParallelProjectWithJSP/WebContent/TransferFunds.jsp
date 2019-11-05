
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Amount</title>
</head>
<body>
	<form action="transferfundsservice">
		<input type="number" value='<%= request.getParameter("othermob") %>' readonly="readonly" name="othermob">
		<input type="text" placeholder="Enter the amount You want to send" name="amnt">
		<input type="submit" value="Send">
	</form>
</body>
</html>