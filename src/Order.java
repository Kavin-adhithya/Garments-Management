import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
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
			PreparedStatement st=con.prepareStatement("insert into Order1(Id,Name,Address,Ccatogory,Dcatogory,Quantity,Size,Total,Contact,UpostId,Color,Cat,Pattern) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			out.print("hi");
			PreparedStatement st1=con.prepareStatement("insert into Customer(Id,Name,Address,Contact,UpostId) values(?,?,?,?,?)");
			HttpSession session=request.getSession();
			Date date = new Date();
			String myName=(String)session.getAttribute("usname");
			String Cloth=(String)session.getAttribute("uscloth");
			String Dress=(String)session.getAttribute("usdress");
			String Size=(String)session.getAttribute("ussize");
			String Color=(String)session.getAttribute("uscolor");
			String Cat=(String)session.getAttribute("uscat");
			String Pattern=(String)session.getAttribute("uspattern");
			int Quantity=(Integer)session.getAttribute("usquantity");
			float total=(Float)session.getAttribute("ustotal");
			Statement sst=con.createStatement();
			ResultSet rset =sst.executeQuery("select * from User where Id ='"+myName+"'");
			//PreparedStatement st1=con.prepareStatement("insert into Current_Books(Id,Name,Author,Details,Edition,Volume,Price,Publication,Rack_Number) values(?,?,?,?,?,?,?,?,?)");
//			String s1=request.getParameter("Id");
//			String s2=request.getParameter("Name");
			String s3=request.getParameter("Address");
//			String s4=request.getParameter("Ccatogory");
//			String s5=request.getParameter("Dcatogory");
//			int s6=Integer.parseInt(request.getParameter("Quantity"));
//			String s7 =request.getParameter("Size");
//			float s8 = s6*250;
//			String s9 = request.getParameter("Contact");
			String s10 = request.getParameter("pincode");
			st.setString(1,myName);
			st.setString(2,myName);
			st.setString(3,s3);
			st.setString(4,Cloth);
			st.setString(5,Dress);
			st.setInt(6,Quantity);
			st.setString(7,Size);
			st.setFloat(8,total);
			st.setString(11, Color);
			st.setString(12, Cat);
			st.setString(13, Pattern);
			out.print("hi");
			String s = date.toString();
			//st.setString(14, "");
			out.print(date.toString());
			while(rset.next())
			{
			st.setString(9,rset.getString(4));
			st.setString(10,s10);
			st1.setString(4,rset.getString(4));
			st1.setString(5,rset.getString(5));
			}
			st1.setString(1,myName);
			st1.setString(2,myName);
			st1.setString(3,s3);
			out.print("hi");
			st.executeUpdate();
			out.print("hi");
			st1.executeUpdate();
			out.print("hi");
			response.sendRedirect("UserPage.html");
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
