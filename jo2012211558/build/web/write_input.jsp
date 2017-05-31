<%@page import="dao.*"%>
<%@page import="bean.*"%>
<%@ page contentType = "text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%
/* String name   = request.getParameter("name");  
String pass   = request.getParameter("pass"); 
String email  = request.getParameter("email");
String title  = request.getParameter("title");
String contents  = request.getParameter("contents"); */

Model model = new Model();
ModelDao dao = new ModelDaoFactory().modelDao();

model.setName(request.getParameter("name"));
model.setPass(request.getParameter("pass"));
model.setEmail(request.getParameter("email"));
model.setTitle(request.getParameter("title"));
model.setContents(request.getParameter("contents"));

dao.write(model);

response.sendRedirect("/jsp/listboard.jsp"); 
%>
