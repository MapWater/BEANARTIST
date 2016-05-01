package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;

public class TracéTest{
	public static void main(String args[]){
		Point p1 = new Point();
		Point p2 = new Point(4, 4);
		Point p3 = new Point(8, 4);
		Point p4 = new Point(-400, -400);
		Point p5 = new Point(0, -10);
		Point p6 = new Point(10,10);
		
		Ligne l1 = new Ligne(p2, 10, 0);
		Ligne l2 = new Ligne(p1, 0, 10);
		Ligne l3 = new Ligne(p1, 3, 4);
		Ligne l4 = new Ligne(p1, 4, 5);
		
		Tracé t1 = new Tracé(p1, p2);
		System.out.println(t1.getLigne(0).toString());
		t1.ajouterLigneVers(p3);
		t1.ajouterLigneVers(p5);
		System.out.println(t1.contient(2,2));
		System.out.println(t1.getDernLigne(0).toString());
		System.out.println(t1.toString());
		
		System.out.println("");
		
		Tracé t2 = new Tracé(p1, p2);
		t2.ajouterLigneVers(p6);
		System.out.println(t2.getLigne(0).toString());
		System.out.println(t2.toString());
		t2.setLargeur(3);
		t2.setHauteur(3);
		System.out.println(t2.getLigne(0).toString());
		System.out.println(t2.toString());

	}
}