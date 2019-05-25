<%@ page import = "com.sellnbye.models.Advertisement" %>
<%@ page import ="javax.sql. *" %>
<%@ page language="java" contentType ="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	Advertisement advertisement = new Advertisement();
	String advertisementGrid = "";
	String rudFeedback = "";
	
	if(request.getParameter(hidMode) != null && request.getParameter("hidMode"). equalsIgnoreCase("save"))
	{
		rudFeedback = advertisement.saveAnAdvertisement(request.getParameter("adTitle"), request.getParameter("adImageLink"), request.getParameter("adDescription"));
	}
	
	if(request.getParameter(hidMode) != null && request.getParameter("hidMode"). equalsIgnoreCase("update"))
	{
		rudFeedback = advertisement.updateAnAdvertisement(request.getParameter("hidID"), request.getParameter("adTitle"),
		request.getParameter("adImageLink"),request.getParameter("adDescription"));

	}
	
	if(request.getParameter(hidMode) != null && request.getParameter("hidMode"). equalsIgnoreCase("remove"))
	{
		rudFeedback = advertisement.deleteAnAdvertisement(request.getParameter("hidID"));

	}
	
	advertisementGrid = advertisement.getAdvertisement();
%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src=Controllers/jQuery.js></script>
<script type="text/javascript" src=Controllers/controllerMain.js></script>
</head>
<body>

<form id="formAdvertisement" action="advertisement.jsp" method="post">
		<input id="hidMode" name="hidMode" type="hidden" value="save">
		<input id="hidID" name="hidID" type="hidden" value="0">
		Title <input id="adTitle" type="text" name="adTitle"> <br>
		Image Link <input id="adImageLink" type="text" name="adImageLink"> <br>
		Description <input id="adDescription" type="text" name="adDescription" > <br>
		<input id="btnSave" type="button" name="btnSave"  value="Save"> <br> <br>
		<div id="divStsMsgAdvertisement"><% out.println(rudFeedback); %> </div>
		<% out.println(advertisementGrid); %> 
	</form> <br>
</body>
</html>