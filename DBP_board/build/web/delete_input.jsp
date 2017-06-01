<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="bean.*"%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<%
    String num = request.getParameter("num");
    String pass = request.getParameter("pass");

    ArticleDao dao = new ArticleDaoFactory().modelDao();
    String goodpass = dao.getPass(num).trim();
    //String goodpass = rs.getString("pass").trim();

    if (pass.equals(goodpass)) {
        dao.delete(num);
        response.sendRedirect("./listboard.jsp");
    } else {
        response.sendRedirect("./delete_pass.jsp?num=" + num);
    }

%>
