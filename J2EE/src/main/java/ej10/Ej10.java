package ej10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Ej10")
public class Ej10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
			pw.println("<form method=\"post\">");
			pw.println("Nombre:");
			pw.println("<input type=\"text\" name=\"nombre\"> ");
			pw.println("<br>");
			pw.println("Contrase�a:");
			pw.println("<input type=\"password\" name=\"pwd\"> ");
			pw.println("<br>");
			pw.println("<input type=\"submit\">");
			pw.println("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String pwd=request.getParameter("pwd");
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		if((nombre.equals("Andrei")&&pwd.equals("aa"))||(nombre.equals("Juan")&&pwd.equals("aa"))) {
			Cookie[] cs= request.getCookies();
			String valor=obtenerCookie(nombre,cs);
			pw.println("Bienvenido "+nombre);
			if(valor==null) {
			pw.println("Es la primera vez que te vemos");	
			}else {
				long horaDesconexion=Long.parseLong(valor);
				long horaActual=System.currentTimeMillis();
				long diferencia= (horaActual-horaDesconexion)/1000;
				if(diferencia>=60) {
					pw.println("Hace mas de 1 min que no te veo");
				}else {
					pw.println("Hace "+diferencia+" segundos que no te veo");
				}
			}
	
			pw.println(""
					+"<form action=\"/Ejercicios/ej10logout\">"
					+"<input type=\"submit\" value=\"Logout\"/>"
					+"<input type=\"hidden\" name=\"nombre\" value=\""+nombre+"\" />"
					+"</form>");
		}else {
			pw.println("Credenciales incorrectas");
		}
	}


	private String obtenerCookie(String nombreCookie, Cookie[] arrayCookies) {
		String valor=null;
		if(arrayCookies!=null) {
		for(Cookie c : arrayCookies) {
			if(c.getName().equals(nombreCookie)) {
				valor=c.getValue();
			}
		}
		}
		return valor;
	}

}

