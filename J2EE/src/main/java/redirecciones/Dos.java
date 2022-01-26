package redirecciones;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/r/dos")
public class Dos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=(String)request.getAttribute("nombre");
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
						pw.println("<h1>DOS</h1>,el nombre enviado es "+nombre);
			

				
	}
	
	
	
}
