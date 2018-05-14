package be.vdab.FrituurFrida4.repositories;

import org.junit.Assert;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.FrituurFrida4.valueobjects.Snack;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcSnackRepository.class)
@Sql("/insertSnack.sql")

public class JdbcSnackRepositoryTest2 extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private JdbcSnackRepository repository;

	private long idVanTestSnack() {
		return super.jdbcTemplate.queryForObject(
				"select id from snacks where naam='test'", Long.class);
	}

	@Test
	public void read() {
		Assert.assertEquals("test", repository.read(idVanTestSnack()).get().getNaam());
	}

	@Test
	public void update() {
		int id = (int) idVanTestSnack();
		Snack snack = new Snack(id, "test", BigDecimal.ONE);
		repository.update(snack);
		Assert.assertEquals(0, BigDecimal.ONE.compareTo(
				super.jdbcTemplate.queryForObject("select prijs from snacks where id=?", BigDecimal.class, id)));
	}

	  @Test  
	  public void findByBeginNaam() { 
		  List<Snack> snacks = repository.findByBeginNaam("t"); 
		  String vorigeNaam = ""; 
		  for (Snack snack : snacks) {  
			  Assert.assertTrue(snack.getNaam().toLowerCase().startsWith("t"));  
			  Assert.assertTrue(vorigeNaam.compareTo(snack.getNaam()) <= 0);  
			  vorigeNaam = snack.getNaam();     }    
		  long aantalSnacks = super.jdbcTemplate.queryForObject(  
				  "select count(*) from snacks where naam like 't%'", Long.class);  
		  Assert.assertEquals(aantalSnacks, snacks.size());   }
	  }

