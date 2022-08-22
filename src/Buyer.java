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

public class Buyer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buyer() {
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
			PreparedStatement st=con.prepareStatement("insert into Buyer(Id,Name,Contact,Address,ShopName,Catogory,Units,Rate,Total) values(?,?,?,?,?,?,?,?,?)");
			//PreparedStatement st1=con.prepareStatement("insert into Current_Books(Id,Name,Author,Details,Edition,Volume,Price,Publication,Rack_Number) values(?,?,?,?,?,?,?,?,?)");
			String s1=request.getParameter("Bname");
			String s2=request.getParameter("Bid");
			String s3=request.getParameter("Bphone");
			String s4=request.getParameter("Baddress");
			String s5=request.getParameter("Bshopname");
			String s6=request.getParameter("Bcatogory");
			int s7 = Integer.parseInt(request.getParameter("Bunits"));
			float s8 = Float.parseFloat(request.getParameter("Brate"));
			float s9 = s8*s7;
			st.setString(1,s2);
			st.setString(2,s1);
			st.setString(3,s3);
			st.setString(4,s4);
			st.setString(5,s5);
			st.setString(6,s6);
			st.setInt(7,s7);
			st.setFloat(8,s8);
			st.setFloat(9,s9);
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
