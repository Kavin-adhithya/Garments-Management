import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Search_Book
 */
public class Address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		long i=1;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("Jdbc:Odbc:Garments");
			HttpSession session=request.getSession();
			String myName=(String)session.getAttribute("usname");
			Statement sst=con.createStatement();
			ResultSet rset =sst.executeQuery("select * from User where Id ='"+myName+"'");
			out.print("<html>");
			out.print("<body>");
			 out.print("<form name='cform' action='Order' method='get'>");
			 while(rset.next())
			{
				   
				 	out.print("<div>");
				 	out.print("<p style='text-align:center'>Delivery Address<input type='textarea' name='Address' value='"+rset.getString(3)+"'/></p><br/>");
				 	out.print("<p style='text-align:center'>Delivery Pin Code<input type='text' name='pincode' value='"+rset.getString(5)+"'/></p><br/>");
				 	out.print("<p style='text-align:center'><input type='submit' name='Submit' value='Submit'/></p><br/>");
				 	out.print("</div>");
				 	
			 }  
			 out.print("</form");
			 out.print("</body>");
			 out.print("</html>");
			
			
		}
		catch(Exception e)
		{
			out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
