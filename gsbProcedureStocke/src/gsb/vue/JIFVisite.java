
package gsb.vue;

import gsb.modele.Visite;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFVisite extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
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

    ;
    
	protected JTextField JTReference;
	protected JTextField JTdate;
	protected JTextField JTcommentaire;
	protected JTextField JTunMedecin;
	protected JTextField JTunVisiteur;
 
	
    public JIFVisite() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
        JLReference = new JLabel("Reference");
        JLdate = new JLabel("Date");
        JLcommentaire = new JLabel("Commentaire");
        JLunMedecin = new JLabel("Medecin");
        JLunVisiteur = new JLabel("Visiteur");
               
        JTReference = new JTextField(20);
        JTReference.setMaximumSize(JTReference.getPreferredSize());
         JTdate = new JTextField();
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


		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Visite uneVisite) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
    	JTReference.setText(uneVisite.getReference());       
    	JTdate.setText(uneVisite.getDate());
    	JTcommentaire.setText(uneVisite.getCommentaire());
    	JTunMedecin.setText(uneVisite.getUnMedecin().getCodeMed());    
    	JTunVisiteur.setText(uneVisite.getUnVisiteur().getMatricule());

     }
     
      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
    	  JTReference.setText("");        
    	  JTdate.setText("");
    	  JTcommentaire.setText("");
    	  JTunMedecin.setText("");    
    	  JTunVisiteur.setText("");
       }


    
}
