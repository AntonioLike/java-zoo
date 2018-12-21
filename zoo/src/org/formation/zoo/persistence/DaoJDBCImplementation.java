package org.formation.zoo.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;

public class DaoJDBCImplementation extends DaoJDBC<CagePOJO> {

	public DaoJDBCImplementation() {
		super();
	}
	
	@Override
	public void create(CagePOJO obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public CagePOJO read(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<CagePOJO> readAll() {
		List<CagePOJO> ret = new Vector<>();
		Statement statement = null;
		try {
			statement = getConnection().createStatement();

			ResultSet result = null;
			result = statement.executeQuery("Select * from animal A left join gazelle G on A.idAnimal = G.idAnimal;");
			while(result.next()) {
				if(result.getString("codeAnimal")!="null")
					ret.add(new CagePOJO(result.getInt("x"),result.getInt("y"), result.getInt("age"), result.getInt("idAnimal"), result.getString("codeAnimal"), result.getString("name"), result.getDouble("weight"), new GazellePOJO(result.getInt("id"),result.getInt("idAnimal"),result.getInt("hornsLength"))));
				else
					ret.add(new CagePOJO(result.getInt("x"),result.getInt("y")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void update(int key, CagePOJO obj) {
		try {
			Statement statement = getConnection().createStatement();
			statement.execute(String.join("","Update Animal set age =",Integer.toString(obj.getAge()),",codeAnimal =",obj.getCodeAnimal()==null?"null":String.join("", "\'",obj.getCodeAnimal(),"\'"),",name=\'",obj.getName(),"\',weight =",Double.toString(obj.getWeight())," where idAnimal =", Integer.toString(key),";"));
			if(obj.getGaz()==null && statement.executeQuery(String.join("","Select * from Gazelle where idAnimal =",Integer.toString(key),";"))!=null);
				statement.execute(String.join("", "Delete from Gazelle where idAnimal =",Integer.toString(key)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int key) {
		// TODO Auto-generated method stub	
	}
}
