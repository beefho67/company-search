package com.proxifile.search.searchapp.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//	For local development, comment the below before deployment
//	@RequestMapping(value = "")
	public String index() {
		return "index";
	}
}
