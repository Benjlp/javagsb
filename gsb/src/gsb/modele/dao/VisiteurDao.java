package gsb.modele.dao;
import java.sql.ResultSet;

import gsb.modele.*;

public class VisiteurDao {

	public static Visiteur rechercher(String Matricule){
		Visiteur unVisiteur=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR where MATRICULE ='"+Matricule+"'");
		try {
			if (reqSelection.next()) {
				// Matricule0, Nom1, Prenom2, Login3,  mdp4, Adresse5, Codeostal, CodeUnite8, NomUnite9) { {
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),
						reqSelection.getString(4),reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7),
						reqSelection.getString(8),reqSelection.getString(9),reqSelection.getString(10));
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE ='"+Matricule+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static int creer(Visiteur unVisiteur) {
		String reqInsert;
		String matricule=unVisiteur.getMatricule();
		String nom=unVisiteur.getNom();
		String prenom=unVisiteur.getPrenom();
		String login=unVisiteur.getLogin();
		String mdp=unVisiteur.getMdp();
		String adresse=unVisiteur.getAdresse();
		String Cp=unVisiteur.getCodePostal();
		String CodeUnite=unVisiteur.getCodeUnite();
		String NomUnite=unVisiteur.getNomUnite();
		String DateEntree=unVisiteur.getDateEntree();
		
		reqInsert="Insert into VISITEUR values('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+Cp+"','"+DateEntree+"''"+NomUnite+"','"+CodeUnite+"')";
		
		int result =ConnexionMySql.execReqMaj(reqInsert);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
}
