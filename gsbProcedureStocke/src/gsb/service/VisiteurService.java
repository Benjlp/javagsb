package gsb.service;


import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class VisiteurService {
// m�thode pour rechercher un visiteur en fonction d'un matricule
	
	public static Visiteur rechercherVisiteur(String Matricule) {
		Visiteur UnVisiteur = null;
		
		try {
			if (Matricule == null) {
				throw new Exception("Donn�e obligatoire : Matricule");
			}
			UnVisiteur = VisiteurDao.rechercher(Matricule);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return UnVisiteur;
	}
	
	
}
