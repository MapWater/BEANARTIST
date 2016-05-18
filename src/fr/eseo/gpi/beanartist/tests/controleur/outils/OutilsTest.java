package fr.eseo.gpi.beanartist.tests.controleur.outils;

import java.awt.Color;
import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.vue.ui.*;

public class OutilsTest {

	public static void main(String[] args) {
		// Crêer fenêtre ê fond Jaune
		FenêtreBeAnArtist fen1 = new FenêtreBeAnArtist("Fenêtre 1", 800, 600, Color.yellow);
		// Changer la couleur courante de dessin du panneau d'êdition ê rouge
		fen1.getPanneauDessin().setCouleurForme(Color.red);
		// Crêer un contrêleur, instance de la classe OutilLigne
		OutilLigne outil = new OutilLigne(fen1.getPanneauDessin());
		// Associer cette instance au panneau d'êdition
		outil.associer(fen1.getPanneauDessin());
		System.out.println(outil.getPanneauDessin().toString());
		// Afficher la fenêtre
		
	}

}
