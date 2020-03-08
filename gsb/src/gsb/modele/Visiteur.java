package gsb.modele;

public class Visiteur {

	// Declaration visiteur
	
	protected String Matricule;
	protected String Nom;
	protected String Prenom;
	protected String Login;
	protected String mdp;
	protected String Adresse;
	protected String CodePostal;
	protected String dateEntree;
	protected Unite uneUnite;

	//Constructeur
	
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
	
// recup un code unite
	public Unite getUneUnite() {
		return uneUnite;
	}

	//definir un code unite
	public void setUneUnite(Unite uneUnite) {
		this.uneUnite = uneUnite;
	}

	//recup un matricule
	public String getMatricule() {
		return Matricule;
	}
	//definir un matricule
	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

	//recup un nom
	public String getNom() {
		return Nom;
	}
//definir un nom
	public void setNom(String nom) {
		Nom = nom;
	}

	//recup un prénom
	public String getPrenom() {
		return Prenom;
	}

	//definir un prénom
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	//definir un login

	public String getLogin() {
		return Login;
	}
	//créer un login 
	public void setLogin(String login) {
		Login = login;
	}
	//recup un mdp
	
	public String getMdp() {
		return mdp;
	}

	// definir un mdp
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	//recup une adresse
	public String getAdresse() {
		return Adresse;
	}
	//definir une adresse
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	//recup un code postal
	public String getCodePostal() {
		return CodePostal;
	}

	//definir un code postale
	public void setCodePostal(String telephone) {
		CodePostal = telephone;
	}

	//recup une date entrée
	public String getDateEntree() {
		return dateEntree;
	}

	//definir la date entrée
	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}


}
