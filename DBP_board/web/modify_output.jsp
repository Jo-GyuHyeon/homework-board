<%@page import="dao.*"%>
<%@page import="bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%
int num  = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");
String pass = request.getParameter("pass");
String email = request.getParameter("email");
String title = request.getParameter("title");
String contents = request.getParameter("contents");


Article model = new Article();
ArticleDao dao = new ArticleDaoFactory().modelDao();

model.setName(name);
model.setPass(pass);
model.setEmail(email);
model.setTitle(title);
model.setContents(contents);
model.setNum(num);

dao.update(model);

response.sendRedirect("./listboard.jsp");
%>