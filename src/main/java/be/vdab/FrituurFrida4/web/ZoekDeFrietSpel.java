package be.vdab.FrituurFrida4.web;

import be.vdab.FrituurFrida4.valueobjects.Deur;

public interface ZoekDeFrietSpel {
	public void openDeur(int index);
	Deur[] getDeuren();
	void resetDeuren();
}
