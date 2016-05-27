package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import fr.eseo.gpi.beanartist.controleur.outils.OutilChoisirFond;
import fr.eseo.gpi.beanartist.vue.ui.*;
import fr.eseo.gpi.beanartist.xml.EnregistreurSVG;

public class ActionExporter extends AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String EXPORTER = "Exporter le dessin courant au format svg";
	private PanneauDessin panneauDessin;
	private JFileChooser fc;

	public ActionExporter(FenêtreBeAnArtist fen){
		super(EXPORTER);
		this.panneauDessin = fen.getPanneauDessin();
	}
	
	public void actionPerformed(ActionEvent e) {
		this.fc = new JFileChooser();
		//Handle save button action.
        int returnVal = fc.showSaveDialog(this.panneauDessin);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	try{
	        	File file = fc.getSelectedFile();
	        	String fileName = file.getName();
	        	EnregistreurSVG enregistreur = new EnregistreurSVG();
	        	enregistreur.enregistreDessin(fileName, this.panneauDessin.getVueFormes());
        	}catch(Exception exception){
                // if any error occurs
                System.out.println("Erreur lors de l'enregistrement.");
             }
        } else {
            System.out.println("Open command cancelled by user.");
        }
	}
	
}
