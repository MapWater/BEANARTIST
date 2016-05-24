package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		//Création des instances avec les différents constructeurs
		Rectangle rectangle1 = new Rectangle();
		Rectangle rectangle2 = new Rectangle (new Point());
		Rectangle rectangle3 = new Rectangle (2, 7);
		Rectangle rectangle4 = new Rectangle (4, 8, 10, 3);
		Rectangle rectangle5 = new Rectangle (new Point(3, 9), 23, 19);
		
		//Test de la méthode d'affichage pour chaque instance créée
		//On teste ainsi également les méthodes d'instances aire et périmètre
		System.out.println(rectangle1.toString());
		System.out.println(rectangle2.toString());
		System.out.println(rectangle3.toString());
		System.out.println(rectangle4.toString());
		System.out.println(rectangle5.toString());
		
		//Test des accesseurs en écriture
		rectangle1.setHauteur(4);
		rectangle1.setLargeur(3);
		rectangle1.setX(2);
		rectangle1.setY(8);
		System.out.println(rectangle1.toString());
		
		//Test des accesseurs en lecture
		System.out.println(rectangle3.getHauteur()); //7
		System.out.println(rectangle3.getLargeur()); //2
		System.out.println(rectangle5.getX()); //3
		System.out.println(rectangle5.getY()); //9
		System.out.println(rectangle5.getMinX()); //3
		System.out.println(rectangle5.getMinY()); //9
		System.out.println(rectangle5.getMaxX()); //26
		System.out.println(rectangle5.getMaxY()); //28
		
		//Test des autres méthodes
		rectangle4.déplacerVers(2, 5);
		System.out.println(rectangle4.toString()); //(2, 5)
		rectangle5.déplacerDe(4, 7);
		System.out.println(rectangle5.toString()); //(7, 16)
		System.out.println(rectangle1.contient(4, 11)); //true
		System.out.println(rectangle1.contient(new Point(3, 11))); //true
		
	}

}
