package kr.co.example.test01.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.example.test01.service.Test02Service;

@Controller
public class Test02Controller {

	@Autowired
	Test02Service test02Service;
	
	@RequestMapping(value="/test02", method={RequestMethod.GET,RequestMethod.POST})
	public String home(Model model)
	{
		return "/test01/test02";
	}
	
	
	@RequestMapping(value="/test02Submit", method={RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> test02Submit( @RequestParam Map<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> cateList = test02Service.selectCateList();
		List<Map<String, Object>> eqList = test02Service.selectEqList();
		List<Map<String, Object>> compoList = test02Service.selectCompoList();
		
		resultMap.put("success", true);
		
		resultMap.put("cateList", cateList);
		resultMap.put("eqList", eqList);
		resultMap.put("compoList", compoList);
				
		return resultMap;
	}
	
}
