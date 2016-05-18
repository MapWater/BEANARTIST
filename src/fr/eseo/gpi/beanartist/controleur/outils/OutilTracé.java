/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.vue.geom.VueTrac�;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Point;

import java.awt.Color;
import java.awt.event.MouseEvent;
import fr.eseo.gpi.beanartist.modele.geom.Trac�;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;



/**
 * @author Cl�ment
 *
 */
public class OutilTrac� extends OutilForme {

	// CONSTANTE
	public static final double EPSILLON = 0.0000001;
	
	// ATTRIBUTS
	private double newCoef;
	private double oldCoef;
	private boolean newInfini;
	private boolean oldInfini;
	private Trac� trac�;
	
	// METHODES
	
	public OutilTrac�() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	/**
	 * @param panneauDessin
	 */
	public OutilTrac�(PanneauDessin panneauDessin) {
		super(panneauDessin);
		
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#cr�erVueForme()
	 */
	@Override
	protected VueForme cr�erVueForme() {
		VueTrac� vueTrac� = new VueTrac�(this.getTrac�(), this.getPanneauDessin().getCouleurForme());
		return vueTrac�;
	}
	
	public void mousePressed(MouseEvent event){
		this.setD�but(new Point(event.getX(), event.getY()));
		this.setTrac�(new Trac�(this.getD�but(), this.getD�but()));
	}
	
	public void mouseReleased(MouseEvent event){
		PanneauDessin pan = this.getPanneauDessin();
		pan.ajouterVueForme(this.cr�erVueForme());
		this.getPanneauDessin().setVueTemp(PanneauDessin.VUE_TEMP);
		this.getPanneauDessin().repaint();
	}
	
	public void mouseClicked(MouseEvent event){
		
	}
	
	public void mouseDragged(MouseEvent event){
		PanneauDessin pan = this.getPanneauDessin();
		Point finAux = new Point(event.getX(), event.getY());
		this.getTrac�().ajouterLigneVers(finAux);
		this.setD�but(finAux);		

		pan.setVueTemp(this.cr�erVueForme());
		this.getPanneauDessin().repaint();
	}
	
	// ACCESSEURS
	
	public void setTrac�(Trac� t){
		this.trac� = t;
	}
	
	public Trac� getTrac�(){
		return this.trac�;
	}

}
