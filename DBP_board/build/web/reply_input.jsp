<%@page import="dao.*"%>
<%@page import="bean.*"%>
<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%
    int num = 0;
Article ariticle = new Article();
ArticleDao dao = new ArticleDaoFactory().articleDao();
ariticle.setNum(Integer.parseInt(request.getParameter("num")));
ariticle.setName(request.getParameter("name"));
ariticle.setPass(request.getParameter("pass"));
ariticle.setEmail(request.getParameter("email"));
ariticle.setTitle(request.getParameter("title"));
ariticle.setContents(request.getParameter("contents"));

dao.reply(ariticle);

response.sendRedirect("./listboard.jsp"); 
%>
