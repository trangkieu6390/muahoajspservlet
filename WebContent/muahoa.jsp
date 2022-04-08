<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>bai2</title>
		<link href="reset.css" type="text/css" rel="stylesheet"/>
		<link href="style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
		<div class="swapper">
		<%
			String error = (String)request.getAttribute("error");
		%>
		
			<h1>Mua hoa</h1>
			<form action="<%=request.getContextPath() %>/MuaHoaController" method="post">
				<label>Id hoa: </label>
				<input type="text" value="" name="idhoa"/><br/><br/>
				
				<label>Tên hoa: </label>
				<input type="text" value="" name="tenhoa"/><br/><br/>
				
				<label>Số lượng: </label>
				<input type="text" value="" name="soluong"/><br/><br/>
				
				<label>Gía: </label>
				<input type="text" value="" name="gia"/><br/><br/>
				
				<%if(error!=null){ %>
				<p id="error"><%=error %></p>
				<%} %>
				
				<input type="submit" value="Mua hoa" name="submit"/><br/>
			</form>
		</div>
	</body>
</html>