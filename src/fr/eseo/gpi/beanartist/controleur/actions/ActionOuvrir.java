package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import fr.eseo.gpi.beanartist.controleur.outils.OutilChoisirFond;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.filechooser.*;
import fr.eseo.gpi.beanartist.xml.LecteurXML;

public class ActionOuvrir extends AbstractAction implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static final String OUVRIR = "Ouvrir un dessin existant";
	private PanneauDessin panneauDessin;
	private JFileChooser fc;
	
	public ActionOuvrir(FenêtreBeAnArtist fen){
		super(OUVRIR);
		this.panneauDessin = fen.getPanneauDessin();
	}
	
	public void actionPerformed(ActionEvent e) {
		this.fc = new JFileChooser();
		//Handle open button action.
        int returnVal = fc.showOpenDialog(this.panneauDessin);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	try{
	        	File file = fc.getSelectedFile();
	        	String fileName = file.getName();
	        	LecteurXML lecteur = new LecteurXML();
	    		FenêtreBeAnArtist newFenêtre = new FenêtreBeAnArtist();
	    		List<VueForme> dessin = lecteur.lisDessin(fileName, newFenêtre);
	    		newFenêtre.getPanneauDessin().setVueFormes(dessin);
        	}catch(Exception exception){
                // if any error occurs
                System.out.println("Erreur lors de l'ouverture.");
             }
        } else {
            System.out.println("Open command cancelled by user.");
        }
	}
	
}
