package be.vdab.FrituurFrida4.valueobjects;

import java.math.BigDecimal;

public class Snack {
private int id;
private String naam;
private BigDecimal prijs;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNaam() {
	return naam;
}
public void setNaam(String naam) {
	this.naam = naam;
}
public BigDecimal getPrijs() {
	return prijs;
}
public void setPrijs(BigDecimal prijs) {
	this.prijs = prijs;
}
public Snack(int id, String naam, BigDecimal prijs) {
	this.id = id;
	this.naam = naam;
	this.prijs = prijs;
}
Snack() {
}

}
