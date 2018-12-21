package org.formation.zoo.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.formation.zoo.service.CagePOJO;

@Deprecated
public final class DaoFactory {

	private static DaoFactory instance = new DaoFactory();
	
	private DaoFactory() {}
	
	public static DaoFactory getInstance() {
		return instance;
	}

	public Dao<CagePOJO> getDao(){
		Dao<CagePOJO> ret = null;
		Properties prop = new Properties();
		Class<?> theClass = null;
			try {
				prop.load(new FileInputStream("src/org/formation/zoo/persistence/dao.properties"));
				theClass = Class.forName(prop.getProperty("package")+prop.getProperty("dao"));
				
				ret = (Dao<CagePOJO>) theClass.getConstructor().newInstance();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		return ret;
	}	
}
