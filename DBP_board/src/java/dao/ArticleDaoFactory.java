package dao;

public class ArticleDaoFactory {
	public  ArticleDaoFactory() {
	}
	public ArticleDao modelDao() {
		ArticleDao dao = new ArticleDao(connectionMaker());
		return dao;
	}

	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
