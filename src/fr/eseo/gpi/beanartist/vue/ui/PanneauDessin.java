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
	public static final int LARGEUR_PAR_D�FAUT = 800;
	public static final int HAUTEUR_PAR_D�FAUT = 600;
	public static final Color COULEUR_FOND_PAR_D�FAUT = Color.white;
	public static final Color COULEUR_LIGNE_PAR_D�FAUT = Color.black;
	public static final VueForme VUE_TEMP = new VueLigne(new Ligne(-1, -1), Color.black);
	
	// Attributs
	private Fen�treBeAnArtist fen�tre;
	private List<VueForme> vueFormes;
	private VueForme vueTemp;
	private Outil outilCourant;
	private Color couleurForme;
	private Color couleurFond;
	private boolean rempli;
	
	// Constructeurs
	
	public PanneauDessin(int youpi, int youpa){
	}
	public PanneauDessin(int youpi, int youpa, Color coul){
	}
	
	public PanneauDessin(Color couleurFond, Color couleurForme, Fen�treBeAnArtist fen){
		this(LARGEUR_PAR_D�FAUT, HAUTEUR_PAR_D�FAUT, couleurFond, couleurForme, fen);
	}
	
	
	public PanneauDessin(int largeur, int hauteur, Color couleurFond, Color couleurForme, Fen�treBeAnArtist fen){
		this.fen�tre = fen;
		this.couleurForme = couleurForme;
		this.couleurFond = couleurFond;
		this.rempli = false;
		this.setOpaque(true);
		this.setBackground(couleurFond);
		this.setMinimumSize(new Dimension(largeur, hauteur));
		this.setPreferredSize(new Dimension(largeur, hauteur));
		
		this.vueFormes = new ArrayList<VueForme>();
		this.vueTemp = VUE_TEMP;
	}

	// Autres M�thodes
	
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
	
	public Fen�treBeAnArtist getFen�tre(){
		return this.fen�tre;
	}
	
	public void setFen�tre(Fen�treBeAnArtist fen){
		this.fen�tre = fen;
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
	
	public void setCouleurFond(Color couleur){
		this.couleurFond = couleur;		
	}
	
	public Color getCouleurFond(){
		return this.couleurFond;
	}
	
	public void setCouleurLigne(Color couleur){
		this.couleurFond = couleur;		
	}
	
	public Color getCouleurLigne(){
		return this.couleurFond;
	}
	
}
