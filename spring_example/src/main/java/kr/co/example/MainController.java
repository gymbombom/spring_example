package kr.co.example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value="/", method={RequestMethod.GET,RequestMethod.POST})
	public String home()
	{
		return "/showMessage2";
	}
	
}
