package be.vdab.FrituurFrida4.valueobjects;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Snack {
private int id;
@NotBlank
private String naam;
@NotNull @Min(0)
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
