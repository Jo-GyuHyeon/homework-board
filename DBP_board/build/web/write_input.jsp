<%@page import="dao.*"%>
<%@page import="bean.*"%>
<%@ page contentType = "text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%


Model model = new Model();
ModelDao dao = new ModelDaoFactory().modelDao();

model.setName(request.getParameter("name"));
model.setPass(request.getParameter("pass"));
model.setEmail(request.getParameter("email"));
model.setTitle(request.getParameter("title"));
model.setContents(request.getParameter("contents"));

dao.write(model);

response.sendRedirect("listboard.jsp"); 
%>
