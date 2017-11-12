package com.jasmine.xiao.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jasmine.xiao.model.MyFile;

@Repository
public class DaoImpl implements Dao{
	private EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}
	
	@Autowired
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public boolean save(MyFile file){
		return manager.save(file);
	}

}
