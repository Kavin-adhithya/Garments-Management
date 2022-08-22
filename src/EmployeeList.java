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

/**
 * Servlet implementation class Search_Book
 */
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeList() {
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
			Statement sst=con.createStatement();
			ResultSet rset =sst.executeQuery("select * from Employee") ;
			out.print("<html>");
			out.print("<body>");
			out.print("<table style=' background-repeat:no-repeat; width:900px;margin:0;' cellpadding='0' cellspacing='0' border='0'>");
			out.print("<tr style='height:40px; width:450px; margin:0; padding:5px'>");
			out.print("<th> Employee Id</th>");
			out.print("<th> Employee Name</th>");
			out.print("<th> Employee Catogory</th>");
			out.print("<th> Employee Salary</th>");
			out.print("<th> Address</th>");
			out.print("<th> Contact</th>");
			out.print("<th> Post Id</th>");
			out.print("</tr>");
			 while(rset.next())
			{
				 	out.print("<tr style='height:40px; width:450px; margin:0;'>");
				 	out.print("<td style='height:40px; width:50px; margin:0;'>"+ rset.getString(1)+"</td>"); 
				 	out.print("<td style='height:40px; width:50px; margin:0; padding:10px'>" +rset.getString(2)+"</td>");
					out.print("<td style='height:40px; width:50px; margin:0; padding:10px'>"+ rset.getString(3)+"</td>");
					out.print("<td style='height:40px; width:50px; margin:0; padding:10px'>"+ rset.getString(4)+"</td>");
					out.print("<td style='height:40px; width:50px; margin:0; padding:10px'>"+ rset.getString(5)+"</td>");
					out.print("<td style='height:40px; width:50px; margin:0; padding:10px'>" +rset.getString(6)+"</td>");
					out.print("<td style='height:40px; width:50px; margin:0; padding:10px'>" +rset.getString(7)+"</td>");
					out.print("</tr>");
			 }  
			 out.print("</table");
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
