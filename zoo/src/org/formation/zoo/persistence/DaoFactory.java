package org.formation.zoo.persistence;

import org.formation.zoo.service.CagePOJO;

public final class DaoFactory {

	private static DaoFactory instance = new DaoFactory();
	
	private DaoFactory() {}
	
	public static DaoFactory getInstance() {
		return instance;
	}

	public Dao<CagePOJO> getDao(){
		return new HardCodedDao();
	}
	
}
