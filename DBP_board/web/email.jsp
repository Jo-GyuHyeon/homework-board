<%@page import="dao.ArticleDaoFactory"%>
<%@page import="dao.ArticleDao"%>
<%@page import="bean.Article"%>
<%@ page language="java" contentType="text/html; charset=euc-kr" %>
<%@ page import = "java.sql.*, java.util.*" %>
<% request.setCharacterEncoding("euc-kr"); %>

<HTML>
<HEAD>
<TITLE> �Խ��� </TITLE>

<SCRIPT language="JavaScript">
<SCRIPT language="JavaScript">
function Check()
{
if (email.toemail.value.indexOf("@") + "" == "-1" ||
	email.toemail.value.indexOf(".") + "" == "-1" ||
	email.toemail.value == "" )
	{ 
		alert("E-mail�� �Է��ϼ���.");
		email.toemail.focus();
		return false;
	}

if (email.title.value.length < 1) {
	alert("�������� �Է��ϼ���.");
	email.title.focus(); 
	return false;
        }

if (email.contents.value.length < 1) {
	alert("�۳����� �Է��ϼ���.");
	email.contents.focus(); 
	return false;
        }

email.submit();
}


function list()
{
location.href = "listboard.jsp";
}

</SCRIPT>
</HEAD>

<BODY>

<%
String num = request.getParameter("num"); 
ArticleDao dao = new ArticleDaoFactory().modelDao();
String email = dao.getMailInfo(num);
%>
                   
<center><font size='3'><b> �̸��� �߼��ϱ� </b></font>                  

<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
	<TR>
		<TD><hr size='1' noshade>
		</TD>
 	</TR>
</TABLE>
                 
<FORM Name='email' Action='email_input.jsp' Method='POST' OnSubmit='return Check()'>
<input type='hidden' name='num' value='<%=num %>'>
      
<TABLE border='0' width='600'>
	<TR>
		<TD width='100' bgcolor='cccccc'>
			<font size='2'><center><b>��������</b></center></font> 
		</TD>
		<TD>
			<p><input type='text' size='12' name='fromemail'> * �ʼ� </p>
		</TD>
	</TR>

	<TR>
		<TD width='100' bgcolor='cccccc'>
			<font size='2'><center><b>�޴���</b></center></font>
		</TD>
		<TD>
			<p><input type='text' size='12' name='toemail' value="<%=email %>"> * �ʼ� </p>
		</TD>
	</TR>

	<TR>
      		<TD colspan='2'>
         		<hr size='1' noshade>
      		</TD>
	</TR>

	<TR>
		<TD width='100' bgcolor='cccccc'>
			<font size='2'><center><b>���� ����</b></center></font>
		</TD>
		<TD>
			<font size='2'><input type='text' size='70' maxlength='50' name='title'></font>
		</TD>
	</TR>

	<TR>
		<TD bgcolor='cccccc'>
			<font size='2'><center><b>���� ����</b></center></font>
		</TD>
		<TD>
         		<font size='2'>
         		<textarea cols='70' rows='15' wrap='virtual' name='contents'></textarea>
         		</font>
      		</TD>
	</TR>
	
	<TR>
		<TD colspan='2'><hr size='1' noshade></TD>
	</TR>

	<TR>
		<TD align='center' colspan='2' width='100%'>
		<TABLE>
			<TR>
				<TD width='200' align='center'>
					<input Type = 'Reset' Value = '�ٽ� �ۼ�'>
				</TD>
				<TD width='200' align='center'>
					<input Type = 'Submit' Value = '�̸�������'>
				</TD>
				<TD width='200' align='center'>
					<input Type = 'Button' Value = '���' Name='Page' onClick='list();'>
				</TD>
			</TR>
		</TABLE>
		</TD>
	</TR>
   
</TABLE>

</BODY>
</HTML>


