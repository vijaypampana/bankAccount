<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.h1 {
	color: #ffffff;
	font-style: italic;
	font-weight: bold;
	text-align: center;
}

.error {
	color: #ffff00;
	font-style: italic;
}

.column {
	color: aqua;
	font-weight: bold;
}

.footer {
	position: relative;
	margin-top: 75px; /* negative value of footer height */
	height: 150px;
	clear: both;
}
.button {
margin: 5px;
width: 85px;
height:auto;
display:inline-block;
}
</style>
<title>BankAccount Application</title>
<script>
function goBack() {
    window.history.back()
}

function closeWin() {
	window.close();
}
</script>
</head>
<body bgcolor="#425C91">
	<img width=150px; height=150px; style="padding-bottom: 50px"
		src="<%=request.getContextPath()%>/resources/images/digi.jpg" />
	<h1 class="h1">APPLICATION STATUS: RESULT</h1>
	<br>
	<br>
	<h3 align="center" class="error">${errval}</h3>
	<div ALIGN="left">
			<table align="center">
				<tr height="20px"></tr>
				<tr>
				<td><b>Loan Interest Information</b></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
				<td>Congratulations. Your Application for Bank Account Successfully Submitted.</td>
				</tr>
				<tr height="10px"></tr>
				<tr>
				<td><span>Kindly Note your Application Number as : <b class="error">${applNum}</b></span></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
				<td><span>You are eligible for Loan Amount Selected with Interest Rate of : <b class="error">${applInterest}</b></span></td>
				</tr>
				<tr height="40px"></tr>
				<tr>
					<td align="center"><span><button class="button" onclick="goBack()">Back</button>
					<button class="button" onclick="window.close()">Close</button>
					</span></td>	
				</tr>
			</table>
	</div>

	<div id="footer" align="center" class="footer">
		<span><b class="column">Legal Disclaimer:</b> <b>Sole proprietery of Cognizant Academy. Unauthorized utilization results in Legal Action</b></span>
	</div>

</body>
</html>
