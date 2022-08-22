<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
    <%@ page import="javax.servlet.*" %>
    <%@ page import="java.sql.*" %>
    <html>
    <head>
    <title>
  Employee LIst
    </title>
    <style>
 
html,
body {
	height: 100%;
}

body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}

.container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

table {
	width: 800px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

th,
td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
}

th {
	text-align: left;
}

thead {
	th {
		background-color: #55608f;
	}
}

tbody {
	tr {
		&:hover {
			background-color: rgba(255,255,255,0.3);
		}
	}
	td {
		position: relative;
		&:hover {
			&:before {
				content: "";
				position: absolute;
				left: 0;
				right: 0;
				top: -9999px;
				bottom: -9999px;
				background-color: rgba(255,255,255,0.2);
				z-index: -1;
			}
		}
	}
}
    </style>
    </head>
 <body>
 <div class="container">
	<table>
		<thead>
			<tr>
				<th>Employee Id</th>
          <th>Employee Name</th>
          <th>Employee Category</th>
          <th>Salary</th>
          <th>Address </th>
          <th>Contact </th>
          <th>Employee Post ID </th>
			</tr>
		</thead>
		 <%
      try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cn=DriverManager.getConnection("Jdbc:Odbc:Garments");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select * from Employee");
            %>
            
   <%    
	while(rs.next())
            {
%>
<tbody>
			<tr>
				
<td><%= rs.getString(1) %></td>
<td><%= rs.getString(2) %></td>
<td><%= rs.getString(3) %></td>
<td><%= rs.getString(4) %></td>
<td><%= rs.getString(5) %></td>
<td><%= rs.getString(6) %></td>
<td><%= rs.getString(7) %></td>
			</tr>
</tbody>

<%
            }

            cn.close();
          }catch(Exception e)
            {         
            }
%>
</table>
</div>

</body>
</html>