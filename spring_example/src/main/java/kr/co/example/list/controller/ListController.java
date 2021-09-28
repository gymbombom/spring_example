package kr.co.example.list.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ListController {

	@RequestMapping(value="/list01", method={RequestMethod.GET, RequestMethod.POST})
	public String list01(Model model)
	{
		return "/list/list01";
	}	
}
