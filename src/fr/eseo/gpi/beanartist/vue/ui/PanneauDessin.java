package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.controleur.outils.Outil;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;


public class PanneauDessin extends JPanel{
	
	// Constantes
	public static final int LARGEUR_PAR_DÉFAUT = 600;
	public static final int HAUTEUR_PAR_DÉFAUT = 600;
	public static final Color COULEUR_FOND_PAR_DÉFAUT = Color.white;
	public static final Color COULEUR_LIGNE_PAR_DÉFAUT = Color.black;
	public static final VueForme VUE_TEMP = new VueLigne(new Ligne(-1, -1), Color.black);
	
	// Attributs
	private FenêtreBeAnArtist fenêtre;
	private List<VueForme> vueFormes;
	private VueForme vueTemp;
	private Outil outilCourant;
	private Color couleurForme;
	private Color couleurFond;
	private boolean rempli;
	
	// Constructeurs
	public PanneauDessin(Color couleurFond, Color couleurForme, FenêtreBeAnArtist fen){
		this(LARGEUR_PAR_DÉFAUT, HAUTEUR_PAR_DÉFAUT, couleurFond, couleurForme, fen);
	}
	
	
	public PanneauDessin(int largeur, int hauteur, Color couleurFond, Color couleurForme, FenêtreBeAnArtist fen){
		this.fenêtre = fen;
		this.couleurForme = couleurForme;
		this.couleurFond = couleurFond;
		this.rempli = false;
		this.setOpaque(true);
		this.setMinimumSize(new Dimension(largeur, hauteur));
		this.setPreferredSize(new Dimension(largeur, hauteur));
		
		this.vueFormes = new ArrayList<VueForme>();
		this.vueTemp = VUE_TEMP;
	}

	// Autres Méthodes
	
	public void ajouterVueForme(VueForme vue){
		this.getVueFormes().add(vue);
	}

	public void paintComponent(Graphics g){
		this.setBackground(couleurFond);
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		for (VueForme vue : this.getVueFormes()){
			vue.affiche(g2d);
		}
		this.getVueTemp().affiche(g2d);
//		System.out.println(this.getVueTemp().getForme());
		g2d.dispose();
		this.revalidate();
		this.repaint();
		this.removeAll(); 
//		this.updateUI();
	}
	
	public boolean estModeRemplissage(){
		return this.rempli;
	}
	
	public void setModeRemplissage(boolean mode){
		this.rempli = mode;
	}
	
	// ACCESSEURS
	
	public FenêtreBeAnArtist getFenêtre(){
		return this.fenêtre;
	}
	
	public void setFenêtre(FenêtreBeAnArtist fen){
		this.fenêtre = fen;
	}
	
	public List<VueForme> getVueFormes(){
		return this.vueFormes;
	}
	
	public VueForme getVueTemp(){
		return this.vueTemp;
	}
	
	public void setVueTemp(VueForme vueTemp){
		this.vueTemp = vueTemp;
	}
	
	public void setCouleurForme(Color couleurForme){
		this.couleurForme = couleurForme;
	}
	
	public Color getCouleurForme(){
		return this.couleurForme;
	}
	
	public void setOutilCourant(Outil outil){
		this.outilCourant = outil;		
	}
	
	public Outil getOutilCourant(){
		return this.outilCourant;
	}
	
}
