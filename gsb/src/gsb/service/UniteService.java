package gsb.service;

import gsb.modele.Unite;
import gsb.modele.dao.*;
public class UniteService {

	
	public static Unite rechercherUnite(String CodeUnite){
		Unite uneUnite = null;
		try{
		if (CodeUnite==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		uneUnite = UniteDao.rechercher(CodeUnite);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneUnite;
	}
	
	
}
