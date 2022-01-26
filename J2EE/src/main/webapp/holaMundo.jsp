<h1>Hola mundo</h1>
<%! int doble(int x){return 2*x;}%>
<%
for(int i=1;i<5;i++){
	out.println("<h"+i+">Hola</h"+i+">");
	out.println(doble(10));
}	
%>
<%@page import="java.util.Random" %>
<%
Random r=new Random();

for(int i=0;i<15;i++){
	String tamano=""+(r.nextInt(6)+1);
out.println("<h"+tamano+">Hola</h"+tamano+">");
}
%>
<h1>Hola mundo</h1>
<%=doble(10)%>
<h1>Adios</h1>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Enlace para usar jsp -->
