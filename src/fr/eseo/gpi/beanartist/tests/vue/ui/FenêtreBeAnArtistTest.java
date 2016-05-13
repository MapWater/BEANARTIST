package fr.eseo.gpi.beanartist.tests.vue.ui;

import fr.eseo.gpi.beanartist.vue.ui.Fen�treBeAnArtist;
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

public class Fen�treBeAnArtistTest {

	public static void main(String args[]){
		Fen�treBeAnArtist fen1 = new Fen�treBeAnArtist("Fen�tre 1", 800, 600);
		PanneauDessin pan1 = fen1.getPanneauDessin();
		
		Rectangle rectRempli1 = new Rectangle(50,200, 300, 200);
		Rectangle rectVide1 = new Rectangle(0,0, 10, 50);
		Carr� carr�Rempli1 = new Carr�(400,400,125);
		Carr� carr�Rempli2 = new Carr�(400,400,25);
		Ellipse ellipseRemplie1 = new Ellipse(25,25,75,10);
		Ellipse ellipseVide1 = new Ellipse(50,50,100,50);
		Cercle cercleRempli1 = new Cercle(50,50,50);
		Ligne ligne1 = new Ligne(100,100,300,0);
		Ligne ligne2 = new Ligne(100,100,300,-110);
		Ligne point1 = new Ligne(100,100,0,0);
		Trac� trac�1 = new Trac�(new Point(40,400), new Point(50,500));
		trac�1.ajouterLigneVers(new Point(300,400));
		trac�1.ajouterLigneVers(new Point(600,350));
		pan1.ajouterVueForme(new VueRectangle(rectRempli1, Color.blue, true));
		pan1.ajouterVueForme(new VueRectangle(rectVide1, Color.red, false));
		pan1.ajouterVueForme(new VueCarr�(carr�Rempli1, Color.pink, true));
		pan1.ajouterVueForme(new VueCarr�(carr�Rempli2, Color.red, true));
		pan1.ajouterVueForme(new VueCercle(cercleRempli1, Color.black, true));
		pan1.ajouterVueForme(new VueEllipse(ellipseRemplie1, Color.green, true));
		pan1.ajouterVueForme(new VueEllipse(ellipseVide1, Color.cyan, false));
		pan1.ajouterVueForme(new VueLigne(ligne1, Color.yellow));
		pan1.ajouterVueForme(new VueLigne(ligne2, Color.yellow));
		pan1.ajouterVueForme(new VueLigne(point1, Color.black));
		pan1.ajouterVueForme(new VueTrac�(trac�1, Color.black));
	}
	
}
