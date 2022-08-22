import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:Garments");
			PreparedStatement st=con.prepareStatement("insert into Employee(Eid,Ename,Ecatogory,Salary,Address,Contact,EpostId,Password) values(?,?,?,?,?,?,?,?)");
			//PreparedStatement st1=con.prepareStatement("insert into Current_Books(Id,Name,Author,Details,Edition,Volume,Price,Publication,Rack_Number) values(?,?,?,?,?,?,?,?,?)");
			String s1=request.getParameter("Eid");
			String s2=request.getParameter("Ename");
			String s3=request.getParameter("Ecatogory");
			//int s4=Integer.parseInt(request.getParameter("Salary"));
			int s4=250;
			String s5=request.getParameter("Address");
			String s6=request.getParameter("Contact");
			String s7 = request.getParameter("PostId");
			String s8 = request.getParameter("Password");
//			if(s7==null)
//			{
//				s7=null;
//			}
			st.setString(1,s1);
			st.setString(2,s2);
			st.setString(3,s3);
			st.setInt(4,s4);
			st.setString(5,s5);
			st.setString(6,s6);
			st.setString(7, s7);
			st.setString(8, s8);
			st.executeUpdate();
			response.sendRedirect("main.html");
		}
		catch(Exception e)
		{
			out.println(e.getMessage());
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
