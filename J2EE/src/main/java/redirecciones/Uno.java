package redirecciones;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/r/uno")
public class Uno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
			pw.println("<h1>UNO</h1>");
			
			//request.setAttribute("nombre", "Andrei");
			request.setAttribute("nombre", request.getParameter("nombre"));
			
			//response.sendRedirect("/Ejercicios/r/dos");
			request.getRequestDispatcher("/r/dos").forward(request, response);
			//request.getRequestDispatcher("/r/dos").include(request, response);
			
		

				
	}
	
	
	
}
