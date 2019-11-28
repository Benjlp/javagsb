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
				throw new Exception("Donn�e obligatoire : reference");
			}
			UneVisite = VisiteDao.rechercher(reference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return UneVisite;
	}


	// (String reference,String date,String commentaire,Medecin unMedecin,Visiteur
	// unVisiteur)7

	public static int AjouterVisite(String reference, String date, String commentaire, String unMedecin, String unVisiteur) {

		Visite uneVisite;
		Medecin unMedecin2;
		Visiteur unVisiteur2;

		
		int resultat = 0;

		try { // controle des param�tres d'entr�e
			// Si une donn�e est manquante on l�ve une exception
			if (reference == null || date == null ||  unMedecin == null || unVisiteur == null)
				throw new Exception("Donn�es obligatoires : reference, date, commentaire, unMedecin, unVisiteur");
			
			if (VisiteDao.rechercher(reference) != null) {
				// Si la base de donn�e contient d�j� un client ayant ce code on envoie une
				// exception
				throw new Exception("Un contact avec le code " + reference + " existe d�j�");
			}
			unVisiteur2=VisiteurDao.rechercher(unVisiteur);
			unMedecin2=MedecinDao.rechercher(unMedecin);
			uneVisite = new Visite(reference, date, commentaire,unMedecin2, unVisiteur2);
			resultat = VisiteDao.creer(uneVisite);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	public int supprimerVisite(String reference) {
		int resultat = 0;
		try {
			if (reference == null) {
				throw new Exception("Donn�e obligatoire : reference");
			}
			resultat = VisiteDao.supprimer(reference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	
}
