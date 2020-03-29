
package gsb.modele;

public class Unite {

	
	protected String CodeUnite;
	protected String Nom;

	//constructeur
	
	public Unite(String CodeUnite, String Nom) {
		this.CodeUnite = CodeUnite;
		this.Nom = Nom;
	}

	// recup un code Unite
	public String getCodeUnite() {
		return CodeUnite;
	}

	//Definir un code unite
	public void setCodeUnite(String codeUnite) {
		CodeUnite = codeUnite;
	}

	//recup un nom 
	public String getNom() {
		return Nom;
	}
 // definir un nom
	public void setNom(String nom) {
		Nom = nom;
	}
}
