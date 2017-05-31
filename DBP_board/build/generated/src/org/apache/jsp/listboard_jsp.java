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
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE> 게시판 </TITLE>\r\n");
      out.write("<SCRIPT language=\"JavaScript\">\r\n");
      out.write("function Check()\r\n");
      out.write("{\r\n");
      out.write("if (Form.keyword.value.length < 1) {\r\n");
      out.write("\talert(\"검색어를 입력하세요.\");\r\n");
      out.write("\tForm.keyword.focus(); \r\n");
      out.write("         return false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<META http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">\r\n");
      out.write("<style type='text/css'>\r\n");
      out.write("<!--\r\n");
      out.write("\ta:link\t\t{font-family:\"\";color:black;text-decoration:none;}\r\n");
      out.write("\ta:visited\t{font-family:\"\";color:black;text-decoration:none;}\r\n");
      out.write("\ta:hover\t\t{font-family:\"\";color:black;text-decoration:underline;}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("\r\n");

String pageNum = request.getParameter("pageNum");
if(pageNum == null){
	pageNum = "1";
}

int listSize = 5;
int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * listSize + 1;
int endRow = currentPage * listSize;
int lastRow = 0;

ModelDao dao = new ModelDaoFactory().modelDao();
lastRow=dao.getLastRow();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<center><font size='3'><b> 게시판 </b></font></TD>\r\n");
      out.write("                                    \r\n");
      out.write("<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD><hr size='1' noshade>\r\n");
      out.write("\t\t</TD>\r\n");
      out.write(" \t</TR>\r\n");
      out.write("</TABLE>              \r\n");
      out.write("                    \r\n");
      out.write("<TABLE border='0' cellspacing=1 cellpadding=2 width='600'>      \r\n");
      out.write("\r\n");
      out.write("\t<TR bgcolor='cccccc'>      \r\n");
      out.write("\t\t<TD><font size=2><center><b>번호</b></center></font></TD>      \r\n");
      out.write("\t\t<TD><font size=2><center><b>글 제목</b></center></font></TD>      \r\n");
      out.write("\t\t<TD><font size=2><center><b>작성자</b></center></font></TD>      \r\n");
      out.write("\t\t<TD><font size=2><center><b>작성일</b></center></font></TD>      \r\n");
      out.write("\t\t<TD><font size=2><center><b>조회</b></center></font></TD>      \r\n");
      out.write("\t</TR>   \r\n");
      out.write("\t\r\n");

if(lastRow > 0) {
	
	List list = dao.getDBAll(startRow, endRow);
	Iterator it = list.iterator();
	Model bean;
	while(it.hasNext()){
		bean=(Model)it.next();

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<TR bgcolor='ededed'>     \r\n");
      out.write("\t\t<TD align=center><font size=2 color='black'>\r\n");
      out.write("                                    ");
      out.print(bean.getNum() );
      out.write("</font></TD>     \r\n");
      out.write("\t\t<TD align=left>\r\n");
      out.write("\t\t\t<a href=\"write_output.jsp?num=");
      out.print(bean.getNum() );
      out.write("\">\r\n");
      out.write("\t\t\t<font size=2 color=\"black\">");
      out.print(bean.getTitle() );
      out.write("</font></a>\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t\t<TD align=center>    \r\n");
      out.write("\t\t\t<a href=\"");
      out.print(bean.getEmail() );
      out.write("\">\r\n");
      out.write("\t\t\t<font size=2 color=\"black\">");
      out.print(bean.getName() );
      out.write("</font></a>     \r\n");
      out.write("\t\t</TD>     \r\n");
      out.write("\t\t<TD align=center><font size=2>");
      out.print(bean.getWritedate() );
      out.write("</font>\r\n");
      out.write("\t\t</TD>     \r\n");
      out.write("\t\t<TD align=center><font size=2>");
      out.print(bean.getReadcount() );
      out.write("</font>     \r\n");
      out.write("\t</TR>  \r\n");
      out.write("\t   \t\r\n");
     
	}	

      out.write("\r\n");
      out.write("\r\n");
      out.write("</TABLE>     \r\n");
      out.write("                \r\n");
      out.write("<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD><hr size='1' noshade>\r\n");
      out.write("\t\t</TD>\r\n");
      out.write(" \t</TR>\r\n");
      out.write("</TABLE>                    \r\n");
      out.write("\r\n");
      out.write("<TABLE border=0 width=600>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD align=left>\t\t\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\r\n");
      out.write("\t\t<TD align='right'>\t\t\r\n");
      out.write("\t\t<a href='write.jsp'>[등록]</a>\t\t\t\t\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("</TABLE>\r\n");
      out.write("\t                   \r\n");


}

if(lastRow > 0) {
	int setPage = 1;
	int lastPage = 0;
	if(lastRow % listSize == 0)
		lastPage = lastRow / listSize;
	else
		lastPage = lastRow / listSize + 1;

	if(currentPage > 1) {

      out.write("\r\n");
      out.write("\t<a href=\"listboard.jsp?pageNum=");
      out.print(currentPage-1);
      out.write("\">[이전]</a>\t\r\n");
	
	}
	while(setPage <= lastPage) {

      out.write("\r\n");
      out.write("\t\t<a href=\"listboard.jsp?pageNum=");
      out.print(setPage);
      out.write("\">[");
      out.print(setPage);
      out.write("]</a>\r\n");

		setPage = setPage + 1;
	}
	if(lastPage > currentPage) {

      out.write("\r\n");
      out.write("\t\t<a href=\"listboard.jsp?pageNum=");
      out.print(currentPage+1);
      out.write("\">[다음]</a>\r\n");

	}
}

      out.write("  \r\n");
      out.write("                <TABLE border='0' width='600' cellpadding='0' cellspacing='0'>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD><hr size='1' noshade>\r\n");
      out.write("\t\t</TD>\r\n");
      out.write(" \t</TR>\r\n");
      out.write("</TABLE>                    \r\n");
      out.write("\r\n");
      out.write("<TABLE border=0 width=600>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD align='center'>\t\r\n");
      out.write("\t\t\t<TABLE border='0' cellpadding='0' cellspacing='0'>\r\n");
      out.write("\t\t\t<FORM Name='Form' Method='POST' Action='listboard.jsp' OnSubmit='return Check()'>\r\n");
      out.write("\t\t\t<input type='hidden' name='search' value='1'>\r\n");
      out.write("\t\t\t<TR>\r\n");
      out.write("\t\t\t\t<TD align='right'>\r\n");
      out.write("\t\t\t\t<select name='key' style=\"background-color:cccccc;\">\r\n");
      out.write("\t\t\t\t<option value='title' selected><font size='2'>\r\n");
      out.write("                                                        글제목</font></option>\r\n");
      out.write("\t\t\t\t<option value='contents'><font size='2'>\r\n");
      out.write("                                                        글내용</font></option>\r\n");
      out.write("\t\t\t\t<option value='name'><font size='2'>\r\n");
      out.write("                                                        작성자</font></option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t<TD align='left'>\r\n");
      out.write("\t\t\t\t\t<input type='text' name='keyword' \r\n");
      out.write("                                                   value='' size='20' maxlength='30'>\r\n");
      out.write("\t\t\t\t\t<input type='submit' value='검색'>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t  </TR>\r\n");
      out.write("\t\t\t  </FORM>\r\n");
      out.write("\t\t\t  </TABLE> \r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\r\n");
      out.write("\t\t<TD align='right'>\t\t\r\n");
      out.write("\t\t<a href='write.jsp'>[등록]</a>\t\t\t\t\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("</TABLE>  \r\n");
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
