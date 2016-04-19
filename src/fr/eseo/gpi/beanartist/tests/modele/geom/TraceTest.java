//package fr.eseo.gpi.beanartist.tests.modele.geom;
//
//import fr.eseo.gpi.beanartist.modele.geom.Point;
//import fr.eseo.gpi.beanartist.modele.geom.Ligne;
//
//public class TraceTest{
//	public static void main(String args[]){
//		Point p1 = new Point();
//		Point p2 = new Point(200, 200);
//		Point p3 = new Point(300, 300);
//		Point p4 = new Point(404, 404);
//		
//		Ligne l1 = new Ligne(p2, 10, 0);
//		Ligne l2 = new Ligne(p1, 0, 10);
//		Ligne l3 = new Ligne(p1, 3, 4);
//		
//		System.out.println("\n-------------------- Initialisation des lignes --------------------");
//		System.out.println(l1.toString());
//		System.out.println(l2.toString());
//		System.out.println(l3.toString());
//		
//		System.out.println("\n-------------------- Déplacement de P1 par coordonnées --------------------");
//		l1.deplacerP1Vers(p1);
//		System.out.println(l1.toString());
//		
//		System.out.println("\n-------------------- Déplacement de P2 par coordonnées --------------------");
//		l1.deplacerP2Vers(p3);
//		System.out.println(l1.toString());
//		
//		System.out.println("\n-------------------- Déplacement de P1 par vecteur --------------------");
//		l1.deplacerP1De(10, 0);
//		System.out.println(l1.toString());
//		
//		System.out.println("\n-------------------- Déplacement de P2 par vecteur --------------------");
//		l1.deplacerP2De(-280, -300);
//		System.out.println(l1.toString());
//		
//
//	}
//}