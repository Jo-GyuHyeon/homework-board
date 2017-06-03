<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %>
<%@page import="dao.*"%>
<%@page import="bean.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<HTML>
    <HEAD>
        <TITLE> 게시판 </TITLE>

        <SCRIPT language="JavaScript">
            function Check()
            {
                if (Modify.name.value.length < 1) {
                    alert("작성자를 입력하세요.");
                    Modify.name.focus();
                    return false;
                }

                if (Modify.pass.value.length < 1) {
                    alert("비밀번호를 입력하세요.");
                    Modify.pass.focus();
                    return false;
                }

                if (Modify.email.value.indexOf("@") + "" == "-1" ||
                        Modify.email.value.indexOf(".") + "" == "-1" ||
                        Modify.email.value == "")
                {
                    alert("E-mail을 입력하세요.");
                    Modify.email.focus();
                    return false;
                }

                if (Modify.title.value.length < 1) {
                    alert("글제목을 입력하세요.");
                    Modify.title.focus();
                    return false;
                }

                if (Modify.contents.value.length < 1) {
                    alert("글내용을 입력하세요.");
                    Modify.contents.focus();
                    return false;
                }
            }

            function list()
            {
                location.href = "./listboard.jsp";
            }

        </SCRIPT>
    </HEAD>

    <BODY>

        <%
            String num = request.getParameter("num");

            ArticleDao dao = new ArticleDaoFactory().modelDao();
            Article model = dao.getModel(num);

            String name = model.getName();
            String email = model.getEmail();
            String title = model.getTitle();
            String contents = model.getContents().trim();
            String writedate = model.getWritedate();
            int readcount = model.getReadcount();
        %>

    <center><font size='3'><b> 게시판 글수정 </b></font>                  

        <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
            <TR>
                <TD><hr size='1' noshade>
                </TD>
            </TR>
        </TABLE>

        <FORM Name='Modify' Action='modify_output.jsp' Method='POST' OnSubmit='return Check()'>
            <input type='hidden' name='num' value='<%=num%>'>

            <TABLE border='0' width='600'>
                <TR>
                <TD width='100' bgcolor='cccccc'>
                <font size='2'><center><b>작성자</b></center></font> 
                </TD>
                <TD>
                    <p><input type='text' size='12' name='name' value="<%=name%>"> * 필수 </p>
                </TD>
                </TR>

                <TR>
                    <TD width='100' bgcolor='cccccc'>
                <font size='2'><center><b>비밀번호</b></center></font>
                </TD>
                <TD>
                    <p><input type='password' size='12' name='pass'> * 필수 </p>
                </TD>
                </TR>

                <TR>
                    <TD width='100' bgcolor='cccccc'>
                <font size='2'><center><b>E-mail</b></center></font>
                </TD>
                <TD>
                    <font size='2'><input type='text' size='40' maxlength='50' name='email' value="<%=email%>"></font>
                </TD>
                </TR>

                <TR>
                    <TD colspan='2'>
                        <hr size='1' noshade>
                    </TD>
                </TR>

                <TR>
                    <TD width='100' bgcolor='cccccc'>
                <font size='2'><center><b>글 제목</b></center></font>
                </TD>
                <TD>
                    <font size='2'><input type='text' size='70' maxlength='50' name='title' value="<%=title%>"></font>
                </TD>
                </TR>

                <TR>
                    <TD bgcolor='cccccc'>
                <font size='2'><center><b>글 내용</b></center></font>
                </TD>
                <TD>
                    <font size='2'>
                    <textarea cols='70' rows='15' wrap='virtual' name='contents'><%=contents%></textarea>
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
                                    <input Type = 'Reset' Value = '다시 작성'>
                                </TD>
                                <TD width='200' align='center'>
                                    <input Type = 'Submit' Value = '수정완료'>
                                </TD>
                                <TD width='200' align='center'>
                                    <input Type = 'Button' Value = '목록' Name='Page' onClick='list();'>
                                </TD>
                            </TR>
                        </TABLE>
                    </TD>
                </TR>

            </TABLE>

            </BODY>
            </HTML>


