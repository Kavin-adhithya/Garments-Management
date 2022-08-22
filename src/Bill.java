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
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Search_Book
 */
public class Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill() {
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
			HttpSession session=request.getSession();
			float total = 0;
			String myName=(String)session.getAttribute("usname");
			String Cloth=(String)session.getAttribute("uscloth");
			String Dress=(String)session.getAttribute("usdress");
			String Size=(String)session.getAttribute("ussize");
			String Color=(String)session.getAttribute("uscolor");
			String Cat=(String)session.getAttribute("uscat");
			String Pattern=(String)session.getAttribute("uspattern");
			int Quantity=(Integer)session.getAttribute("usquantity");
			out.print("<html>");
			out.print("<body>");
			out.print("<p style='text-align:center'>Name : "+myName+"</p>");
			out.print("<p style='text-align:center'>Cloth Category : "+Cloth+"</p>");
			out.print("<p style='text-align:center'>Dress Category : "+Dress+"</p>");
			out.print("<p style='text-align:center'>Color : "+Color+"</p>");
			out.print("<p style='text-align:center'>Category : "+Cat+"</p>");
			out.print("<p style='text-align:center'>Pattern : "+Pattern+"</p>");
			out.print("<p style='text-align:center'>Quantity : "+Quantity+"</p>");
			out.print("<p style='text-align:center'>Size : "+Size+"</p>");
			if(Size.equals("M"))
			{
				 total = Quantity*250; 
			}
			if(Size.equals("S"))
			{
				 total = Quantity*200; 
			}
			if(Size.equals("L"))
			{
				 total = Quantity*300; 
			}
			if(Size.equals("XL"))
			{
				 total = Quantity*350; 
			}
			if(Size.equals("M"))
			{
				 total = Quantity*400; 
			}
			out.print("<p style='text-align:center'>total : "+total+"</p>");
			session.setAttribute("ustotal",total);
			out.print("<form action = 'Address' method ='get'>");
			out.print("<p style='text-align:center'><input type = 'submit' name='Confirm Order' value='Confirm Order'/></p>");
			out.print("</form>");
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
