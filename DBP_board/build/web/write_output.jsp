<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %>
<%@page import="dao.*"%>
<%@page import="bean.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<HTML>
<HEAD>
<TITLE> 게시판 </TITLE>

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
String num = request.getParameter("num"); 

ModelDao dao = new ModelDaoFactory().modelDao();
Model model = dao.getModel(num);

%>

<center><font size='3'><b> 게시판 </b></font>

<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
	<TR>
		<TD><hr size='1' noshade>
		</TD>
 	</TR>
</TABLE>

<TABLE border='0' width='600'>
	<TR>
    		<TD align='left'>
      		<font size='2'> 작성자 : <%=model.getName()%></font>
    		</TD>
    		
    		<TD align=right>
      		<font size='2'>작성일: <%=model.getWritedate()%>, 조회수: <%=model.getReadcount()%></font>
    		</TD>
    	</TR>
</TABLE>

<TABLE border='0' cellspacing=3 cellpadding=3 width='600'>
	<TR bgcolor='cccccc'>
		<TD align='center'>
    		<font size='3'><b><%=model.getTitle() %></font>
		</TD>
	</TR>
</TABLE>

<TABLE border='0' cellspacing=5 cellpadding=10 width='600'>
	<TR bgcolor='ededed'>
		<TD><font size='2' color=''><%=model.getContents()%></font>
		</TD>
	</TR>
</TABLE>

<TABLE border='0' width='600'>
	<TR>
    		<TD align='right'>
		<font size='2'><br><font size='2'></font>
    		</TD>
	</TR>
</TABLE>

<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
  	<TR>
  		<TD><hr size='1' noshade>
  		</TD>
  	</TR>
</TABLE>

<TABLE border='0' width='600'>
	<TR>
		<TD align='left'>
			<a href="modify_pass.jsp?num=<%=num %>">[수정하기]</a>
			<a href="delete_pass.jsp?num=<%=num %>">[삭제하기]</a>
		</TD>

		<TD align='right'>
			<a href="reply.jsp?num=<%=num %>">[답변하기]</a>
			<a href='write.jsp'>[글쓰기]</a>
			<a href='listboard.jsp'>[목록보기]</a>
 		</TD>
	</TR>
</TABLE>

<%
dao.update_readcount(num);

%>

</TABLE>

</BODY>
</HTML>
