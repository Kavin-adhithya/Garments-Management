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
public class Shipment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shipment() {
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
			String s9 = request.getParameter("UpostId");
			Statement sst=con.createStatement();
			Statement sst1=con.createStatement();
			ResultSet rset =sst.executeQuery("select * from Order1 where Id ='"+s1+"'");
			ResultSet rset1 =sst1.executeQuery("select * from Employee where EpostId ='"+s9+"'");
			PreparedStatement st=con.prepareStatement("insert into Shipment(Uid,Eid,Ccatogory,Dcatogory,Quantity,Size,Econtact,Total,PostId) values(?,?,?,?,?,?,?,?,?)");
			PreparedStatement st1=con.prepareStatement("insert into Bill(Uid,Ccatogory,Dcatogory,Quantity,Size,Total) values(?,?,?,?,?,?)");
			while(rset1.next())
			{
				String s2 = rset1.getString(1);
				String s7 = rset1.getString(6);
				st.setString(2, s2);
				st.setString(7, s7);
			}
			while(rset.next())
			{
			String s3 = rset.getString(4);
			String s4 = rset.getString(5);
			int s5 = rset.getInt(6);
			String s6 = rset.getString(7);
			float s8 = rset.getInt(8);
			st.setString(1, s1);
			st.setString(3, s3);
			st.setString(4, s4);
			st.setInt(5, s5);
			st.setString(6, s6);
			st.setFloat(8, s8);
			st.setString(9, s9);
			
			st1.setString(1, s1);
			st1.setString(2, s3);
			st1.setString(3, s4);
			st1.setInt(4, s5);
			st1.setString(5, s6);
			st1.setFloat(6, s8);
			}
			st.executeUpdate();
			st1.executeUpdate();
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
