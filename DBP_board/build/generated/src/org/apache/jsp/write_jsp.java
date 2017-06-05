package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class write_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("    <HEAD>\r\n");
      out.write("        <TITLE> 게시판 </TITLE>\r\n");
      out.write("\r\n");
      out.write("        <SCRIPT language=\"JavaScript\">\r\n");
      out.write("            function Check()\r\n");
      out.write("            {\r\n");
      out.write("                if (Write.name.value.length < 1) {\r\n");
      out.write("                    alert(\"작성자를 입력하세요.\");\r\n");
      out.write("                    Write.name.focus();\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                if (Write.pass.value.length < 1) {\r\n");
      out.write("                    alert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("                    Write.pass.focus();\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                if (Write.email.value.indexOf(\"@\") + \"\" == \"-1\" ||\r\n");
      out.write("                        Write.email.value.indexOf(\".\") + \"\" == \"-1\" ||\r\n");
      out.write("                        Write.email.value == \"\")\r\n");
      out.write("                {\r\n");
      out.write("                    alert(\"E-mail을 입력하세요.\");\r\n");
      out.write("                    Write.email.focus();\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                if (Write.title.value.length < 1) {\r\n");
      out.write("                    alert(\"글제목을 입력하세요.\");\r\n");
      out.write("                    Write.write_title.focus();\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                if (Write.contents.value.length < 1) {\r\n");
      out.write("                    alert(\"글내용을 입력하세요.\");\r\n");
      out.write("                    Write.content.focus();\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </SCRIPT>\r\n");
      out.write("    </HEAD>\r\n");
      out.write("\r\n");
      out.write("    <BODY>\r\n");
      out.write("\r\n");
      out.write("    <center><font size='3'><b> 게시판 글쓰기 </b></font>                   \r\n");
      out.write("\r\n");
      out.write("        <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>\r\n");
      out.write("            <TR>\r\n");
      out.write("                <TD><hr size='1' noshade>\r\n");
      out.write("                </TD>\r\n");
      out.write("            </TR>\r\n");
      out.write("        </TABLE>\r\n");
      out.write("\r\n");
      out.write("        <FORM Name='Write' Action='write_input.jsp' Method='post' enctype=\"multipart/form-data\" OnSubmit='return Check()'>\r\n");
      out.write("\r\n");
      out.write("            <TABLE border='0' width='600' cellpadding='2' cellspacing='2'>\r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD width='100' bgcolor='cccccc'>\r\n");
      out.write("                <font size='2'><center><b>작성자</b></center></font> \r\n");
      out.write("                </TD>\r\n");
      out.write("                <TD>\r\n");
      out.write("                    <p><input type='text' size='12' name='name' > * 필수</p>\r\n");
      out.write("                </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("\r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD width='100' bgcolor='cccccc'>\r\n");
      out.write("                <font size='2'><center><b>비밀번호</b></center></font>\r\n");
      out.write("                </TD>\r\n");
      out.write("                <TD>\r\n");
      out.write("                    <p><input type='password' size='12' name='pass'> * 필수 (게시물 수정 삭제시 필요합니다.)</p>\r\n");
      out.write("                </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("\r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD width='100' bgcolor='cccccc'>\r\n");
      out.write("                <font size='2'><center><b>E-mail</b></center></font>\r\n");
      out.write("                </TD>\r\n");
      out.write("                <TD>\r\n");
      out.write("                    <font size='2'><input type='text' size='40' maxlength='50' name='email'></font>\r\n");
      out.write("                </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("                \r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD width='100' bgcolor='cccccc'>\r\n");
      out.write("                <font size='2'><center><b>파일전송</b></center></font>\r\n");
      out.write("                </TD>\r\n");
      out.write("                <TD>\r\n");
      out.write("                    <input type=\"file\" name=\"filename\">\r\n");
      out.write("                </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("                \r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD colspan='2'>\r\n");
      out.write("                        <hr size='1' noshade>\r\n");
      out.write("                    </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("\r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD width='100' bgcolor='cccccc'>\r\n");
      out.write("                <font size='2'><center><b>글 제목</b></center></font>\r\n");
      out.write("                </TD>\r\n");
      out.write("                <TD>\r\n");
      out.write("                    <font size='2'><input type='text' size='70' maxlength='50' name='title'></font>\r\n");
      out.write("                </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("\r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD bgcolor='cccccc'>\r\n");
      out.write("                <font size='2'><center><b>글 내용</b></center></font>\r\n");
      out.write("                </TD>\r\n");
      out.write("                <TD>\r\n");
      out.write("                    <font size='2'>\r\n");
      out.write("                    <textarea cols='70' rows='15' wrap='virtual' name='contents' ></textarea>\r\n");
      out.write("                    </font>\r\n");
      out.write("                </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("\r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD colspan='2'>\r\n");
      out.write("                        <hr size='1' noshade>\r\n");
      out.write("                    </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("\r\n");
      out.write("                <TR>\r\n");
      out.write("                    <TD align='center' colspan='2' width='100%'>\r\n");
      out.write("                        <TABLE>\r\n");
      out.write("                            <TR>\r\n");
      out.write("                                <TD width='100' align='center'>\r\n");
      out.write("                                    <input Type = 'Reset' Value = '다시 작성'>\r\n");
      out.write("                                </TD>\r\n");
      out.write("                                <TD width='200' align='center'>\r\n");
      out.write("                                    <input Type = 'Submit' Value = '등록'>\r\n");
      out.write("                                </TD>\r\n");
      out.write("                            </TR>\r\n");
      out.write("                        </TABLE>\r\n");
      out.write("                    </TD>\r\n");
      out.write("                </TR>\r\n");
      out.write("\r\n");
      out.write("            </TABLE>\r\n");
      out.write("\r\n");
      out.write("        </FORM>\r\n");
      out.write("\r\n");
      out.write("    </BODY>\r\n");
      out.write("</HTML>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
