package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bean.Article;

public class ArticleDao {

    private ConnectionMaker connectionMaker;
    private Connection c = null;
    private PreparedStatement ps = null;
    private PreparedStatement pstmt1 = null, pstmt2 = null;
    private ResultSet rs = null;
    private List list = null;
    private String strSQL = null;

    public ArticleDao(ConnectionMaker simpleConnectionMaker) {
        this.connectionMaker = simpleConnectionMaker;
    }

    public ArticleDao() {
    }

    public List getDBAll(int startRow, int endRow) throws ClassNotFoundException, SQLException {
        list = new ArrayList();
        c = this.connectionMaker.makeConnection();
        strSQL = "SELECT * FROM tblboard  WHERE num BETWEEN ? and ?" + "ORDER BY num DESC";
        ps = c.prepareStatement(strSQL);
        ps.setInt(1, startRow);
        ps.setInt(2, endRow);
        rs = ps.executeQuery();
        while (rs.next()) {
            Article model = new Article();
            model.setNum(rs.getInt("num"));
            model.setName(rs.getString("name"));
            model.setPass(rs.getString("pass"));
            model.setEmail(rs.getString("email"));
            model.setTitle(rs.getString("title"));
            model.setContents(rs.getString("contents"));
            model.setWritedate(rs.getString("writedate"));
            model.setReadcount(rs.getInt("readcount"));
            list.add(model);
        }
        rs.close();
        ps.close();
        c.close();
        return list;

    }

    public List getKeyDBAll(String key, String keyword) throws ClassNotFoundException, SQLException {
        strSQL = "SELECT * FROM tblboard WHERE " + key + " like ? ORDER BY num DESC";
        list = new ArrayList();
        c = this.connectionMaker.makeConnection();
        ps = c.prepareStatement(strSQL);
        ps.setString(1, "%" + keyword + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            Article model = new Article();
            model.setNum(rs.getInt("num"));
            model.setName(rs.getString("name"));
            model.setPass(rs.getString("pass"));
            model.setEmail(rs.getString("email"));
            model.setTitle(rs.getString("title"));
            model.setContents(rs.getString("contents"));
            model.setWritedate(rs.getString("writedate"));
            model.setReadcount(rs.getInt("readcount"));
            list.add(model);
        }
        rs.close();
        ps.close();
        c.close();
        return list;

    }

    public List getSelectDBAll(int startRow, int endRow, String key, String keyword) throws ClassNotFoundException, SQLException {
        list = new ArrayList();
        c = this.connectionMaker.makeConnection();
        if (key == null || keyword == null) {
            strSQL = "SELECT * FROM tblboard  WHERE num BETWEEN ? and ?" + "ORDER BY num DESC";
            ps = c.prepareStatement(strSQL);
            ps.setInt(1, startRow);
            ps.setInt(2, endRow);
        } else {
            strSQL = "SELECT * FROM tblboard WHERE " + key + " like ? ORDER BY num DESC";
            ps = c.prepareStatement(strSQL);
            ps.setString(1, "%" + keyword + "%");
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            Article model = new Article();
            model.setNum(rs.getInt("num"));
            model.setName(rs.getString("name"));
            model.setPass(rs.getString("pass"));
            model.setEmail(rs.getString("email"));
            model.setTitle(rs.getString("title"));
            model.setContents(rs.getString("contents"));
            model.setWritedate(rs.getString("writedate"));
            model.setReadcount(rs.getInt("readcount"));
            list.add(model);
        }
        rs.close();
        ps.close();
        c.close();
        return list;

    }

    public int getLastRow() throws ClassNotFoundException, SQLException {
        int num = 0;
        strSQL = "SELECT * FROM tblboard";
        c = this.connectionMaker.makeConnection();
        ps = c.prepareStatement(strSQL);
        rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt("num");
        }

        rs.close();
        ps.close();
        c.close();

