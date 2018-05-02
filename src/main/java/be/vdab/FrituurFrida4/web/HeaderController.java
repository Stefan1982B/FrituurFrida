package be.vdab.FrituurFrida4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("headers")
public class HeaderController {
	private final static String VIEW = "headers";

	@GetMapping
	ModelAndView intNederlands(@RequestHeader("accept-language") String acceptLanguage) {
		return new ModelAndView(VIEW, "intNederlands", acceptLanguage.toLowerCase().startsWith("nl"));
	}
}
