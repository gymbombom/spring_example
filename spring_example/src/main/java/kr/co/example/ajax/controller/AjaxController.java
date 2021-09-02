package kr.co.example.ajax.controller;
import java.io.StringWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.example.ajax.dao.AjaxVO;
import kr.co.example.test01.service.Test01Service;

@Controller
public class AjaxController {

	@Autowired
	Test01Service test01Service;
	
	@RequestMapping(value = "/ajax01")
	public String ajax01 (Model model)
	{
		return "/ajax/ajax01";
	}
	
	
	@RequestMapping("/ajax01Submit")
	public ResponseEntity<String> ajax01Submit( @ModelAttribute("ajaxVO") AjaxVO ajaxVO , ModelMap model) throws Exception {
		ModelMap modelMap = new ModelMap();
				
		modelMap.put("key", ajaxVO.getKey());
		modelMap.put("value", ajaxVO.getValue());
		
		
		modelMap.put("success", true);
		//modelMap.put("success", false);
		
		StringWriter sw = new StringWriter(); 
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(sw, modelMap); 
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type","text/html; charset=UTF-8");
		
		return new ResponseEntity<String>(sw.toString(), responseHeaders, HttpStatus.CREATED);
	}
		
}