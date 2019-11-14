package gsb.modele.dao;
import java.sql.ResultSet;

import gsb.modele.*;

public class VisiteurDao {

	public static Visiteur rechercher(String Matricule){
		Visiteur unVisiteur=null;
		Unite uneUnite= null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from Visiteur where Matricule ='"+Matricule+"'");
		try {
			if (reqSelection.next()) {
				uneUnite = UniteDao.rechercher(reqSelection.getString(10));
			//	public Visiteur(String Matricule1,String Nom2,String Prenom3,String Login4, String mdp5,String Adresse6,String Telephone7,int Prime8,Unite uneUnite9) {
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),reqSelection.getString(4),reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7),reqSelection.getString(8), reqSelection.getInt(9),uneUnite);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from Visiteur where Matricule ='"+Matricule+"'");
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
		String tel=unVisiteur.getTelephone();
		int prime=unVisiteur.getPrime();
		String unite=unVisiteur.getUneUnite().getCodeUnite();		
		reqInsert="Insert into Visiteur values('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+tel+"','"+prime+"''"+unite+"')";
		
		int result =ConnexionMySql.execReqMaj(reqInsert);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
}
