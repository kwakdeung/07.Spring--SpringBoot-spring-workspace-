<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<!--Get방식-->
	<form action="/spring/student" method="get">
		student id : <input type="text" name="id"> <br />
		<input type="submit" value="전송">
	</form>
	
	<hr>
	
	<!--Post방식-->
	<form action="/spring/student" method="post">
		student id : <input type="text" name="id"> <br />
		<input type="submit" value="전송">
	</form>
</body>
</html>