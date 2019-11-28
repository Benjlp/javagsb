/**
 * 
 */
package gsb.tests.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.service.VisiteService;
import gsb.service.VisiteurService;

/**
 * @author Benj
 *
 */
class VisiteurServiceTest {
	
	private VisiteurService unVisiteurService ; 
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		unVisiteurService = new VisiteurService();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {

		}

	@Test
	public final void testrechercherVisiteurMatNull() {
		assertNull(unVisiteurService.rechercherVisiteur(null), "Null car ref null");
	}
	
	public final void testrechercherVisiteurMat() {
		assertNotNull(unVisiteurService.rechercherVisiteur("test"), "Visiteur avec un matricule présent");
	}
}
