package dao;

public class ModelDaoFactory {
	public  ModelDaoFactory() {
	}
	public ModelDao modelDao() {
		ModelDao dao = new ModelDao(connectionMaker());
		return dao;
	}

	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
