<%-- 
    Document   : UsuarioList
    Created on : 3 may. 2023, 21:11:35
    Author     : Evelyn
--%>
<%@page import="org.gerdoc.dao.Usuario"%>
<%@page import="org.gerdoc.dao.service.UsuarioService"%>
<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.dao.service.RolService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
        <table border="1">
            <tr>
                <td>Rol</td>
                <td>Descripción</td>
            </tr>
            <%
                UsuarioService usuarioService = new UsuarioService ();
                List<Usuario>List = usuarioService.getUsuarioList();
                if(List != null && List.size()> 0){
                for(Usuario usuario : List)
                {
            
            %>
            <tr>
                <td> <%=usuario.getApellidoM()  %></td>
                <td> <%=usuario.getApellidoP() %></td>
                <td> <%=usuario.getNombre() %></td>
                <td> <%=usuario.getEdad() %></td>
                <td> <%=usuario.getFecha() %></td>
            </tr>
            <%}}
             %>
        </table>
    </body>
</html>
