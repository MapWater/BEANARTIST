package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;

public class CercleTest{
	public static void main(String args[]){
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);

		
		Cercle c1 = new Cercle( p1, 100);
		Cercle c2 = new Cercle(200);
		Cercle c3 = new Cercle(p2);
		Cercle c4 = new Cercle();
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());

	}
}
