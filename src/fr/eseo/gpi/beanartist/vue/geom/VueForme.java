/**
 * 
 */
package fr.eseo.gpi.beanartist.vue.geom;
import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.gpi.beanartist.modele.geom.Forme;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;

/**
 * @author Clément
 *
 */
public abstract class VueForme {
	
	// CONSTANTES DE CLASSE
	public static final Color COULEUR_LIGNE_PAR_DÉFAUT = Color.black;
	public static final Rectangle FORME_PAR_DÉFAUT = new Rectangle();
	
	// ATTRIBUTS
	protected Forme forme;
	private Color couleurLigne;
	private boolean rempli;
	
	
	
	// CONSTRUCTEURS
	
	public VueForme(){
		this(FORME_PAR_DÉFAUT, COULEUR_LIGNE_PAR_DÉFAUT, false);
	}
	
	public VueForme(Forme forme, boolean rempli){
		this(forme, COULEUR_LIGNE_PAR_DÉFAUT, rempli);
	}
	
	public VueForme(Forme forme, Color couleurLigne, boolean rempli){
		this.forme = forme;
		this.couleurLigne = couleurLigne;
		this.setRempli(rempli);
	}
	
	
	// ACCESSEURS
	public Forme getForme(){
		return this.forme;
	}
	
	public void setForme(Forme forme){
		this.forme = forme;
	}
	
	public Color getCouleurLigne(){
		return this.couleurLigne;
	}
	
	public void setCouleurLigne(Color couleurLigne){
		this.couleurLigne = couleurLigne;
	}
	
	// AUTRES METHODES
	
	public void setRempli(boolean rempli){
		this.rempli = rempli;
	}
	
	public boolean estRempli(){
		return this.rempli;
	}
	
	abstract public void affiche(Graphics2D g2d);
	
}
