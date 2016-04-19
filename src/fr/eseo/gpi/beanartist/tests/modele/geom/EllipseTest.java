package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;

public class EllipseTest{
	public static void main(String args[]){
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);

		
		Ellipse e1 = new Ellipse( p1, 100,10);
		Ellipse e2 = new Ellipse(200,200);
		Ellipse e3 = new Ellipse(p2);
		Ellipse e4 = new Ellipse();
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());

	}
}
