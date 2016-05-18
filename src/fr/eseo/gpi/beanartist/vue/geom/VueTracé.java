/**
 * 
 */
package fr.eseo.gpi.beanartist.vue.geom;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import fr.eseo.gpi.beanartist.modele.geom.Trac�;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;

/**
 * @author Cl�ment
 *
 */
public class VueTrac� extends VueForme{
			
	// CONSTRUCTEURS
	
	public VueTrac�(){
		super();
	}
	
	public VueTrac�(Trac� trace){
		super(trace, VueForme.COULEUR_LIGNE_PAR_D�FAUT, true);
	}
	
	public VueTrac�(Trac� trace, Color couleurLigne){
		super(trace, couleurLigne, true);
	}
	
	// AUTRES METHODES
		
	public void affiche(Graphics2D g2d){
		g2d.setColor(this.getCouleurLigne());		 
		for(Ligne ligne : ((Trac�)this.getForme()).getLignes()){
			(new VueLigne(ligne, this.getCouleurLigne())).affiche(g2d);
		}
	}
	
}
