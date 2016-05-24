/**
 * 
 */
package fr.eseo.gpi.beanartist.vue.geom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import fr.eseo.gpi.beanartist.modele.geom.Forme;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;

/**
 * @author Clément
 *
 */
public class VueRectangle extends VueForme {

	/**
	 * 
	 */
	public VueRectangle() {
		super();
	}

	/**
	 * @param rectangle
	 * @param rempli
	 */
	public VueRectangle(Rectangle rectangle, boolean rempli) {
		super(rectangle, rempli);
	}

	/**
	 * @param rectangle
	 * @param couleurLigne
	 * @param rempli
	 */
	public VueRectangle(Rectangle rectangle, Color couleurLigne, boolean rempli) {
		super(rectangle, couleurLigne, rempli);
	}
	
	// AUTRES METHODE
	public void affiche(Graphics2D g2d){
		g2d.setColor(this.getCouleurLigne());
		if (this.estRempli()){
			g2d.fill(new Rectangle2D.Double(this.getForme().getX(), this.getForme().getY(), this.getForme().getLargeur(), this.getForme().getHauteur()));
		} 
		g2d.draw(new Rectangle2D.Double(this.getForme().getX(), this.getForme().getY(), this.getForme().getLargeur(), this.getForme().getHauteur()));
	}

}
