package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

public class VisiteDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Visite> result = VisiteDao.retournerCollectionLesVisites();
		for(Visite uneVisite :result) {
			System.out.println(uneVisite.getUnMedecin().getCodeMed());
		}
			
	}

	
}
