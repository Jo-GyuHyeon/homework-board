<%@page import="bean.Model"%>
<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=euc-kr" %>
<%@ page import = " java.util.*" %>
<% request.setCharacterEncoding("euc-kr"); %>


<HTML>
    <HEAD>
        <TITLE> �Խ��� </TITLE>

        <SCRIPT language="JavaScript">
            function Check()
            {
                if (Modify.name.value.length < 1) {
                    alert("�ۼ��ڸ� �Է��ϼ���.");
                    Modify.name.focus();
                    return false;
                }

                if (Modify.pass.value.length < 1) {
                    alert("��й�ȣ�� �Է��ϼ���.");
                    Modify.pass.focus();
                    return false;
                }

                if (Modify.email.value.indexOf("@") + "" == "-1" ||
                        Modify.email.value.indexOf(".") + "" == "-1" ||
                        Modify.email.value == "")
                {
                    alert("E-mail�� �Է��ϼ���.");
                    Modify.email.focus();
                    return false;
                }

                if (Modify.title.value.length < 1) {
                    alert("�������� �Է��ϼ���.");
                    Modify.title.focus();
                    return false;
                }

                if (Modify.contents.value.length < 1) {
                    alert("�۳����� �Է��ϼ���.");
                    Modify.contents.focus();
                    return false;
                }

            }

            function list()
            {
                location.href = "./listboard.asp";
            }

        </SCRIPT>
    </HEAD>

    <BODY>

        <%
            String num = request.getParameter("num");

            ArticleDao dao = new ArticleDaoFactory().modelDao();
            Model model = dao.getModel(num);
            String title = model.getTitle();

        %>

    <center><font size='3'><b> �亯�ϱ� </b></font>                  

        <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
            <TR>
                <TD><hr size='1' noshade>
                </TD>
            </TR>
        </TABLE>

        <FORM Name='Modify' action='./reply_input.jsp' method = 'post' onSubmit = 'return Check()'>
            <input type='hidden' name='num' value='<%=num%>'>

            <TABLE border='0' width='600'>
                <TR>
                    <TD width='100' bgcolor='cccccc'>
                <font size='2'><center><b>�ۼ���</b></center></font> 
                </TD>
                <TD>
                    <p><input type='text' size='12' name='name' value=""> * �ʼ� </p>
                </TD>
                </TR>

                <TR>
                    <TD width='100' bgcolor='cccccc'>
                <font size='2'><center><b>��й�ȣ</b></center></font>
                </TD>
                <TD>
                    <p><input type='password' size='12' name='pass'> * �ʼ� </p>
                </TD>
                </TR>

                <TR>
                    <TD width='100' bgcolor='cccccc'>
                <font size='2'><center><b>E-mail</b></center></font>
                </TD>
                <TD>
                    <font size='2'><input type='text' size='40' maxlength='50' name='email' value=""></font>
                </TD>
                </TR>

                <TR>
                    <TD colspan='2'>
                        <hr size='1' noshade>
                    </TD>
                </TR>

                <TR>
                    <TD width='100' bgcolor='cccccc'>
                <font size='2'><center><b>�� ����</b></center></font>
                </TD>
                <TD>
                    <font size='2'><input type='text' size='70' maxlength='50' name='title' value="[�亯]<%=title%>"></font>
                </TD>
                </TR>

                <TR>
                    <TD bgcolor='cccccc'>
                <font size='2'><center><b>�� ����</b></center></font>
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
                                    <input Type = 'Submit' Value = '�Ϸ�'>
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


