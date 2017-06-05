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
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <!-- Standard Meta -->\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\">\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\" integrity=\"sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"semantic/semantic.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"semantic/semantic.css\" />\r\n");
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
      out.write("            function boardWrite(pageNum)\r\n");
      out.write("            {\r\n");
      out.write("                //  alert(pageNum);\r\n");
      out.write("                location.href = \"./write.jsp?pageNum=\" + pageNum;\r\n");
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
            //  int currentPage = Integer.parseInt(pageNum);
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
      out.write("\r\n");
      out.write("    <table class=\"ui unstackable table\">\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th><center><b>번호</b></center></th>\r\n");
      out.write("        <th><center><b>글 제목</b></center></th>\r\n");
      out.write("        <th><center><b>작성자</b></center></th>\r\n");
      out.write("        <th><center><b>작성일</b></center></th>\r\n");
      out.write("        <th><center><b>조회</b></center></th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </thead> \r\n");
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
      out.write("        <tbody>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td >");
      out.print(listnum);
      out.write("</td>\r\n");
      out.write("                <td ><a href=\"write_output.jsp?num=");
      out.print(listnum);
      out.write('"');
      out.write('>');
      out.print(title);
      out.write("</a></td>\r\n");
      out.write("                <td ><a href=\"email.jsp?num=");
      out.print(listnum);
      out.write('"');
      out.write('>');
      out.print(name);
      out.write("</a></td>\r\n");
      out.write("                <td >");
      out.print(writedate);
      out.write("</td>\r\n");
      out.write("                <td >");
      out.print(readcount);
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </tbody>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </table>    \r\n");
      out.write("    <table class=\"ui celled table\">  \r\n");
      out.write("\r\n");
      out.write("        <tfoot>\r\n");
      out.write("            <tr><th colspan=\"3\">\r\n");
      out.write("                    <div class=\"ui right floated pagination menu\">\r\n");
      out.write("                        ");

                            }

                            if (paging.getStartPage() > 5) {
                        
      out.write("\r\n");
      out.write("                        <a class=\"icon item\" href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage() - 5);
      out.write("\">[이전]</a>\t\r\n");
      out.write("                        ");

                            }
                            while (paging.getStartPage() <= paging.getEndPage()) {
                        
      out.write("\r\n");
      out.write("                        <a class=\"item\" href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage());
      out.write('"');
      out.write('>');
      out.print(paging.getStartPage());
      out.write("</a>\r\n");
      out.write("                        ");


                                paging.setStartPage(paging.getStartPage() + 1);
                            }
                            if (paging.getEndPage() < paging.getTotalPages()) {
                        
      out.write("\r\n");
      out.write("                        <a class=\"icon item\" href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage());
      out.write("\">[다음]</a>\r\n");
      out.write("                        ");

                            }
                        
      out.write("  \r\n");
      out.write("                    </div>\r\n");
      out.write("                </th>\r\n");
      out.write("            </tr></tfoot>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <TABLE border=0 width=600>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD align='center'>\t\r\n");
      out.write("                <TABLE border='0' cellpadding='0' cellspacing='0'>\r\n");
      out.write("\r\n");
      out.write("                    <FORM Name='Form' Method='POST' Action='listboard.jsp' method = 'post' OnSubmit='return Check()'>\r\n");
      out.write("                        \r\n");
      out.write("                        <input type='hidden' name='search' value='1'>\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"ui action input\">\r\n");
      out.write("                            <input type='text' placeholder=\"Search...\" name='keyword' size='20' maxlength='30'>\r\n");
      out.write("                            <select name=\"key\" class=\"ui compact selection dropdown\">\r\n");
      out.write("                                <option value='title' selected>글제목</option>\r\n");
      out.write("                                <option value='contents'>글내용</option>\r\n");
      out.write("                                <option value='name'>작성자</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                            <button type=\"submit\" class=\"ui button\"/>Search</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </FORM>\r\n");
      out.write("                </TABLE> \r\n");
      out.write("            </TD>\r\n");
      out.write("            <TD align='right'>\t\t\r\n");
      out.write("                <button class=\"ui button\" onclick='boardWrite(");
      out.print(pageNum);
      out.write(")'>등록</button>\r\n");
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
