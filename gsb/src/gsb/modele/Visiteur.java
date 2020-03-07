package gsb.modele;

public class Visiteur {

	protected String Matricule;
	protected String Nom;
	protected String Prenom;
	protected String Login;
	protected String mdp;
	protected String Adresse;
	protected String CodePostal;
	protected String dateEntree;
	protected Unite uneUnite;

	public Visiteur(String Matricule, String Nom, String Prenom, String Login, String mdp, String Adresse,
			String Telephone, String DateEntree, Unite uneUnite) {

		this.Matricule = Matricule;
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Login = Login;
		this.mdp = mdp;
		this.Adresse = Adresse;
		this.CodePostal = Telephone;
		this.dateEntree = DateEntree;
		this.uneUnite = uneUnite;

	}

	public Unite getUneUnite() {
		return uneUnite;
	}

	public void setUneUnite(Unite uneUnite) {
		this.uneUnite = uneUnite;
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
		return CodePostal;
	}

	public void setCodePostal(String telephone) {
		CodePostal = telephone;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}


}
