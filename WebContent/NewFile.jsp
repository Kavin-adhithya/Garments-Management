<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
    <%@ page import="javax.servlet.*" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Product
</title></head>
<body bgcolor="#1E0218" style="margin-left: 25%; margin-right: 25%; margin-top: 10%;">
<center>
    <font color="white">
    <h1>PTM Departmental Store</h1>
<%

      try{
    	  int price,total=0;
          String pname,pquantity;
          pname=request.getParameter("pname");
          pquantity=request.getParameter("pquantity");
          price=Integer.parseInt(request.getParameter("price"));

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cn=DriverManager.getConnection("Jdbc:Odbc:Garments");
            PreparedStatement s=cn.prepareStatement("insert into product(name,quan,price) values(?,?,?)");
            s.setString(1,pname);
            s.setString(2,pquantity);
            s.setInt(3,price);
            s.executeUpdate();
            %>
            <%
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select * from product");
            %>

<table border="2" bordercolor="white" cellpadding="10">
    <tr><th>Product Name</th>
        <th>Product Quantity</th>
        <th>Price</th>
    </tr>
    
<%    
	while(rs.next())
            {
%>
<tr> <td><%= rs.getString(1) %></td>
<td><%= rs.getString(2) %></td>
<td><%= rs.getInt(3) %></td>
</tr>
<%
            }
total=total+price;
out.println("Total Price="+total);
            cn.close();
          }catch(Exception e)
            {         
            }
%>
</table>
</center>
</body>
</html>
