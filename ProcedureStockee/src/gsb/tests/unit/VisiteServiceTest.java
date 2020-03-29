/**
 * 
 */
package gsb.tests.unit;


import static org.junit.jupiter.api.Assertions.*;

import javax.naming.ldap.UnsolicitedNotificationListener;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gsb.modele.*;
import gsb.service.VisiteService;

/**
 * @author Benj
 *
 */
class VisiteServiceTest {
	
	private VisiteService uneVisiteService;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		uneVisiteService = new VisiteService();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	
	public void tearDown() throws Exception {

		if (VisiteService.rechercherVisite("test")!=null) uneVisiteService.supprimerVisite("test");
	}


	@Test
	public final void testrechercherVisiteRefNull() {
		assertNull(uneVisiteService.rechercherVisite(null), "recherche Null car ref null");
	}
	@Test	
	public final void testrechercherVisiteRef() {
		assertNull(uneVisiteService.rechercherVisite("V001"), "Visite avec une ref présente");
	}

	
	@Test
	public final void testAjouterVisiteRefNull() {
		assertEquals(0,uneVisiteService.AjouterVisite(null, "2002-01-20 00:00:00","","a131", "m001"), "ref null");
 	}
	@Test
	public final void testAjouterVisiteDateNull() {
		assertEquals(0,uneVisiteService.AjouterVisite("test", null, "", "a131", "m001"), "ref null");
 	}
	@Test
	public final void testAjouterVisiteMedecinNull() {
		assertEquals(0,uneVisiteService.AjouterVisite("test", "2002-01-20 00:00:00", "","a131", null), "ref null");
 	}
	@Test
	public final void testAjouterVisiteVisiteurNull() {
		assertEquals(0,uneVisiteService.AjouterVisite("test", "2002-01-20 00:00:00", "",null, "m001"), "ref null");
		}

	@Test
	public final void testAjouterVisite() {
		assertEquals(1,uneVisiteService.AjouterVisite("test", "2002-01-20 00:00:00", "","m001","a131" ));

 	}
	
	@Test
	public final void testsupprimerVisiteNull() {
		assertEquals(0,uneVisiteService.supprimerVisite(null));
	}
	
	@Test
	public final void testsupprimerVisite() {
		assertEquals(1, uneVisiteService.supprimerVisite("test"));
	}
	

}
