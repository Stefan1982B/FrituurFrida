package be.vdab.FrituurFrida4.web;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.FrituurFrida4.valueobjects.Adres;
import be.vdab.FrituurFrida4.valueobjects.Gemeente;

@Controller
@RequestMapping("/")
class IndexController {

	@GetMapping
	ModelAndView index() {
		String boodschap;
		DayOfWeek weekDag = LocalDate.now().getDayOfWeek();

		if (weekDag.equals(DayOfWeek.TUESDAY) || weekDag.equals(DayOfWeek.THURSDAY)) {
			boodschap = "gesloten";
		} else {
			boodschap = "open";
		}
		ModelAndView modelAndView = new ModelAndView("index", "boodschap", boodschap);
		modelAndView.addObject(new Adres("stationplein", "5", new Gemeente("Roeselare", 8000)));
		return modelAndView;
	}

}
