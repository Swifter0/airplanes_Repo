package hm.sb_airplanes_mvc_Homework1.controller;

import org.springframework.stereotype.Controller;

import hm.sb_airplanes_mvc_Homework1.service.AppService;

@Controller
public class AppController {

	private AppService service;

	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	
}
