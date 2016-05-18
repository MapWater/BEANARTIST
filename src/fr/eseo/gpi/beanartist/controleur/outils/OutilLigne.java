/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Point;

import java.awt.Color;
import java.awt.event.MouseEvent;



/**
 * @author Cl�ment
 *
 */
public class OutilLigne extends OutilForme {

	public OutilLigne() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	/**
	 * @param panneauDessin
	 */
	public OutilLigne(PanneauDessin panneauDessin) {
		super(panneauDessin);
		// TODO Auto-generated constructor stub
	}

	public void mousePressed(MouseEvent event){
		this.setDébut(new Point(event.getX(), event.getY()));
//		System.out.println("Click�!");
	}
	
	public void mouseClicked(MouseEvent event){
		
	} 
	
	public void mouseReleased(MouseEvent event){
		PanneauDessin pan = this.getPanneauDessin();
		// D�tection cas Abscisse/Ordonn�e n�gative :
		Point débutAux = new Point(this.getDébut());
		Point finAux = new Point(event.getX(), event.getY());
		this.setDébutDessin(débutAux);
		this.setFinDessin(finAux);
		pan.ajouterVueForme(this.créerVueForme());
//		System.out.println("Relach�!");
//		System.out.println(pan.getVueFormes().get(0).toString());
		this.getPanneauDessin().setVueTemp(PanneauDessin.VUE_TEMP);
		this.getPanneauDessin().repaint();
	}
	
	public void mouseDragged(MouseEvent event){
//		System.out.println("Dragged");
		PanneauDessin pan = this.getPanneauDessin();
		Point débutAux = new Point(this.getDébut());
		Point finAux = new Point(event.getX(), event.getY());
		this.setDébutDessin(débutAux);
		this.setFinDessin(finAux);
		pan.setVueTemp(this.créerVueForme());
		this.getPanneauDessin().repaint();
	}
	
	
	/* (non-Javadoc)
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#cr�erVueForme()
	 */
	@Override
	protected VueForme créerVueForme() {
		Ligne ligne = new Ligne(this.getDébutDessin(), this.getFinDessin());
//		VueLigne vueLigne = new VueLigne(ligne, couleurLigne);
		VueLigne vueLigne = new VueLigne(ligne, this.getPanneauDessin().getCouleurForme());
		return vueLigne;
	}

}
