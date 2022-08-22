import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search_Book
 */
public class Production extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Production() {
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
			String s1 = request.getParameter("Uid");
			String s4 = request.getParameter("Eid");
			Statement sst=con.createStatement();
			ResultSet rset =sst.executeQuery("select * from Order1 where Id ='"+s1+"'");
			PreparedStatement st=con.prepareStatement("insert into Production(Uid,Ccatogory,Dcatogory,Eid,Quantity,Size) values(?,?,?,?,?,?)");
			while(rset.next())
			{
			String s2 = rset.getString(4);
			String s3 = rset.getString(5);
			int s5 = rset.getInt(6);
			String s6 = rset.getString(7);
			st.setString(1, s1);
			st.setString(2, s2);
			st.setString(3, s3);
			st.setString(4, s4);
			st.setInt(5, s5);
			st.setString(6, s6);
			}
			st.executeUpdate();
			response.sendRedirect("EmployeePage.html");
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
