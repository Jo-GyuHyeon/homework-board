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


Article ariticle = new Article();
ArticleDao dao = new ArticleDaoFactory().articleDao();

ariticle.setName(name);
ariticle.setPass(pass);
ariticle.setEmail(email);
ariticle.setTitle(title);
ariticle.setContents(contents);
ariticle.setNum(num);

dao.update(ariticle);

response.sendRedirect("./listboard.jsp");
%>