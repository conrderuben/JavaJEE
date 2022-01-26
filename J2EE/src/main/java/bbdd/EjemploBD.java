package bbdd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ejemploBD")
public class EjemploBD extends HttpServlet {
	private static final long serialVersionUID = 1L;
      	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		PreparedStatement ps= con.prepareStatement("insert into persona(id,nombre) values (?,?)" );
		ps.setInt(1,10);
	    ps.setString(2,"Pepe");
	    ps.execute();
	    pw.println("(10,Pepe) insertado");
	    
		PreparedStatement ps2=con.prepareStatement(""
			   +"select id,nombre "
			   +"from persona "
			   +"where nombre = ?");
		//ps2.setString(1,"e");
	   ResultSet rs=ps2.executeQuery();
	   pw.println("<ul>");
		while(rs.next()) {
			int id=rs.getInt("id");
			String nombre=rs.getString("nombre");
			pw.println("<li>("
					+ id
					+")"
					+nombre
					+"</li>");
		}
		pw.println("</ul>");
	   
		}catch(Exception e){
		e.printStackTrace();
	}
	}

}
