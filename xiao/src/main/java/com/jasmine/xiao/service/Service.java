package com.jasmine.xiao.service;

import com.jasmine.xiao.model.MyFile;

public interface Service {
	public MyFile upLoad(String filename);
    public boolean store(MyFile file);
}
