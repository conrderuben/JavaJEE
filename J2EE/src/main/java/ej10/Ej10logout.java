package ej10;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ej10logout")
public class Ej10logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		long horaDesconexion= System.currentTimeMillis();
	Cookie c=new Cookie(nombre,Long.toString(horaDesconexion));
	response.addCookie(c);
	response.sendRedirect("/Ejercicios/ej10");
	}

	

}

