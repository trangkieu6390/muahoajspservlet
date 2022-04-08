<%@page import="bean.Hoa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>bai2</title>
	</head>
	<body>
		<div>
			<%
				String error = (String) request.getAttribute("error");
				String soluong = (String) request.getAttribute("soluong");
				if(session.getAttribute("listHoa")!=null){
					ArrayList<Hoa> listHoa = (ArrayList<Hoa>)session.getAttribute("listHoa");
		
			%>
			<h1>Danh sách Hoa</h1>
			
			<table style="background: #DEDEDE; border-collapse: collapse; border-right: 1px solid #DEDEDE; width:500px"; >
				<tr style="background: #DEDEDE;">
					<th >Tên sản phẩm</th>
					<th >Giá</th>
					<th >Số lượng</th>
					<th >Tổng tiền</th>
					<th ></th> 
					
				</tr>
				<%
					int tongTien = 0;
					for(Hoa objHoa:listHoa){ 
					tongTien += objHoa.getGiaBan() * objHoa.getSoLuong() ;
					
				%>
				<tr style="background: #FFFFFF;">
					<form action="<%=request.getContextPath() %>/UpdateSoLuong" method="post">
						<input name="id" type="hidden" value="<%=objHoa.getIdHoa()%>"/></td>
						<td style="text-align: left; "><a href="" title="" ><%=objHoa.getTenHoa() %></a></td>
						<td style="text-align: center;" ><%=objHoa.getGiaBan() %></td>
						<td style="text-align: center;"><input name="soluong" style="width:50px;" type="text" value="<%=objHoa.getSoLuong() %>"/></td>
						<td style="text-align: center;"><%=objHoa.getGiaBan() * objHoa.getSoLuong() %></td>
						<td style="text-align: center;"><input type="submit" name="action" value="Delete"/></td>
						<td style="text-align: center;"><input type="submit" name="action" value="Update"/> </td>
					</form>

				</tr>
				<%} %>
				
				<tr style="background: #FFFFFF; border-top: 1px solid #DEDEDE;border-bottom: 1px solid #DEDEDE;">
					<td style="text-align: right;"colspan="3">Thành tiền:</td>
					<td style="text-align: center;"><%=tongTien %></td>
				</tr>
				
				
			</table>
			
			<%}else{ %>
			<p>Không có danh sách Hoa</p>
			<%} %>
			<%if(error!=null){ %>
				<p style="color: red;" id="error"><%=error %></p>
				<%} %>
		</div>
		
	</body>
</html>