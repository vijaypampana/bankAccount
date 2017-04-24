<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<html>
<head>
<%@include file="../common/commonLinks.jsp" %>
<title>Cognizant Academy Bank</title>
</head>
<body bgcolor="425C91">
	<img width=150px; height=150px; style="padding-bottom: 50px"
		src="resources/images/digi.jpg" />
	<h1 align="center" class="h1">WELCOME TO COGNIZANT ACADEMY BANK</h1>
	<br>
	<br>
	<h3 align="center" class="error">${errval}</h3>
		<div align="center">

			<form:form method="post" action="login" commandName="login">

				<table align="center">
					<tr>
					</tr>
					<tr>
						<td><span class="column">Username:</span></td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>
					<tr height="10px"></tr>
					<tr>
						<td><span class="column">Password:</span></td>
						<td><form:input path="password" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr height="10px"></tr>
					<tr>
						<td></td>
						<td align="right"><input type="submit" name="Submit"
							id="Submit" value="Login"></td>
					</tr>
				</table>

			</form:form>
		</div>
		<div id="footer" align="center" class="footer">
			<span><b class="column">Legal Disclaimer:</b> <b>Sole
					proprietery of Cognizant Academy. Unauthorized utilization results
					in Legal Action</b></span>
		</div>
</body>
</html>