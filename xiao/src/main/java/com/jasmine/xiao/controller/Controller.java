package com.jasmine.xiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jasmine.xiao.model.MyFile;
import com.jasmine.xiao.service.Service;

@RestController
public class Controller {
	private Service service;
	
	@Autowired
	public void setService(Service service) {
		this.service = service;
	}

	@PostMapping("/upload")
	public String save(@RequestParam("file") String path,RedirectAttributes redirectAttributes){
		MyFile file=service.upLoad(path);
		this.service.store(file);
        redirectAttributes.addFlashAttribute("message",
                "Just uploaded " + file.getName() + " successfully");

        return "redirect:/uploadSuccess";
	}
}
