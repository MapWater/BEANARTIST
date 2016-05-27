/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import java.awt.event.MouseEvent;

/**
 * @author Cl�ment
 *
 */
public abstract class Outil
	implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener{
	// CONSTANTES DE CLASSE
	
	// ATTRIBUTS
	private PanneauDessin panneauDessin;
	private Point début;
	private Point fin;
	private Point débutDessin;
	private Point finDessin;
	
	// CONSTRUCTEURS
	public Outil(){
	}
	
	public Outil(PanneauDessin panneauDessin){
		this.setPanneauDessin(panneauDessin);
		this.associer(panneauDessin);
	}
	
	// AUTRES METHODES
	public void associer(PanneauDessin panneauDessin){
		if (this.getPanneauDessin().getOutilCourant() != null){
			this.libérer();
		}
		this.getPanneauDessin().setOutilCourant(this);
		this.getPanneauDessin().addMouseListener(this);
		this.getPanneauDessin().addMouseMotionListener(this);
	}
	
	private void libérer(){
		this.getPanneauDessin().removeMouseListener(getPanneauDessin().getOutilCourant());
		this.getPanneauDessin().removeMouseMotionListener(getPanneauDessin().getOutilCourant());
		this.getPanneauDessin().setOutilCourant(null);
	}
	
	public void setDébut(Point point){
		this.début = point;
	}
	
	public void setFin(Point point){
		this.fin = point;
	}
	
	public Point getDébut(){
		return this.début;
	}
	
	public Point getFin(){
		return this.fin;
	}
	
	public void setDébutDessin(Point point){
		this.débutDessin = point;
	}
	
	public void setFinDessin(Point point){
		this.finDessin = point;
	}
	
	public Point getDébutDessin(){
		return this.débutDessin;
	}
	
	public Point getFinDessin(){
		return this.finDessin;
	}
	
	public void mousePressed(MouseEvent event){
		this.setDébut(new Point(event.getX(), event.getY()));
	}
	
	public void mouseClicked(MouseEvent event){
		
	}
	
	public void mouseReleased(MouseEvent event){
		this.setFin(new Point(event.getX(), event.getY()));
	}
	
	public void mouseEntered(MouseEvent event){
		
	}
	
	public void mouseExited(MouseEvent event){
		
	}
	
	public void mouseDragged(MouseEvent event){
		
	}
	
	public void mouseMoved(MouseEvent event){
		
	}
	// ACCESSEURS
	
	public PanneauDessin getPanneauDessin(){
		return this.panneauDessin;
	}
	
	public void setPanneauDessin(PanneauDessin panneauDessin){
		this.panneauDessin = panneauDessin;
	}
	
}
