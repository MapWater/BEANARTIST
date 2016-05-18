package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Forme;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;


public class OutilSélection extends Outil {

	private Forme formeSélectionnée;

	public OutilSélection(PanneauDessin panneau) {
		super(panneau);
	}
	
	public Forme getformeSélectionnée(){
		return this.formeSélectionnée;
	}
	
	public void setformeSélectionnée(Forme f){
		this.formeSélectionnée = f;
	}
	
	public void mouseDragged(MouseEvent event){
		this.setFin(new Point(event.getX(),event.getY()));
		this.getformeSélectionnée().déplacerDe(this.getFin().getX()-this.getDébut().getX(),
				this.getFin().getY()-this.getDébut().getY());
		this.getPanneauDessin().repaint();
		this.setDébut(new Point(event.getX(),event.getY()));
		
	}
	
	public void mouseClicked(MouseEvent event){
		super.mouseClicked(event);
	}
	
	public void mousePressed(MouseEvent event){
		Forme f = new Carré(0,0,0);
		for(int k =0;k<this.getPanneauDessin().getVueFormes().size();k++){
			if (this.getPanneauDessin().getVueFormes().get(k).getForme()
					.contient(event.getX(),event.getY())){
				f =this.getPanneauDessin().getVueFormes().get(k).getForme();
			}
		}
		this.setformeSélectionnée(f);
		this.setDébut(new Point(event.getX(),event.getY()));
		System.out.println(f);
	}

}