        return num;
    }

    public int keyLastRow(String key, String keyword) throws ClassNotFoundException, SQLException {
        int num = 0;
        strSQL = null;
        strSQL = "SELECT count(*) FROM tblboard WHERE " + key + " like ?";
        c = this.connectionMaker.makeConnection();
        ps = c.prepareStatement(strSQL);
        ps.setString(1, "%" + keyword + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt(1);
        }

        rs.close();
        ps.close();
        c.close();

        return num;
    }

    public int getSelectLastRow(String key, String keyword) throws ClassNotFoundException, SQLException {
        int num = 0;
        strSQL = null;
        c = this.connectionMaker.makeConnection();
        if (key == null || keyword == null) {
            strSQL = "SELECT count(*) FROM tblboard";
            ps = c.prepareStatement(strSQL);
        } else {
            strSQL = "SELECT count(*) FROM tblboard WHERE " + key + " like ?";
            ps = c.prepareStatement(strSQL);
            ps.setString(1, "%" + keyword + "%");
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt(1);
        }

        rs.close();
        ps.close();
        c.close();

        return num;
    }

    public void write(Article model) throws ClassNotFoundException, SQLException {

        Calendar dateIn = Calendar.getInstance();
        String indate = Integer.toString(dateIn.get(Calendar.YEAR)) + "-";
        indate = indate + Integer.toString(dateIn.get(Calendar.MONTH) + 1) + "-";
        indate = indate + Integer.toString(dateIn.get(Calendar.DATE)) + " ";
        indate = indate + Integer.toString(dateIn.get(Calendar.HOUR_OF_DAY)) + ":";
        indate = indate + Integer.toString(dateIn.get(Calendar.MINUTE)) + ":";
        indate = indate + Integer.toString(dateIn.get(Calendar.SECOND));

        c = this.connectionMaker.makeConnection();

        String MaxstrSQL = "SELECT Max(num) FROM tblboard";
        ps = c.prepareStatement(MaxstrSQL);
        rs = ps.executeQuery();
        int num = 1;

        if (rs.next()) {
            num = rs.getInt(1) + 1;
        }

        strSQL = "INSERT INTO tblboard(num, name, pass, email, title, contents, writedate, readcount)";
        strSQL = strSQL + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        ps = c.prepareStatement(strSQL);
        ps.setInt(1, num);
        ps.setString(2, model.getName());
        ps.setString(3, model.getPass());
        ps.setString(4, model.getEmail());
        ps.setString(5, model.getTitle());
        ps.setString(6, model.getContents());
        ps.setString(7, indate);
        ps.setInt(8, 0);

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public void reply(Article model) throws ClassNotFoundException, SQLException {

        Calendar dateIn = Calendar.getInstance();
        String indate = Integer.toString(dateIn.get(Calendar.YEAR)) + "-";
        indate = indate + Integer.toString(dateIn.get(Calendar.MONTH) + 1) + "-";
        indate = indate + Integer.toString(dateIn.get(Calendar.DATE)) + " ";
        indate = indate + Integer.toString(dateIn.get(Calendar.HOUR_OF_DAY)) + ":";
        indate = indate + Integer.toString(dateIn.get(Calendar.MINUTE)) + ":";
        indate = indate + Integer.toString(dateIn.get(Calendar.SECOND));

        c = this.connectionMaker.makeConnection();

        strSQL = "UPDATE tblboard SET num = num + 1 WHERE num = " + model.getNum() + " OR num > " + model.getNum();
        System.out.print(model.getNum());
        pstmt1 = c.prepareStatement(strSQL);
        pstmt1.executeUpdate();

        strSQL = "INSERT INTO tblboard(num, name, pass, email, title, contents, writedate, readcount)";
        strSQL = strSQL + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        pstmt2 = c.prepareStatement(strSQL);
        pstmt2.setInt(1, model.getNum());
        pstmt2.setString(2, model.getName());
        pstmt2.setString(3, model.getPass());
        pstmt2.setString(4, model.getEmail());
        pstmt2.setString(5, model.getTitle());
        pstmt2.setString(6, model.getContents());
        pstmt2.setString(7, indate);
        pstmt2.setInt(8, 0);
        pstmt2.executeUpdate();
        
        pstmt1.close();
        pstmt2.close();
        c.close();
    }
   

    public void update(Article model) throws ClassNotFoundException, SQLException {
        strSQL = "UPDATE tblboard SET name=?, pass=?, email=?, title=?, contents=?, writedate=? WHERE num=?";
        Calendar dateIn = Calendar.getInstance();
        String indate = Integer.toString(dateIn.get(Calendar.YEAR)) + "-";
        indate = indate + Integer.toString(dateIn.get(Calendar.MONTH) + 1) + "-";
        indate = indate + Integer.toString(dateIn.get(Calendar.DATE)) + " ";
        indate = indate + Integer.toString(dateIn.get(Calendar.HOUR_OF_DAY)) + ":";
        indate = indate + Integer.toString(dateIn.get(Calendar.MINUTE)) + ":";
        indate = indate + Integer.toString(dateIn.get(Calendar.SECOND));

        c = this.connectionMaker.makeConnection();
        ps = c.prepareStatement(strSQL);
        ps.setString(1, model.getName());
        ps.setString(2, model.getPass());
        ps.setString(3, model.getEmail());
        ps.setString(4, model.getTitle());
        ps.setString(5, model.getContents());
        ps.setString(6, indate);
        ps.setInt(7, model.getNum());
        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public Article getModel(String num) throws ClassNotFoundException, SQLException {
        strSQL = "SELECT * FROM tblboard WHERE num = ?";
        c = this.connectionMaker.makeConnection();
        ps = c.prepareStatement(strSQL);
        ps.setInt(1, Integer.parseInt(num));
        rs = ps.executeQuery();
        rs.next();
        Article model = new Article();
        model.setNum(rs.getInt("num"));
        model.setName(rs.getString("name"));
        model.setPass(rs.getString("pass"));
        model.setEmail(rs.getString("email"));
        model.setTitle(rs.getString("title"));
        model.setContents(rs.getString("contents"));
        model.setWritedate(rs.getString("writedate"));
        model.setReadcount(rs.getInt("readcount"));

        rs.close();
        ps.close();
        c.close();
        return model;
    }

    public void update_readcount(String num) throws ClassNotFoundException, SQLException {
        strSQL = "UPDATE tblboard SET readcount=readcount+1 WHERE num = ?";
        c = this.connectionMaker.makeConnection();
        ps = c.prepareStatement(strSQL);
        ps.setInt(1, Integer.parseInt(num));
        ps.executeUpdate();

        rs.close();
        ps.close();
        c.close();
    }

    public String getPass(String num) throws ClassNotFoundException, SQLException {
        strSQL = "SELECT pass FROM tblboard WHERE num = ?";
        String password = null;

        c = this.connectionMaker.makeConnection();
        ps = c.prepareStatement(strSQL);
        ps.setInt(1, Integer.parseInt(num));
        rs = ps.executeQuery();
        rs.next();

        password = rs.getString("pass").trim();
        System.out.println(password);
        rs.close();
        ps.close();
        c.close();
        return password;
    }

    public void delete(String num) throws ClassNotFoundException, SQLException {
        c = this.connectionMaker.makeConnection();
        strSQL = "DELETE From tblboard WHERE num=?";
        ps = c.prepareStatement(strSQL);
        ps.setInt(1, Integer.parseInt(num));
        ps.executeUpdate();

        strSQL = "UPDATE tblboard SET num = num - 1 WHERE num > ?";
        ps = c.prepareStatement(strSQL);
        ps.setInt(1, Integer.parseInt(num));
        ps.executeUpdate();

        ps.close();
        c.close();
    }
}
