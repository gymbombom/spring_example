package kr.co.example.excel.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ExcelController {

	// JSP Excel 다운로드 view
	@RequestMapping(value="/excel01")
	public String excel01(ModelMap model)throws RuntimeException{
		return "excel/excel01";
	}
	
	// JSP 엑셀 다운로드 Controller
	@RequestMapping(value="/excel01_download.do")
	public String excel01_download( ModelMap model)throws RuntimeException{		
		return "excel/excel01_download";
	}

}
