import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Search_Book
 */
public class Pattern extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pattern() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//long i=1;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("Jdbc:Odbc:Garments");
			String s1 = request.getParameter("Dress");
			HttpSession session=request.getSession();
			session.setAttribute("uspattern",s1);
//			Statement sst=con.createStatement();
//			ResultSet rset =sst.executeQuery("select * from Cloths") ;
//			out.print("<html>");
//			out.print("<body>");
//			 out.print("<form name='cform' action='Dress' method='get'>");
//			 while(rset.next())
//			{
//				   
//				 	out.print("<div>");
//				 	out.print("<input type='hidden' name='cloth' value='"+rset.getString(1)+"'/><br/>");
//				 	out.print("<img src='"+rset.getString(2)+"' width='200' height='200'/><br/>" );
//				 	out.print("<input type='submit' name='choose' value='choose'/><br/>");
//				 	out.print("</div>");
//				 	
//			 }  
//			 out.print("</form");
//			 out.print("</body>");
//			 out.print("</html>");
			response.sendRedirect("Quantity.html");
			
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
