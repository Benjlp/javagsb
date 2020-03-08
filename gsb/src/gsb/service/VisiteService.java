package gsb.service;

import gsb.modele.*;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;


// Class service 
public class VisiteService {

	// m�thode pour rechercher une visite en fonction d'une ref
	
	public static Visite rechercherVisite(String reference) {
		Visite UneVisite = null;
		
		try {
			// OBlige une ref
			if (reference == null) {
				throw new Exception("Donn�e obligatoire : reference");
			}
			// on appelle la m�thode de visite dao pour rechercher une visite 
			UneVisite = VisiteDao.rechercher(reference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return UneVisite;
	}


	// m�thode pour ajouter une visite  
	
	public static boolean AjouterVisite(String reference, String date, String commentaire, String unMedecin, String unVisiteur) {

		Medecin unMedecin2;
		Visiteur unVisiteur2;
		
		boolean resultat = false;
		// on test si les champs sont pleins
		try { 
			if (reference.equals("") || date.equals("") ||  unMedecin.equals("") || unVisiteur.equals("")) {
				throw new Exception("Donn�es obligatoires : reference, date, unMedecin, unVisiteur");

			}
			// test si une visite avec cette ref existe
 			if (VisiteDao.rechercher(reference) != null) {
				
				throw new Exception("Une visite avec la ref�rence " + reference + " existe d�j�");
			}
 			
 			// test si un medecin n'existe pas
 			if(MedecinDao.rechercher(unMedecin) == null){
				throw new Exception("Ce medecin avec le code " + unMedecin + " existe pas");

 			}
 			// test si le visiteur existe
 			
 			if(VisiteurDao.rechercher(unVisiteur) == null){
				throw new Exception("Ce visiteur avec le matricule " + unVisiteur + " existe pas");
 			}
 			
 			// recherche un visiteur
 			unVisiteur2=VisiteurDao.rechercher(unVisiteur);
 			// recherche un medecin 
			unMedecin2=MedecinDao.rechercher(unMedecin);
			System.out.println("nom medecin" +unMedecin2.getNom());
			System.out.println("nom visiteur"+unVisiteur2.getNom());
			// on cr�er la visite 
			resultat = VisiteDao.creer(reference,date,commentaire,unVisiteur2.getMatricule(),unMedecin2.getCodeMed());
		
		}catch (Exception e) {
		}
		return resultat;
	}
	// M�thode pour supprimer une visite
	
	public int supprimerVisite(String reference) {
		int resultat = 0;
		try {
			if (reference == null) {
				throw new Exception("Donn�e obligatoire : reference pour supp");
			}
			// on appele la m�thode DAO pour supprimer la visite
			resultat = VisiteDao.supprimer(reference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	
}
