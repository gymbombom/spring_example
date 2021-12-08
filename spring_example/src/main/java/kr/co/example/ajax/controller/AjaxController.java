package kr.co.example.ajax.controller;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.example.ajax.dao.AjaxVO;
import kr.co.example.test01.service.Test01Service;

@Controller
public class AjaxController {

	@Autowired
	Test01Service test01Service;
	
	@RequestMapping(value="/ajax01", method={RequestMethod.GET, RequestMethod.POST})
	public String ajax01 (Model model)
	{
		return "/ajax/ajax01";
	}
	
	
	@RequestMapping(value="/ajax01Submit", method={RequestMethod.POST})
	public ResponseEntity<String> ajax01Submit( @ModelAttribute("ajaxVO") AjaxVO ajaxVO , ModelMap model) throws Exception {
		ModelMap modelMap = new ModelMap();
		
		//multipart-form-data 로 전송 시 한글이 깨질경우 아래와 같이 변환
		//String korName = ajaxVO.getKorName();
		//korName = new String(korName.getBytes("8859_1"), "utf-8");


		
		modelMap.put("korName", ajaxVO.getKorName());
		modelMap.put("engName", ajaxVO.getEngName());
		modelMap.put("age", ajaxVO.getAge());
		modelMap.put("height", ajaxVO.getHeight());
		modelMap.put("weight", ajaxVO.getWeight());
		
		
		modelMap.put("success", true);
		//modelMap.put("success", false);
		
		StringWriter sw = new StringWriter(); 
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(sw, modelMap); 
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type","text/html; charset=UTF-8");
		
		return new ResponseEntity<String>(sw.toString(), responseHeaders, HttpStatus.CREATED);
	}
	
//=========================================================================================================================================
	
	@RequestMapping(value="/ajax02", method={RequestMethod.GET,RequestMethod.POST})
	public String ajax02 (Model model)
	{
		return "/ajax/ajax02";
	}
	
	
	@RequestMapping(value="/ajax02Submit", method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> ajax02Submit( @RequestParam Map<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("success", true);
		//resultMap.put("success", false);
		
		resultMap.put("korName", map.get("korName"));
		resultMap.put("engName", map.get("engName"));
		resultMap.put("age", map.get("age"));
		resultMap.put("height", map.get("height"));
		resultMap.put("weight", map.get("weight"));
		
		return resultMap;
	}
	
//=========================================================================================================================================
	
	@RequestMapping(value="/ajax03", method={RequestMethod.GET,RequestMethod.POST})
	public String ajax03 (Model model)
	{
		return "/ajax/ajax03";
	}
	
	@RequestMapping(value="/ajax03Submit", method={RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> ajax03Submit( @ModelAttribute AjaxVO ajaxVO) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("success", true);
		//resultMap.put("success", false);
		
		resultMap.put("korName", ajaxVO.getKorName());
		resultMap.put("engName", ajaxVO.getEngName());
		resultMap.put("age", ajaxVO.getAge());
		resultMap.put("height", ajaxVO.getHeight());
		resultMap.put("weight", ajaxVO.getWeight());
		
		return resultMap;
	}
		
//=========================================================================================================================================
	@RequestMapping(value = "/ajax04", method={RequestMethod.GET,RequestMethod.POST})
	public String ajax04 (Model model)
	{
		return "/ajax/ajax04";
	}
	
	@RequestMapping(value="/ajax04Submit", method={RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> ajax04Submit( @RequestParam Map<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("success", true);
		//resultMap.put("success", false);
		
		resultMap.put("korName", map.get("korName"));
		resultMap.put("engName", map.get("engName"));
		resultMap.put("age", map.get("age"));
		resultMap.put("height", map.get("height"));
		resultMap.put("weight", map.get("weight"));
		
		return resultMap;
	}
	
//=========================================================================================================================================
	
	@RequestMapping(value="/ajax05", method={RequestMethod.GET,RequestMethod.POST})
	public String ajax05 (Model model)
	{
		return "/ajax/ajax05";
	}
	
	@RequestMapping(value="/ajax05Submit", method={RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> ajax05Submit( @RequestBody Map<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("success", true);
		//resultMap.put("success", false);
		
		resultMap.put("korName", map.get("korName"));
		resultMap.put("engName", map.get("engName"));
		resultMap.put("age", map.get("age"));
		resultMap.put("height", map.get("height"));
		resultMap.put("weight", map.get("weight"));
		
		return resultMap;
	}

//=========================================================================================================================================
	@RequestMapping(value="/ajax06", method={RequestMethod.GET,RequestMethod.POST})
	public String ajax06 (Model model)
	{
		return "/ajax/ajax06";
	}
	
	@RequestMapping(value="/ajax06Submit", method={RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> ajax06Submit( @RequestBody  List<Map<String, Object>> list) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("success", true);
		//resultMap.put("success", false);
				
		for(int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			if(i == 1) {
				map = list.get(i);
				resultMap.put("korName", map.get("korName"));
				resultMap.put("engName", map.get("engName"));
				resultMap.put("age", map.get("age"));
				resultMap.put("height", map.get("height"));
				resultMap.put("weight", map.get("weight"));
			}
		}
		return resultMap;
	}

//=========================================================================================================================================

	@RequestMapping(value="/ajax07", method={RequestMethod.GET,RequestMethod.POST})
	public String ajax07 (Model model)
	{
		return "/ajax/ajax07";
	}
	
	@RequestMapping(value="/ajax07Submit", method={RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> ajax07Submit( @RequestBody  Map<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Map<String, Object> subForm2Map = (Map<String, Object>)map.get("subForm2");
		
		resultMap.put("success", true);
		//resultMap.put("success", false);
		resultMap.put("subForm2Map", subForm2Map);
				
		return resultMap;
	}	

	//=========================================================================================================================================

		@RequestMapping(value="/ajax08", method={RequestMethod.GET,RequestMethod.POST})
		public String ajax08 (Model model)
		{
			return "/ajax/ajax08";
		}
		
		@RequestMapping(value="/ajax08Submit", method={RequestMethod.POST})
		@ResponseBody
		public HashMap<String, Object> ajax08Submit( @RequestBody AjaxVO ajaxVO) throws Exception {
			HashMap<String, Object> resultMap = new HashMap<String, Object>();
			
			System.out.println(ajaxVO.getKorName());
			System.out.println(ajaxVO.getSubAjaxVO().getKorName());
			
			resultMap.put("success", true);
			//resultMap.put("success", false);
			
			resultMap.put("subAjaxVO", ajaxVO.getSubAjaxVO());
					
			return resultMap;
		}	
}
