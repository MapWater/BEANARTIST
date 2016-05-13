/**
 * 
 */
package fr.eseo.gpi.beanartist.vue.geom;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import fr.eseo.gpi.beanartist.modele.geom.Ligne;

/**
 * @author Clément
 *
 */
public class VueLigne extends VueForme{
			
	// CONSTRUCTEURS
	
	public VueLigne(){
		super();
	}
	
	public VueLigne(Ligne ligne){
		super(ligne, VueForme.COULEUR_LIGNE_PAR_DÉFAUT, true);
	}
	
	public VueLigne(Ligne ligne, Color couleurLigne){
		super(ligne, couleurLigne, true);
	}
	
	// AUTRES METHODES
	
	public void affiche(Graphics2D g2d){
		g2d.setColor(this.getCouleurLigne());	
		g2d.draw(new Line2D.Double(this.getForme().getX(), this.getForme().getY(), this.getForme().getLargeur()+this.getForme().getX(), this.getForme().getHauteur()+this.getForme().getY()));
	}
	
}
