<%@page import="com.sun.javafx.sg.prism.NGShape.Mode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %>
<%@ page import = "dao.*" %>
<%@ page import = "bean.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<HTML>
    <HEAD>
        <TITLE> 게시판 </TITLE>
        <SCRIPT language="JavaScript">
            function Check()
            {
                if (Form.keyword.value.length < 1) {
                    alert("검색어를 입력하세요.");
                    Form.keyword.focus();
                    return false;
                }
            }
        </SCRIPT>

        <META http-equiv="Content-Type" content="text/html; charset=euc-kr">
        <style type='text/css'>
            <!--
            a:link		{font-family:"";color:black;text-decoration:none;}
            a:visited	{font-family:"";color:black;text-decoration:none;}
            a:hover		{font-family:"";color:black;text-decoration:underline;}
            -->
        </style>

    </HEAD>
    <BODY>

        <%
            String key = request.getParameter("key");
            String keyword = request.getParameter("keyword");

            String pageNum = request.getParameter("pageNum");
            if (pageNum == null) {
                pageNum = "1";
            }

            int listSize = 10;
            int pageSize = 10;
            int currentPage = Integer.parseInt(pageNum);
            int lastRow = 0;
            List list = null;
            ArticleDao dao = new ArticleDaoFactory().articleDao();
            lastRow = dao.getSelectLastRow(key, keyword);
            int endRow = lastRow - ((Integer.parseInt(pageNum) - 1) * listSize);
            int startRow = endRow - (listSize - 1);
            Paging paging = new Paging(lastRow, Integer.parseInt(pageNum), listSize, pageSize);
        %>

    <center><font size='3'><b> 게시판 </b></font></TD>

    <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
        <TR>
            <TD><hr size='1' noshade>
            </TD>
        </TR>
    </TABLE>              

    <TABLE border='0' cellspacing=1 cellpadding=2 width='600'>      

        <TR bgcolor='cccccc'>      
            <TD><font size=2><center><b>번호</b></center></font></TD>      
        <TD><font size=2><center><b>글 제목</b></center></font></TD>      
        <TD><font size=2><center><b>작성자</b></center></font></TD>      
        <TD><font size=2><center><b>작성일</b></center></font></TD>      
        <TD><font size=2><center><b>조회</b></center></font></TD>      
        </TR>   

        <%            if (lastRow > 0) {
                list = dao.getSelectDBAll(startRow, endRow, key, keyword);

                Iterator it = list.iterator();
                Article bean;
                while (it.hasNext()) {
                    bean = (Article) it.next();
                    int listnum = bean.getNum();
                    String name = bean.getName();
                    String email = bean.getEmail();
                    String title = bean.getTitle();
                    String writedate = bean.getWritedate();
                    int readcount = bean.getReadcount();
        %>

        <TR bgcolor='ededed'>     
            <TD align=center><font size=2 color='black'>
                <%=listnum%></font></TD>     
            <TD align=left>
                <a href="write_output.jsp?num=<%=listnum%>">
                    <font size=2 color="black"><%=title%></font></a>
            </TD>
            <TD align=center>    
                <a href="email.jsp?num=<%=listnum%>">
                    <font size=2 color="black"><%=name%></font></a>     
            </TD>     
            <TD align=center><font size=2><%=writedate%></font>
            </TD>     
            <TD align=center><font size=2><%=readcount%></font>     
        </TR>  

        <%
            }
        %>

    </TABLE>     

    <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
        <TR>
            <TD><hr size='1' noshade>
            </TD>
        </TR>
    </TABLE>                    

    <%
        }

        if (paging.getStartPage() > 5) {
    %>
    <a href="./listboard.jsp?pageNum=<%=paging.getStartPage() - 5%>">[이전]</a>	
    <%
        }
        while (paging.getStartPage() <= paging.getEndPage()) {
    %>
    <a href="./listboard.jsp?pageNum=<%=paging.getStartPage()%>">[<%=paging.getStartPage()%>]</a>
    <%

            paging.setStartPage(paging.getStartPage() + 1);
        }
        if (paging.getEndPage() < paging.getTotalPages()) {
    %>
    <a href="./listboard.jsp?pageNum=<%=paging.getStartPage()%>">[다음]</a>
    <%
        }
    %>  
    <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
        <TR>
            <TD><hr size='1' noshade>
            </TD>
        </TR>
    </TABLE>                    

    <TABLE border=0 width=600>
        <TR>
            <TD align='center'>	
                <TABLE border='0' cellpadding='0' cellspacing='0'>
                    <FORM Name='Form' Method='POST' Action='listboard.jsp' method = 'post' OnSubmit='return Check()'>
                        <input type='hidden' name='search' value='1'>
                        <TR>
                            <TD align='right'>
                                <select name='key' style="background-color:cccccc;">
                                    <option value='title' selected><font size='2'>
                                    글제목</font></option>
                                    <option value='contents'><font size='2'>
                                    글내용</font></option>
                                    <option value='name'><font size='2'>
                                    작성자</font></option>
                                </select>
                            </TD>
                            <TD align='left'>
                                <input type='text' name='keyword' 
                                       value='' size='20' maxlength='30'>
                                <input type='submit' value='검색'>
                            </td>
                        </TR>
                    </FORM>
                </TABLE> 
            </TD>

            <TD align='right'>		
                <a href='./write.jsp'>[등록]</a>				
            </TD>
        </TR>
    </TABLE>  
</BODY>                     
</HTML>
