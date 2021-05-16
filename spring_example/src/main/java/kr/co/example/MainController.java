package kr.co.example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/")
	public String home()
	{
		return "/showMessage2";
	}
	
}
