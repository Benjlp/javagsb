package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Visite;

public class JIFListeVisite extends JInternalFrame{
	
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

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
 
    
    public JIFListeVisite() {
    	p = new JPanel();  // panneau principal de la fen�tre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
        JLReference = new JLabel("R�ference");
        JLdate = new JLabel("Date");
        JLcommentaire = new JLabel("Commentaire");
        JLunMedecin = new JLabel("Medecin");
        JLunVisiteur = new JLabel("Visiteur");
        
         
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
         pTexte.add(JTunVisiteur);
        
		
        // mise en forme de la fen�tre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Visite uneVisite) 	
    {  // m�thode qui permet de remplir les zones de texte � partir des valeurs pass�es en param�tres
    	
    	JTReference.setText(uneVisite.getReference());        
        JTdate.setText(uneVisite.getDate());
        JTcommentaire.setText(uneVisite.getCommentaire());
        JTunMedecin.setText(uneVisite.getUnMedecin());    
        JTunVisiteur.setText(uneVisite.getUnVisiteur());
      
     }
     
      public void viderText() 	
    {  // m�thode qui permet de vider les zones de texte 
        JTcode.setText("");        
        JTnom.setText("");
        JTprenom.setText("");
        JTadresse.setText("");    
        JTcp.setText("");
        JTville.setText("");
        JTtelephone.setText("");
        JTpotentiel.setText("");
        JTspecialite.setText("");
     }


    
}

