package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class ActionModeRemplissage extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	public static final String NOM_ACTION_REMPLI = "rempli";
	public static final String NOM_ACTION_CONTOUR = "contour";
	private PanneauDessin panneauDessin;	
	
	public ActionModeRemplissage(PanneauDessin p){
		super();
		this.panneauDessin = p;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("rempli")){
			this.panneauDessin.setModeRemplissage(true);
		}else{
			this.panneauDessin.setModeRemplissage(false);
		}
	}
}
