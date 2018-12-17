package org.formation.zoo.persistence;

import java.util.List;

public interface Dao <T>{
	
	public void create(T obj);
	public T read(int key);
	public List<T> readAll();
	public void update(int key, T obj);
	public void delete(int key);
	
}
