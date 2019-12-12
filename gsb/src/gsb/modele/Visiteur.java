package gsb.modele;

public class Visiteur {

	protected String Matricule;
	protected String Nom;
	protected String Prenom;
	protected String Login;
	protected String mdp;
	protected String Adresse;
	protected String codePostal;
	protected String dateEntree;
	protected String CodeUnite;
	protected String NomUnite;


	public Visiteur(String Matricule,String Nom,String Prenom,String Login, String mdp,
			String Adresse,String codePostal,String DateEntree,String CodeUnite,String NomUnite) {
			
		this.Matricule=Matricule;
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.Login=Login;
		this.mdp=mdp;
		this.Adresse=Adresse;
		this.codePostal=codePostal;
		this.dateEntree=DateEntree;
		this.CodeUnite=CodeUnite;
		this.NomUnite=NomUnite;
	
	}

	public String getCodeUnite() {
		return CodeUnite;
	}

	public void setCodeUnite(String codeUnite) {
		CodeUnite = codeUnite;
	}

	public String getNomUnite() {
		return NomUnite;
	}

	public void setNomUnite(String nomUnite) {
		NomUnite = nomUnite;
	}
	
	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	
	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}


}
