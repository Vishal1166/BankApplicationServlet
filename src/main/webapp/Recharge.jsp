<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RechargeController">
		<table>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobno"></td>
			</tr>
			<tr>
				<td>Recharge Amount</td>
				<td><input type="text" name="rechargeamt"></td>
			</tr>
			<tr>
				<td>Service Provider</td>
				<td><select name="servicep">
						<option value="Airte">Airtel</option>
						<option value="VI">VI</option>
						<option value="BSNL">BSNL</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Recharge"></td>
			</tr>
		</table>
	</form>
</body>
</html>