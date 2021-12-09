package kr.co.example.popup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PopupController {

	@RequestMapping(value="/popup01", method={RequestMethod.GET, RequestMethod.POST})
	public String popup01 (Model model)
	{
		return "/popup/popup01";
	}
	
	@RequestMapping(value="/popup01Call", method={RequestMethod.GET, RequestMethod.POST})
	public String popup01Call (Model model)
	{
		return "/popup/popup01Call";
	}

//=========================================================================================================================================

	@RequestMapping(value="/popup02", method={RequestMethod.GET, RequestMethod.POST})
	public String popup02 (Model model)
	{
		return "/popup/popup02";
	}	
	
	@RequestMapping(value="/popup02Call", method={RequestMethod.GET, RequestMethod.POST})
	public String popup02Call (Model model)
	{
		return "/popup/popup02Call";
	}

//=========================================================================================================================================

	@RequestMapping(value="/popup03", method={RequestMethod.GET, RequestMethod.POST})
	public String popup03 (Model model)
	{
		return "/popup/popup03";
	}
	
	@RequestMapping(value="/popup03Call", method={RequestMethod.GET, RequestMethod.POST})
	public String popup03Call (Model model)
	{
		return "/popup/popup03Call";
	}
}
