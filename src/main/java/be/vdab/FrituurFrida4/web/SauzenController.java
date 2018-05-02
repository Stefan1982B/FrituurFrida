package be.vdab.FrituurFrida4.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.FrituurFrida4.valueobjects.Saus;

@Controller
@RequestMapping("sauzen")
class SauzenController {

	private static final String SAUZEN_VIEW = "sauzen";
	private final List<Saus> sauzen = new ArrayList<>();
	
	SauzenController(){
		sauzen.add(new Saus(1L, "mayonaise", Arrays.asList("olie", "citroen", "eieren")));
		sauzen.add(new Saus(2L, "cocktail",Arrays.asList("tomaten", "olie", "suiker", "mayonaise")));
		sauzen.add(new Saus(3L, "tartare", Arrays.asList ("mayonaise", "kruidenboter")));
		sauzen.add(new Saus(4L, "mosterd", Arrays.asList ("mosterdzaad", "olie", "zout")));
		sauzen.add(new Saus(4L, "vinaigrette", Arrays.asList("azijn", "olie", "zout", "peper")));
		}
	
	
	
	@GetMapping
	ModelAndView sauzen() {
		return new ModelAndView(SAUZEN_VIEW, "sauzen", sauzen);
		
	}
	
}
