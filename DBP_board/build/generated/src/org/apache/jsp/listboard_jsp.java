package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sun.javafx.sg.prism.NGShape.Mode;
import java.util.*;
import dao.*;
import bean.*;

public final class listboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<HTML>\r\n");
      out.write("    <HEAD>\r\n");
      out.write("        <TITLE> 게시판 </TITLE>\r\n");
      out.write("        <SCRIPT language=\"JavaScript\">\r\n");
      out.write("            function Check()\r\n");
      out.write("            {\r\n");
      out.write("                if (Form.keyword.value.length < 1) {\r\n");
      out.write("                    alert(\"검색어를 입력하세요.\");\r\n");
      out.write("                    Form.keyword.focus();\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </SCRIPT>\r\n");
      out.write("\r\n");
      out.write("        <META http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">\r\n");
      out.write("        <style type='text/css'>\r\n");
      out.write("            <!--\r\n");
      out.write("            a:link\t\t{font-family:\"\";color:black;text-decoration:none;}\r\n");
      out.write("            a:visited\t{font-family:\"\";color:black;text-decoration:none;}\r\n");
      out.write("            a:hover\t\t{font-family:\"\";color:black;text-decoration:underline;}\r\n");
      out.write("            -->\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("    </HEAD>\r\n");
      out.write("    <BODY>\r\n");
      out.write("\r\n");
      out.write("        ");

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
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <center><font size='3'><b> 게시판 </b></font></TD>\r\n");
      out.write("\r\n");
      out.write("    <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD><hr size='1' noshade>\r\n");
      out.write("            </TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("    </TABLE>              \r\n");
      out.write("\r\n");
      out.write("    <TABLE border='0' cellspacing=1 cellpadding=2 width='600'>      \r\n");
      out.write("\r\n");
      out.write("        <TR bgcolor='cccccc'>      \r\n");
      out.write("            <TD><font size=2><center><b>번호</b></center></font></TD>      \r\n");
      out.write("        <TD><font size=2><center><b>글 제목</b></center></font></TD>      \r\n");
      out.write("        <TD><font size=2><center><b>작성자</b></center></font></TD>      \r\n");
      out.write("        <TD><font size=2><center><b>작성일</b></center></font></TD>      \r\n");
      out.write("        <TD><font size=2><center><b>조회</b></center></font></TD>      \r\n");
      out.write("        </TR>   \r\n");
      out.write("\r\n");
      out.write("        ");
            if (lastRow > 0) {
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
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <TR bgcolor='ededed'>     \r\n");
      out.write("            <TD align=center><font size=2 color='black'>\r\n");
      out.write("                ");
      out.print(listnum);
      out.write("</font></TD>     \r\n");
      out.write("            <TD align=left>\r\n");
      out.write("                <a href=\"write_output.jsp?num=");
      out.print(listnum);
      out.write("\">\r\n");
      out.write("                    <font size=2 color=\"black\">");
      out.print(title);
      out.write("</font></a>\r\n");
      out.write("            </TD>\r\n");
      out.write("            <TD align=center>    \r\n");
      out.write("                <a href=\"email.jsp?num=");
      out.print(listnum);
      out.write("\">\r\n");
      out.write("                    <font size=2 color=\"black\">");
      out.print(name);
      out.write("</font></a>     \r\n");
      out.write("            </TD>     \r\n");
      out.write("            <TD align=center><font size=2>");
      out.print(writedate);
      out.write("</font>\r\n");
      out.write("            </TD>     \r\n");
      out.write("            <TD align=center><font size=2>");
      out.print(readcount);
      out.write("</font>     \r\n");
      out.write("        </TR>  \r\n");
      out.write("\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </TABLE>     \r\n");
      out.write("\r\n");
      out.write("    <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD><hr size='1' noshade>\r\n");
      out.write("            </TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("    </TABLE>                    \r\n");
      out.write("\r\n");
      out.write("    ");

        }

        if (paging.getStartPage() > 5) {
    
      out.write("\r\n");
      out.write("    <a href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage() - 5);
      out.write("\">[이전]</a>\t\r\n");
      out.write("    ");

        }
        while (paging.getStartPage() <= paging.getEndPage()) {
    
      out.write("\r\n");
      out.write("    <a href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage());
      out.write("\">[");
      out.print(paging.getStartPage());
      out.write("]</a>\r\n");
      out.write("    ");


            paging.setStartPage(paging.getStartPage() + 1);
        }
        if (paging.getEndPage() < paging.getTotalPages()) {
    
      out.write("\r\n");
      out.write("    <a href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage());
      out.write("\">[다음]</a>\r\n");
      out.write("    ");

        }
    
      out.write("  \r\n");
      out.write("    <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD><hr size='1' noshade>\r\n");
      out.write("            </TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("    </TABLE>                    \r\n");
      out.write("\r\n");
      out.write("    <TABLE border=0 width=600>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD align='center'>\t\r\n");
      out.write("                <TABLE border='0' cellpadding='0' cellspacing='0'>\r\n");
      out.write("                    <FORM Name='Form' Method='POST' Action='listboard.jsp' method = 'post' OnSubmit='return Check()'>\r\n");
      out.write("                        <input type='hidden' name='search' value='1'>\r\n");
      out.write("                        <TR>\r\n");
      out.write("                            <TD align='right'>\r\n");
      out.write("                                <select name='key' style=\"background-color:cccccc;\">\r\n");
      out.write("                                    <option value='title' selected><font size='2'>\r\n");
      out.write("                                    글제목</font></option>\r\n");
      out.write("                                    <option value='contents'><font size='2'>\r\n");
      out.write("                                    글내용</font></option>\r\n");
      out.write("                                    <option value='name'><font size='2'>\r\n");
      out.write("                                    작성자</font></option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </TD>\r\n");
      out.write("                            <TD align='left'>\r\n");
      out.write("                                <input type='text' name='keyword' \r\n");
      out.write("                                       value='' size='20' maxlength='30'>\r\n");
      out.write("                                <input type='submit' value='검색'>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </TR>\r\n");
      out.write("                    </FORM>\r\n");
      out.write("                </TABLE> \r\n");
      out.write("            </TD>\r\n");
      out.write("\r\n");
      out.write("            <TD align='right'>\t\t\r\n");
      out.write("                <a href='./write.jsp'>[등록]</a>\t\t\t\t\r\n");
      out.write("            </TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("    </TABLE>  \r\n");
      out.write("</BODY>                     \r\n");
      out.write("</HTML>\r\n");
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
