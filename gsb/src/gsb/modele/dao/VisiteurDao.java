 package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.*;

public class VisiteurDao {

	//Rechercher un visiteur 
	
	public static Visiteur rechercher(String Matricule) {
	
		Visiteur unVisiteur = null;
		Unite uneUnite = null;
		//requete sql 
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR where MATRICULE ='" + Matricule + "'");
		try {
			// en fonction du résultat ajoute au correspondant ( nom  vers nom etc ) 
			
			if (reqSelection.next()) {
				uneUnite = UniteDao.rechercher(reqSelection.getString(9));
				// public Visiteur(String Matricule1,String Nom2,String Prenom3,String Login4,
				// String mdp5,String Adresse6,String Telephone7,int Prime8,Unite uneUnite9) {
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8),
						 uneUnite);
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE ='"
					+ Matricule + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}

	//Collection des visiteurs
	public static ArrayList<Visiteur> retournerCollectionDesVisiteurs() {
		ArrayList<Visiteur> collectionDesVisiteurs = new ArrayList<Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from VISITEUR");
		try {
			while (reqSelection.next()) {
				String matricule = reqSelection.getString(1);
				collectionDesVisiteurs.add(VisiteurDao.rechercher(matricule));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisiteurs()");
		}
		return collectionDesVisiteurs;
	}

//Créer un visiteur : on insert un visiteur ave cu nensemble de paramètre 
	
	public static int creer(Visiteur unVisiteur) {
	//on definit des variables en fonctiopns d'un visiteur
		String reqInsert;
		String matricule = unVisiteur.getMatricule();
		String nom = unVisiteur.getNom();
		String prenom = unVisiteur.getPrenom();
		String login = unVisiteur.getLogin();
		String mdp = unVisiteur.getMdp();
		String adresse = unVisiteur.getAdresse();
		String cp = unVisiteur.getCodePostal();

		String unite = unVisiteur.getUneUnite().getCodeUnite();
		//On envoie dans la BDD
		reqInsert = "Insert into VISITEUR values('" + matricule + "','" + nom + "','" + prenom + "','" + login + "','"
				+ mdp + "','" + adresse + "','" + cp + "','" + unite + "')";

		// on test le résultat
		int result = ConnexionMySql.execReqMaj(reqInsert);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
}
