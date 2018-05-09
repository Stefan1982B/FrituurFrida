package be.vdab.FrituurFrida4.web;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.FrituurFrida4.valueobjects.Adres;
import be.vdab.FrituurFrida4.valueobjects.Gemeente;

@Controller
@RequestMapping("/")
class IndexController {

	@GetMapping
	ModelAndView index(@CookieValue(name = "laatstBezocht", required = false) String laatstBezocht,
			HttpServletResponse response) {
		String boodschap;
		DayOfWeek weekDag = LocalDate.now().getDayOfWeek();
		Cookie cookie = new Cookie("laatstBezocht", LocalDateTime.now().toString());
		cookie.setMaxAge(36000000);
		response.addCookie(cookie);

		if (weekDag.equals(DayOfWeek.TUESDAY) || weekDag.equals(DayOfWeek.THURSDAY)) {
			boodschap = "gesloten";
		} else {
			boodschap = "open";
		}
		ModelAndView modelAndView = new ModelAndView("index", "boodschap", boodschap);
		modelAndView.addObject(new Adres("stationplein", "5", new Gemeente("Roeselare", 8000)));
		if(laatstBezocht != null) {
			modelAndView.addObject("laatstBezocht", laatstBezocht);
		}
		return modelAndView;
	}

}
