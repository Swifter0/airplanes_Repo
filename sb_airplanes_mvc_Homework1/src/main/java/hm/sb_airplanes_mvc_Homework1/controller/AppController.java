package hm.sb_airplanes_mvc_Homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hm.sb_airplanes_mvc_Homework1.dto.AirplaneDtoList;
import hm.sb_airplanes_mvc_Homework1.service.AppService;

@Controller
public class AppController {

	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/allflights")
	public String getAllFlights(Model model) {
		
		AirplaneDtoList dtoList = service.getAllFlights();
	
		model.addAttribute("flights", dtoList);
		return "flights.html";
	}
	
	
}
