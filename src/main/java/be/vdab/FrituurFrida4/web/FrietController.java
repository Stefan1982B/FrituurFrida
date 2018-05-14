package be.vdab.FrituurFrida4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("frieten")
class FrietController {
	private ZoekDeFrietSpel zoekDeFrietSpel;

	FrietController(ZoekDeFrietSpel zoekDeFrietSpel) {
		this.zoekDeFrietSpel = zoekDeFrietSpel;
	}

	private static final String ZOEK_DE_FRIET_VIEW = "zoekdefriet";

	@GetMapping("zoekdefriet")
	ModelAndView zoekDeFriet() {
		return new ModelAndView(ZOEK_DE_FRIET_VIEW, "spel", zoekDeFrietSpel);
	}

	private static final String REDIRECT_NA_RESET_DEUREN = "redirect:/frieten/zoekdefriet";

	@PostMapping("zoekdefriet/nieuwspel")
	String nieuwSpel() {
		zoekDeFrietSpel.resetDeuren();
		return REDIRECT_NA_RESET_DEUREN;
	}

	private static final String REDIRECT_NA_OPEN_DEUR = "redirect:/frieten/zoekdefriet";

	@PostMapping(value = "zoekdefriet", params = "index")
	String openDeur(int index) {
		zoekDeFrietSpel.openDeur(index);
		return REDIRECT_NA_OPEN_DEUR;
	}

}
