<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="jquery-1.11.2.js"></script>
</head>
<body>
	<script>
		$(function() {
			var site = {
				latitude : 122.3,
				longitude : 123.3,
				name : "Site 1"
			}
			//HTTP POST request for database insertion
/*			$.ajax({
				 url: "api/site/",
				 type: "post",
				 contentType: "application/json",
				 dataType: "json",
				 data: JSON.stringify(site),
				 success: function(response){
					var x = document.getElementById("sites").innerHTML = JSON.stringify(response);
				 }
			})
			//HTTP DELETE request for database delete
			$.ajax({
				 url: "api/site/15",
				 type: "delete",
				 contentType: "application/json",
				 dataType: "json",
				 //data: JSON.stringify(site),
				 success: function(response){
					var x = document.getElementById("sites").innerHTML = JSON.stringify(response);
				 }
			}) 
			//HTTP PUT request for DB update
			$.ajax({
				 url: "api/site/16",
				 type: "put",
				 contentType: "application/json",
				 dataType: "json",
				 data: JSON.stringify(site),
				 success: function(response){
					var x = document.getElementById("sites").innerHTML = JSON.stringify(response);
				 }
			})*/
		});
	</script>
	<p id="sites"></p>
</body>
</html>