package be.vdab.FrituurFrida4.web;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import be.vdab.FrituurFrida4.valueobjects.Deur;

@Component
@SessionScope
public class DefaultZoekDeFrietSpel implements ZoekDeFrietSpel {

	private static final long serialVersionUID = 1L;
	private static final int AANTAL_DEUREN = 7;
	private final Deur[] deuren = new Deur[AANTAL_DEUREN];

	@Override
	public void openDeur(int index) {
		deuren[index].open();

	}

	@Override
	public Deur[] getDeuren() {
		return deuren;
	}

	@Override
	public void resetDeuren() {
	    int indexMetFriet = ThreadLocalRandom.current().nextInt(AANTAL_DEUREN);  
	    for (int index = 0; index != AANTAL_DEUREN; index++) {     
	    	deuren[index] = new Deur(index == indexMetFriet);     }  
	    }

	}


