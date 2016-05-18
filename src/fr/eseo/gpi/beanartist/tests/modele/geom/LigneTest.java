package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;

public class LigneTest{
	public static void main(String args[]){
		Point p1 = new Point();
		Point p2 = new Point(200, 200);
		Point p3 = new Point(300, 300);
		
		Ligne l1 = new Ligne(p2, 10, 0);
		Ligne l2 = new Ligne(0, 10);
		Ligne l3 = new Ligne(10,10, 60,50);
		Ligne l4 = new Ligne();
		Ligne l5 = new Ligne(p3, p1);
		Ligne l6 = new Ligne(p2);
		
		System.out.println("\n-------------------- Initialisation des lignes --------------------");
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		System.out.println(l3.toString());
		System.out.println(l4.toString());
		System.out.println(l5.toString());
		System.out.println(l6.toString());

		
		System.out.println("\n-------------------- Déplacement de P1 par coordonnées --------------------");
		l1.deplacerP1Vers(p1);
		System.out.println(l1.toString());
		
		System.out.println("\n-------------------- Déplacement de P2 par coordonnées --------------------");
		l1.deplacerP2Vers(p3);
		System.out.println(l1.toString());
		
		System.out.println("\n-------------------- Déplacement de P1 par vecteur --------------------");
		l1.deplacerP1De(10, 0);
		System.out.println(l1.toString());
		
		System.out.println("\n-------------------- Déplacement de P2 par vecteur --------------------");
		l1.deplacerP2De(-280, -300);
		System.out.println(l1.toString());
		
		System.out.println("\n-------------------- CONTIENT --------------------");
		System.out.println(l3.contient(30,26));
		System.out.println(l3.contient(new Point(20,26)));
		System.out.println("");
		
		System.out.println(l3.getMinX());
		System.out.println(l3.getMaxX());
		System.out.println(l3.getMinY());
		System.out.println(l3.getMaxY());
	}
}