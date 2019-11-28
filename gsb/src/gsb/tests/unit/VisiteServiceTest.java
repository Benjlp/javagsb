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
		assertNull(uneVisiteService.rechercherVisite(null), "Null car ref null");
	}
	@Test
	public final void testrechercherVisiteRef() {
		assertNotNull(uneVisiteService.rechercherVisite("V001"), "Visite avec une ref présente");
	}

	
	@Test
	public final void testAjouterVisiteRefNull() {
		assertNull(uneVisiteService.AjouterVisite("null", "2002-01-20 00:00:00","", "m001","a131"), "ref null");
 	}
	@Test
	public final void testAjouterVisiteDateNull() {
		assertNull(uneVisiteService.AjouterVisite("test", null, "", "m001","a131"), "ref null");
 	}
	@Test
	public final void testAjouterVisiteMedecinNull() {
		assertNull(uneVisiteService.AjouterVisite("test", "2002-01-20 00:00:00", "", null, "a131"), "ref null");
 	}
	@Test
	public final void testAjouterVisiteVisiteurNull() {
		assertNull(uneVisiteService.AjouterVisite("test", "2002-01-20 00:00:00", "","m001", null), "ref null");
 	}
	@Test
	public final void testAjouterVisite() {
		assertEquals(1, uneVisiteService.AjouterVisite("test", "2002-01-20 00:00:00", "","m001","a131"));
 	}
	@Test
	public final void testAjouterVisiteEchec() {
		assertEquals(0, uneVisiteService.AjouterVisite("test", "2002-01-20 00:00:00", "","m001","a131" ));

 	}
	
	
	
	
	public final void testsupprimerVisiteNull() {
		assertNull(uneVisiteService.supprimerVisite(null));
	}
	
	public final void testsupprimerVisite() {
		assertEquals(1, uneVisiteService.supprimerVisite("test"));
	}
	
	// cherche un bail qui existe pas

}
