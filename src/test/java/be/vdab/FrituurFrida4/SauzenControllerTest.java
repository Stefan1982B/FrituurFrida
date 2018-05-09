package be.vdab.FrituurFrida4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

import be.vdab.FrituurFrida4.services.SausService;
import be.vdab.FrituurFrida4.web.SauzenController;

@RunWith(MockitoJUnitRunner.class)
public class SauzenControllerTest {
	private SauzenController controller;

	@Mock
	private SausService sausService;

	@Before
	public void before() {
		controller = new SauzenController(sausService);
	}

	@Test
	public void sauzenWerktSamenMetSauzenDotJsp() {
		assertEquals("sauzen", controller.sauzen().getViewName());
	}

	@Test
	public void sauzenGeeftSauzenDoor() {
		assertTrue(controller.sauzen().getModel().containsKey("sauzen"));
	}

	@Test
	public void sauzenGeeftJuisteDataAanJSP() {
		assertTrue(controller.sauzen().getModel().containsKey("sauzen"));
		verify(sausService).findAll();
	}

}
