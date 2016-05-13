/**
 * 
 */
package fr.eseo.gpi.beanartist.vue.geom;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;

/**
 * @author Clément
 *
 */
public class VueTracé extends VueForme{
			
	// CONSTRUCTEURS
	
	public VueTracé(){
		super();
	}
	
	public VueTracé(Tracé trace){
		super(trace, VueForme.COULEUR_LIGNE_PAR_DÉFAUT, true);
	}
	
	public VueTracé(Tracé trace, Color couleurLigne){
		super(trace, couleurLigne, true);
	}
	
	// AUTRES METHODES
		
	public void affiche(Graphics2D g2d){
		g2d.setColor(this.getCouleurLigne());		 
		for(Ligne ligne : ((Tracé)this.getForme()).getLignes()){
			System.out.println(ligne.toString());
			(new VueLigne(ligne, this.getCouleurLigne())).affiche(g2d);
		}
	}
	
}
