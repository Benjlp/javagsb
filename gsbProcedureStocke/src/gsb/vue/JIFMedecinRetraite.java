	package gsb.vue;

	import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.tests.MedecinDaoTestRetournerDictionnaire;

import java.awt.Container;
	import java.awt.Dimension;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
	import javax.swing.JInternalFrame;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;

public class JIFMedecinRetraite extends JInternalFrame implements ActionListener { 


		private static final long serialVersionUID = 1L;


		protected JPanel p;
		protected JScrollPane scrollPane;
		protected JPanel pSaisie;
		protected JButton JBFermer;
		protected JButton JBArchiver;
		protected MenuPrincipal fenetreContainer;
		private HashMap<String,Medecin> diccoMedecin;

		public JIFMedecinRetraite(MenuPrincipal uneFenetreContainer) {
			
			fenetreContainer = uneFenetreContainer;
			diccoMedecin = MedecinDao.retournerDictionnaireDesMedecins();
		
			
			//initialisation de la taille du tableau 
			
			int nbLignes = diccoMedecin.size();
			
			p = new JPanel(); // panneau principal de la fenêtre

			int i=0;
			// Boucle for pour parcourir la collection et ainsi remplir le tableau de la vue
			
			String[][] data = new String[nbLignes][5] ;
			for (Map.Entry<String,Medecin> uneEntree : diccoMedecin.entrySet()){
				data[i][0] = uneEntree.getValue().getCodeMed();
				data[i][1] = uneEntree.getValue().getNom();
				data[i][2] = uneEntree.getValue().getPrenom();
				data[i][3] = uneEntree.getValue().getLaLocalite().getVille();
				data[i][4] = uneEntree.getValue().getRetraite();
				i++;
				}
			String[] columnNames = {"Code Medecin", "Nom"," Prénom","Ville","Retraité"};
			
			// Création du tableau
			
			JTable table;
			table = new JTable(data, columnNames);
			
			scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(400, 200));
			p.add(scrollPane);
			
			// Création des boutons sur la vue 
			
			pSaisie = new JPanel();
			JBArchiver = new JButton("Archiver les medecins retraité");
			JBArchiver.addActionListener(this);
			pSaisie.add(JBArchiver);
			p.add(pSaisie);
	
			
			// mise en forme de la fenêtre
			Container contentPane = getContentPane();
			contentPane.add(p);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Object source = arg0.getSource();
	   		if (source == JBArchiver){
	   		MedecinDao.Archiver();
   		}	
	}
}

