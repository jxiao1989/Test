package com.jasmine.xiao.model;

import java.util.List;

import javax.annotation.Generated;

@Entity
@Table(name="myfile")
public class MyFile {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name="name")
	String name;
	
	@ElementCollection
	List<String> contents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}
	
	public boolean exist(){
		return contents.size()>0;
	}
}
