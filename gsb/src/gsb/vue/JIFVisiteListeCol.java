/*
 * Créé le 3 mars 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Isabelle
 * 3 mars 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class JIFVisiteListeCol extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTReference;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	private ArrayList<Visite>lesVisites;

	public JIFVisiteListeCol(MenuPrincipal uneFenetreContainer) {
		
		fenetreContainer = uneFenetreContainer;


// récupération des Visite et création de la collection
		
		lesVisites = VisiteDao.retournerCollectionLesVisites();
		
		//initialisation de la taille du tableau 
		
		int nbLignes = lesVisites.size();
		
		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		// Boucle for pour parcourir la collection et ainsi remplir le tableau de la vue
		
		String[][] data = new String[nbLignes][5] ;
		for(Visite uneVisite : lesVisites){
			data[i][0] = uneVisite.getReference();
			data[i][1] = uneVisite.getDate();
			data[i][2] = uneVisite.getCommentaire();
			data[i][3] = uneVisite.getUnMedecin().getCodeMed();
			data[i][4] = uneVisite.getUnVisiteur().getMatricule();
			i++;
			}
		String[] columnNames = {"Reference", "Date","Commentaire","Medecin","Visiteur"};
		
		// Création du tableau
		
		JTable table;
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		// Création des boutons sur la vue 
		
		pSaisie = new JPanel();
		JTReference = new JTextField(20);
		JTReference.setMaximumSize(JTReference.getPreferredSize());
		JBafficherFiche = new JButton("Afficher liste Visite");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTReference);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Visite uneVisite = VisiteDao.rechercher(JTReference.getText());
   			if (uneVisite!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFVisiteFiche(uneVisite));
   			}
   		}	
	}
}
