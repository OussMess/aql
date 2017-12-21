<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
    Document   : Bienvenue
    Created on : 10-Dec-2017, 13:13:00
    Author     : Asus Gamers
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue</title>
    </head>
    <body>
    <center><h1>Bienvenue <% out.print(request.getAttribute("username")); %></h1></center>
    <table border="1px" cellpadding="0" cellspacing="0">
        <caption>comments :</caption>
        <%
            ArrayList<String> listProf ;
            listProf = (ArrayList<String>) request.getAttribute("comments");


            for(Iterator<String> it = listProf.iterator(); it.hasNext();){
                String comment = it.next();
                out.println("<tr><td>"+comment+"</td></tr>");
            }


        %>
    </table>
    </body>
</html>
