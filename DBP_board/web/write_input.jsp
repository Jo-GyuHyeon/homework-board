<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="dao.*"%>
<%@page import="bean.*"%>
<%@ page contentType = "text/html; charset=UTF-8" %>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<% request.setCharacterEncoding("UTF-8"); %>

            
<%
    int MAX = 1024*1024*20;
    String rootPath = request.getSession().getServletContext().getRealPath("/");
    String savePath = rootPath + "filesave";
    MultipartRequest multipartRequest = new MultipartRequest(request, savePath, MAX, "UTF-8", new DefaultFileRenamePolicy());
    Article model = new Article();
    ArticleDao dao = new ArticleDaoFactory().modelDao();
    String filename = dao.controlFileUpload(multipartRequest);
    
    model.setName(multipartRequest.getParameter("name"));
    model.setPass(multipartRequest.getParameter("pass"));
    model.setEmail(multipartRequest.getParameter("email"));
    model.setTitle(multipartRequest.getParameter("title"));
    model.setContents(multipartRequest.getParameter("contents"));
    model.setFilename(filename);
    dao.write(model);

    response.sendRedirect("./listboard.jsp");
%>
