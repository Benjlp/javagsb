package gsb.service;

import gsb.modele.*;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class VisiteService {

	public static Visite rechercherVisite(String reference) {
		Visite UneVisite = null;
		
		try {
			if (reference == null) {
				throw new Exception("Donnée obligatoire : reference");
			}
			UneVisite = VisiteDao.rechercher(reference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return UneVisite;
	}


	// (String reference,String date,String commentaire,Medecin unMedecin,Visiteur
	// unVisiteur)7

	public static boolean AjouterVisite(String reference, String date, String commentaire, String unMedecin, String unVisiteur) {

		Medecin unMedecin2;
		Visiteur unVisiteur2;
		
		boolean resultat = false;

		try { 
			if (reference.equals("") || date.equals("") ||  unMedecin.equals("") || unVisiteur.equals("")) {
				throw new Exception("Données obligatoires : reference, date, unMedecin, unVisiteur");

			}

 			if (VisiteDao.rechercher(reference) != null) {
				
				throw new Exception("Un contact avec le code " + reference + " existe déjà");
			}
 			
 			if(MedecinDao.rechercher(unMedecin) == null){
				throw new Exception("Ce medecin avec le code " + unMedecin + " existe pas");

 			}
 			if(VisiteurDao.rechercher(unVisiteur) == null){
				throw new Exception("Ce visiteur avec le matricule " + unVisiteur + " existe pas");
 			}
 			
 			unVisiteur2=VisiteurDao.rechercher(unVisiteur);
			unMedecin2=MedecinDao.rechercher(unMedecin);
			System.out.println("nom medecin" +unMedecin2.getNom());
			System.out.println("nom visiteur"+unVisiteur2.getNom());
			resultat = VisiteDao.creer(reference,date,commentaire,unVisiteur2.getMatricule(),unMedecin2.getCodeMed());
		
		}catch (Exception e) {
		}
		return resultat;
	}
	
	public int supprimerVisite(String reference) {
		int resultat = 0;
		try {
			if (reference == null) {
				throw new Exception("Donnée obligatoire : reference pour supp");
			}
			resultat = VisiteDao.supprimer(reference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	
}
