package kr.co.example.test01.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.example.test01.service.Test01Service;

@Controller
public class Test01Controller {

	@Autowired
	Test01Service test01Service;
	
	@RequestMapping(value = "/test01")
	public String home(Model model)
	{
		Map<String, Object> testmap = test01Service.selectTest01();
		model.addAttribute("message", testmap);
		return "/test01/test01";
	}
	
}
