package com.jasmine.xiao.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import com.jasmine.xiao.Dao.Dao;
import com.jasmine.xiao.model.MyFile;

public class ServiceImpl implements Service{
	private static final String UPLOAD_FOLDER = "/User/jasmine";

	private Dao dao;
	
	public Dao getDao() {
		return dao;
	}
	
	@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public MyFile upLoad(String filename) {
		MyFile file=null;
        try {
            file = load(filename);
            if(file.exist()) {
            	
            }else {
                throw new FileUnreadble("Can't read file");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }finally{	
        	return file;
        }
	}

	@Override
	public boolean store(MyFile file) {
		return this.dao.save(file);
	}
	
	public MyFile load(String name) throws IOException{
		MyFile file=new MyFile();
		int read = 0;
		byte[] bytes = new byte[1024];
		FileInputStream in =new FileInputStream(new File(name));
		file.setName(name);
		
		while ((read = in.read(bytes)) != -1) {
			file.getContents().add(name);
		}
		in.close();
		return file;
	}
}
