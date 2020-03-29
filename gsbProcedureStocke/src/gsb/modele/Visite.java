package gsb.modele;

public class Visite {

	protected String reference;
	protected String date;
	protected String commentaire;
	protected Medecin unMedecin;
	protected Visiteur unVisiteur;
	
	// constructeur

	public Visite(String reference,String date,String commentaire,
			Medecin unMedecin,Visiteur unVisiteur) {
		
		this.reference=reference;
		this.date=date;
		this.commentaire=commentaire;
		this.unMedecin=unMedecin;
		this.unVisiteur=unVisiteur;
		
	}

	// recup la valeur de un medecin
	
	public Medecin getUnMedecin() {
		return unMedecin;
	}
	// definir la valeur d'un medecin 

	public void setUnMedecin(Medecin unMedecin) {
		this.unMedecin = unMedecin;
	}

	// recup la valeur d'un visiteur

	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	// definir la valeur d'un visiteur

	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

	// recup la valeur d'une référence

	public String getReference() {
		return reference;
	}

	// definir la valeur d'une référence 

	public void setReference(String reference) {
		this.reference = reference;
	}

	// recup la valeur d'une date

	public String getDate() {
		return date;
	}
	// definir la valeur d'une date


	public void setDate(String date) {
		this.date = date;
	}

	// recup la valeur d'un commentaire

	public String getCommentaire() {
		return commentaire;
	}
	// definir la valeur d'un commenataire


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	
}