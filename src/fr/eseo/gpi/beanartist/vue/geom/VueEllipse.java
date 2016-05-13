/**
 * 
 */
package fr.eseo.gpi.beanartist.vue.geom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import fr.eseo.gpi.beanartist.modele.geom.Forme;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;

/**
 * @author Clément
 *
 */
public class VueEllipse extends VueForme {

	/**
	 * 
	 */
	public VueEllipse() {
		super();
	}

	/**
	 * @param rectangle
	 * @param rempli
	 */
	public VueEllipse(Ellipse ellipse, boolean rempli) {
		super(ellipse, rempli);
	}

	/**
	 * @param rectangle
	 * @param couleurLigne
	 * @param rempli
	 */
	public VueEllipse(Ellipse ellipse, Color couleurLigne, boolean rempli) {
		super(ellipse, couleurLigne, rempli);
	}
	
	// AUTRES METHODE
	public void affiche(Graphics2D g2d){
		g2d.setColor(this.getCouleurLigne());
		if (this.estRempli()){
			g2d.fill(new Ellipse2D.Double(this.getForme().getX(), this.getForme().getY(), this.getForme().getLargeur(), this.getForme().getHauteur()));
		} 
		g2d.draw(new Ellipse2D.Double(this.getForme().getX(), this.getForme().getY(), this.getForme().getLargeur(), this.getForme().getHauteur()));
	}

}
