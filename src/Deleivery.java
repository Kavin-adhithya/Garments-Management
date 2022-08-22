import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminDelete
 */
public class Deleivery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleivery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int i=1;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:Garments");
			String sid= request.getParameter("Uid");
			Statement st = con. createStatement();
			ResultSet rst= st.executeQuery("select Id from Order1");
			while(rst.next())
			{
					String a=rst.getString(1);
					if(a.equals(sid))
						
					{
						PreparedStatement rst1= con.prepareStatement("delete from Order1 where Id='"+sid+"'");
						rst1.executeUpdate();
						i=0;
					}
			}
			Statement st2 = con. createStatement();
			ResultSet rst2= st2.executeQuery("select Uid from Production");
			while(rst2.next())
			{
					String a=rst2.getString(1);
					if(a.equals(sid))
						
					{
						PreparedStatement rst3= con.prepareStatement("delete from Production where Uid='"+sid+"'");
						rst3.executeUpdate();
						i=0;
					}
			}
			Statement st4 = con. createStatement();
			ResultSet rst4= st4.executeQuery("select Uid from Shipment");
			while(rst4.next())
			{
					String a=rst4.getString(1);
					if(a.equals(sid))
						
					{
						PreparedStatement rst5= con.prepareStatement("delete from Shipment where Uid='"+sid+"'");
						rst5.executeUpdate();
						i=0;
					}
			}
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