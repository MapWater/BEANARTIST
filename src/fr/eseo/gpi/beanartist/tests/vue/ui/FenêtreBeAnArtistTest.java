package fr.eseo.gpi.beanartist.tests.vue.ui;

import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

import fr.eseo.gpi.beanartist.vue.geom.*;
import fr.eseo.gpi.beanartist.modele.geom.*;

public class FenêtreBeAnArtistTest {

	public static void main(String args[]){
		FenêtreBeAnArtist fen1 = new FenêtreBeAnArtist("Fen�tre 1", 800, 600);
		PanneauDessin pan1 = fen1.getPanneauDessin();
		
		Rectangle rectRempli1 = new Rectangle(50,200, 300, 200);
		Rectangle rectVide1 = new Rectangle(0,0, 10, 50);
		Carré carréRempli1 = new Carré(400,400,125);
		Carré carréRempli2 = new Carré(400,400,25);
		Ellipse ellipseRemplie1 = new Ellipse(25,25,75,10);
		Ellipse ellipseVide1 = new Ellipse(50,50,100,50);
		Cercle cercleRempli1 = new Cercle(50,50,50);
		Ligne ligne1 = new Ligne(100,100,300,0);
		Ligne ligne2 = new Ligne(100,100,300,-110);
		Ligne point1 = new Ligne(100,100,0,0);
		Tracé tracé1 = new Tracé(new Point(40,400), new Point(50,500));
		tracé1.ajouterLigneVers(new Point(300,400));
		tracé1.ajouterLigneVers(new Point(600,350));
		pan1.ajouterVueForme(new VueRectangle(rectRempli1, Color.blue, true));
		pan1.ajouterVueForme(new VueRectangle(rectVide1, Color.red, false));
		pan1.ajouterVueForme(new VueCarré(carréRempli1, Color.pink, true));
		pan1.ajouterVueForme(new VueCarré(carréRempli2, Color.red, true));
		pan1.ajouterVueForme(new VueCercle(cercleRempli1, Color.black, true));
		pan1.ajouterVueForme(new VueEllipse(ellipseRemplie1, Color.green, true));
		pan1.ajouterVueForme(new VueEllipse(ellipseVide1, Color.cyan, false));
		pan1.ajouterVueForme(new VueLigne(ligne1, Color.yellow));
		pan1.ajouterVueForme(new VueLigne(ligne2, Color.yellow));
		pan1.ajouterVueForme(new VueLigne(point1, Color.black));
		pan1.ajouterVueForme(new VueTracé(tracé1, Color.black));
	}
	
}
