package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;

public class RectangleTest{
	public static void main(String args[]){
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);

		
		Rectangle r1 = new Rectangle(p1, 100,10);
		Rectangle r2 = new Rectangle(200,200);
		Rectangle r3 = new Rectangle(p2);
		Rectangle r4 = new Rectangle();
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		
		System.out.println(r1.getPosition().getX());
		System.out.println(r2.getPosition().getX());
		System.out.println(r3.getPosition().getX());
		System.out.println(r4.getPosition().getX());

	}
}
