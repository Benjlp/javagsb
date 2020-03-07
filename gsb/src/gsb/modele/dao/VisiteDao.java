package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.*;

public class VisiteDao {

	public static Visite rechercher(String references) {
		
		Visite uneVisite=null;
		Medecin unMedecin =null;
		Visiteur unVisiteur=null;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITE where REFERENCE ='"+references+"'");
		System.out.println("select * from VISITE where REFERENCE ='"+references+"'");
		try {
			if (reqSelection.next()) {
				// public Visite(String reference1,String date2,String commentaire3,Medecin4 unMedecin,Visiteur5 unVisiteur) 
				unMedecin = MedecinDao.rechercher(reqSelection.getString(5));
				System.out.println("codemed "+reqSelection.getString(5));
				unVisiteur =VisiteurDao.rechercher(reqSelection.getString(4));
				System.out.println("codevis "+reqSelection.getString(4));

				uneVisite = new Visite(reqSelection.getString(1),reqSelection.getString(2),reqSelection.getString(3),unMedecin,unVisiteur);
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITE where MATRICULE ='"+references+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		System.out.println("unvisiteur d'une visite :" + uneVisite);
		return uneVisite;
	}
	
	public static boolean creer(String reference,String date, String commentaire,String matricule, String codeMed ) {
		
		boolean result=false;	
		
		String reqInsert="Insert into VISITE values('"+reference+"','"+date+"','"+commentaire+"','"+matricule+"','"+codeMed+"')";
		
		
		if(ConnexionMySql.execReqMaj(reqInsert)==1)result=true;
		
		return result;

	}
	
	public static int supprimer(String reference){
		String requeteSuppression = "delete from VISITE where REFERENCE='"+reference+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static ArrayList<Visite> retournerCollectionLesVisites() {
		ArrayList<Visite> collectionDesVisites= new ArrayList<Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE;");
		try {
			while (reqSelection.next()) {
				String reference = reqSelection.getString(1);
				collectionDesVisites.add(VisiteDao.rechercher(reference));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisites()");
		}
		return collectionDesVisites;
	}
}
