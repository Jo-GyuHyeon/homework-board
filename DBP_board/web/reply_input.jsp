<%@page import="dao.*"%>
<%@page import="bean.*"%>
<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.util.*" %>
<% request.setCharacterEncoding("euc-kr"); %>

<%
    int num = 0;
Article model = new Article();
ArticleDao dao = new ArticleDaoFactory().modelDao();
model.setNum(Integer.parseInt(request.getParameter("num")));
model.setName(request.getParameter("name"));
model.setPass(request.getParameter("pass"));
model.setEmail(request.getParameter("email"));
model.setTitle(request.getParameter("title"));
model.setContents(request.getParameter("contents"));

dao.reply(model);

response.sendRedirect("./listboard.jsp"); 
%>
