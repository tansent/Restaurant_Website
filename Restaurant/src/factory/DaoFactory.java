package factory;

import java.io.FileReader;
import java.util.Properties;

import dao.Orderdao;
import dao.Userdao;

public class DaoFactory {
	private static DaoFactory factory = new DaoFactory();
	private DaoFactory() {
	}
	
	private static Properties prop = null;
	static{
		try {
			prop = new Properties();
			prop.load(new FileReader(DaoFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static DaoFactory getFactory(){		
		return factory;
	}
	
	public Userdao getUserDao(){
		try {
		String clazz = prop.getProperty("userdao");		
		Class c =Class.forName(clazz);
		return (Userdao) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Orderdao getOrderDao(){
		try {
		String clazz = prop.getProperty("orderdao");		
		Class c =Class.forName(clazz);
		return (Orderdao) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
