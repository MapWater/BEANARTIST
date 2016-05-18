/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.vue.geom.VueTracé;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Point;

import java.awt.Color;
import java.awt.event.MouseEvent;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;



/**
 * @author Cl�ment
 *
 */
public class OutilTracé extends OutilForme {

	// CONSTANTE
	public static final double EPSILLON = 0.0000001;
	
	// ATTRIBUTS
	private double newCoef;
	private double oldCoef;
	private boolean newInfini;
	private boolean oldInfini;
	private Tracé tracé;
	
	// METHODES
	
	public OutilTracé() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	/**
	 * @param panneauDessin
	 */
	public OutilTracé(PanneauDessin panneauDessin) {
		super(panneauDessin);
		
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#cr�erVueForme()
	 */
//	@Override
	protected VueForme créerVueForme() {
		VueTracé vueTracé = new VueTracé(this.getTracé(), this.getPanneauDessin().getCouleurForme());
		return vueTracé;
	}
	
	public void mousePressed(MouseEvent event){
		this.setDébut(new Point(event.getX(), event.getY()));
		this.setTracé(new Tracé(this.getDébut(), this.getDébut()));
	}
	
	public void mouseReleased(MouseEvent event){
		PanneauDessin pan = this.getPanneauDessin();
		pan.ajouterVueForme(this.créerVueForme());
		this.getPanneauDessin().setVueTemp(PanneauDessin.VUE_TEMP);
		this.getPanneauDessin().repaint();
	}
	
	public void mouseClicked(MouseEvent event){
		
	}
	
	public void mouseDragged(MouseEvent event){
		PanneauDessin pan = this.getPanneauDessin();
		Point finAux = new Point(event.getX(), event.getY());
		this.getTracé().ajouterLigneVers(finAux);
		this.setDébut(finAux);		

		pan.setVueTemp(this.créerVueForme());
		this.getPanneauDessin().repaint();
	}
	
	// ACCESSEURS
	
	public void setTracé(Tracé t){
		this.tracé = t;
	}
	
	public Tracé getTracé(){
		return this.tracé;
	}

}
