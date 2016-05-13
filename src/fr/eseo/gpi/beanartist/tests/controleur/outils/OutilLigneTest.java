package fr.eseo.gpi.beanartist.tests.controleur.outils;

import java.awt.Color;
import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.vue.ui.*;

public class OutilLigneTest {

	public static void main(String[] args) {
		// Cr�er fen�tre � fond Jaune
		Fen�treBeAnArtist fen1 = new Fen�treBeAnArtist("Fen�tre 1", 800, 600, Color.yellow);
		// Changer la couleur courante de dessin du panneau d'�dition � rouge
		fen1.getPanneauDessin().setCouleurForme(Color.red);
		// Cr�er un contr�leur, instance de la classe OutilLigne
		OutilLigne outil = new OutilLigne(fen1.getPanneauDessin());
		// Associer cette instance au panneau d'�dition
		outil.associer(fen1.getPanneauDessin());
		System.out.println(outil.getPanneauDessin().toString());
		// Afficher la fen�tre
		
	}

}
