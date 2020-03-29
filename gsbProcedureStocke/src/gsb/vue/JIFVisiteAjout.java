package gsb.vue;
import gsb.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gsb.modele.dao.*;
import gsb.service.VisiteService;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Visite;

public class JIFVisiteAjout extends JInternalFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	protected JButton Valider;
	

	protected JLabel JLReference;
	protected JLabel JLdate;
	protected JLabel JLcommentaire;
	protected JLabel JLunMedecin;
	protected JLabel JLunVisiteur;
	
	protected JLabel JluneErreur;

    ;
    
	protected JTextField JTReference;
	protected JTextField JTdate;
	protected JTextField JTcommentaire;
	protected JTextField JTunMedecin;
	protected JTextField JTunVisiteur;
	
	protected JTextField JTuneErreur;
 
    
    public JIFVisiteAjout() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
        JLReference = new JLabel("Réference");
        JLdate = new JLabel("Date");
        JLcommentaire = new JLabel("Commentaire");
        JLunMedecin = new JLabel("Medecin");
        JLunVisiteur = new JLabel("Visiteur");
        Valider = new JButton("Valider");
        Valider.addActionListener(this);       
        JluneErreur= new JLabel("");
         
        JTReference = new JTextField(20);
        JTReference.setMaximumSize(JTReference.getPreferredSize());
        JTdate = new JTextField(20);
        JTcommentaire = new JTextField();
        JTunMedecin = new JTextField();
        JTunVisiteur = new JTextField();    
       
        
         pTexte.add(JLReference);
         pTexte.add(JTReference);
         pTexte.add(JLdate);
         pTexte.add(JTdate);
         pTexte.add(JLcommentaire);
         pTexte.add(JTcommentaire);
         pTexte.add(JLunMedecin);
         pTexte.add(JTunMedecin);
         pTexte.add(JLunVisiteur);
         pTexte.add(JTunVisiteur);
         pBoutons.add(Valider);
         p.add(JluneErreur);

        
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    //quand on clique sur ajouter 
    public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == Valider) {
			
			try {
				String reference = JTReference.getText();
				String date = JTdate.getText();
				String commentaire =JTcommentaire.getText();
				String unMedecin = JTunMedecin.getText();
				String unVisiteur = JTunVisiteur.getText();
				// test si c'est egal a vide si oui excepetion 
				if (reference.equals("") || date.equals("") ||  unMedecin.equals("") || unVisiteur.equals("")) {
					throw new Exception("Données obligatoires : reference,date, Medecin, Visiteur");
				}
				// test si la visite existe pas déjà
				if (VisiteDao.rechercher(reference) != null) {
					
					throw new Exception("Une visite avec le code " + reference + " existe déjà");
				}
	 			// test si le medecin existe
	 			if(MedecinDao.rechercher(unMedecin) == null){
					throw new Exception("Ce medecin avec le code " + unMedecin + " n'existe pas");

	 			}
	 			// test si  le visiteur existe
	 			if(VisiteurDao.rechercher(unVisiteur) == null){
					throw new Exception("Ce visiteur avec le matricule " + unVisiteur + " n'existe pas");
	 			}

			// on appelle la méthode ajouterVisite de visiteService
				if (VisiteService.AjouterVisite(reference,date,commentaire,unMedecin,unVisiteur)) {
					JOptionPane.showMessageDialog(null, "La visite a été ajouté ", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch(Exception e) {
				JluneErreur.setText(e.getMessage());
			}
		}
	}  	
}