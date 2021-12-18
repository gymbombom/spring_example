package kr.co.example.test.controller;
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

import kr.co.example.test.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;
	
	@RequestMapping(value="/test01", method={RequestMethod.GET,RequestMethod.POST})
	public String test01(Model model)
	{
		Map<String, Object> testMap = testService.selectTest01();
		model.addAttribute("testMap", testMap);
		return "/test/test01";
	}
	
	@RequestMapping(value="/test02", method={RequestMethod.GET,RequestMethod.POST})
	public String test02(Model model)
	{
		return "/test/test02";
	}
	
	@RequestMapping(value="/test02Submit", method={RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> test02Submit( @RequestParam Map<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> cateList = testService.selectCateList();
		List<Map<String, Object>> eqList = testService.selectEqList();
		List<Map<String, Object>> compoList = testService.selectCompoList();
		
		resultMap.put("success", true);
		
		resultMap.put("cateList", cateList);
		resultMap.put("eqList", eqList);
		resultMap.put("compoList", compoList);
				
		return resultMap;
	}
	
	@RequestMapping(value="/test03", method={RequestMethod.GET,RequestMethod.POST})
	public String test03(Model model)
	{
		return "/test/test03";
	}
	
}
