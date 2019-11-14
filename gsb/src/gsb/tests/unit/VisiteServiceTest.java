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
		private uneVisiteService = new VisiteService();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {

		if (VisiteService.rechercherVisite("test")!=null) uneVisiteService.supprimerVisite("test");
	}

	@Test
	public final void testrechercherVisite() {
		assertEquals("Valeur null", uneVisiteService.rechercherVisite("test"));
	}

	public final void testrechercherVisitenull() {
		assertNotNull(uneVisiteService.rechercherVisite("V001"));
	}
	// null visite 
	// cherche un bail qui existe pas

}
