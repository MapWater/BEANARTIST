package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Carré;

public class CarréTest {

	public static void main(String[] args) {
		//Création des instances avec les différents constructeurs
		Carré carré1 = new Carré();
		Carré carré2 = new Carré(new Point(2, 4));
		Carré carré3 = new Carré(5);
		Carré carré4 = new Carré(4, 8, 3);
		Carré carré5 = new Carré(new Point(3, 7), 4);
		
		//Test de la méthode d'affichage pour chaque instance créée
		//On teste ainsi également les méthodes d'instances aire et périmètre
		System.out.println(carré1.toString());
		System.out.println(carré2.toString());
		System.out.println(carré3.toString());
		System.out.println(carré4.toString());
		System.out.println(carré5.toString());
		
		//Test des accesseurs en écriture
		carré1.setHauteur(4);
		carré2.setLargeur(3);
		carré1.setX(2);
		carré1.setY(8);
		System.out.println(carré1.toString());
		System.out.println(carré2.toString());
		
		//Test des accesseurs en lecture
		System.out.println(carré3.getHauteur()); //5
		System.out.println(carré3.getLargeur()); //5
		System.out.println(carré5.getX()); //3
		System.out.println(carré5.getY()); //7
		System.out.println(carré5.getMinX()); //3
		System.out.println(carré5.getMinY()); //7
		System.out.println(carré5.getMaxX()); //7
		System.out.println(carré5.getMaxY()); //11
		
		//Test des autres méthodes
		carré4.déplacerVers(2, 5);
		System.out.println(carré4.toString()); //(2, 5)
		carré5.déplacerDe(4, 7);
		System.out.println(carré5.toString()); //(7, 14)
		System.out.println(carré1.contient(3, 15)); //false
		System.out.println(carré1.contient(new Point(3, 7))); //false

	}

}