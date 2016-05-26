package fr.eseo.gpi.beanartist.xml;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.vue.geom.*;

/**
 * Un enregistreur XML est un processeur DOM responsable de l'enregistrement
 * d'un dessin au format XML défini par l'application.
 * 
 * Il utilise les méthodes héritées de la classe ProcesseurDOM pour créer un
 * document DOM et l'enregistrer dans un fichier XML, ainsi que les méthodes
 * d'écriture des entiers.
 * 
 * Les méthodes enregistreDessin et créeElémentXxxx devront être complétées. Des
 * méthodes utilitaires pourront venir compléter celles définies par la classe
 * ProcesseurDOM ; elles devront dans ce cas être OBLIGATOIREMENT définies en
 * "private" à la fin de la classe EnregistreurXML.
 *
 */
public class EnregistreurXML extends ProcesseurDOM {

	/**
	 * Lance le test d'enristrement (méthode teste) avec le fichier XML d'entrée
	 * nommé "S30-Dessin-in.xml" et le fichier XML de sortie nommé
	 * "S30-Dessin-out.xml".
	 * 
	 * Ce test MANUEL doit OBLIGATOIREMENT passer avant de commencer la gestion
	 * de l'enregistrement en SVG (classe EnregistreurSVG). Il est INDISPENSABLE
	 * de vérifier la conformité entre les fichiers d'entrée et de sortie. Il
	 * peut subsister des différentces normales entre ces deux fichiers (par
	 * exemple pour les valeurs par défaut telles que la couleur de remplissage
	 * des vues). De plus, l'affichage du fichier de sortie doit être conforme à
	 * ce qui est attendu.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		teste("S30-Dessin-in.xml", "S30-Dessin-out.xml");
	}

	/**
	 * Teste l'enregistrement du dessin dans un fichier XML. Le fichier XML
	 * d'entrée est préalablement lu, puis sauvagardé dans un fichier de sortie.
	 * Le fichier de sortie est ensuite chargé et visualisé par l'application.
	 * 
	 * @param nomFichierEntrée le nom du fichier XML d'entrée lu
	 * @param nomFichierSortie le nom du fichier XML de sortie écrit puis
	 *            affiché
	 * @throws FileNotFoundException si l'un des noms des fichiers n'est pas
	 *             valide
	 */
	public static void teste(String nomFichierEntrée, String nomFichierSortie) throws FileNotFoundException {
		LecteurXML lecteur = new LecteurXML();
		final List<VueForme> dessin = lecteur.lisDessin(nomFichierEntrée);
		EnregistreurXML enregistreur = new EnregistreurXML();
		enregistreur.enregistreDessin(nomFichierSortie, dessin);
		LecteurXML.teste(nomFichierSortie);
	}

	/**
	 * Enregistre le dessin donné dans un fichier.
	 * @param nomFichier le nom du fichier de sauvegarde
	 * @param dessin le dessin formé de la liste des vues des formes
	 * @throws FileNotFoundException si le nom du fichier n'est pas valide
	 */
	public void enregistreDessin(String nomFichier, List<VueForme> dessin) throws FileNotFoundException {
		créeDocumentXML("dessin");
		Element racine = getDocument().getDocumentElement();
		// Pour chaque vue du dessin, créer un élément DOM associé et l'ajouter
		// dans l'élément racine du document.
		Element auteur = getDocument().createElement("Auteur");
		racine.appendChild(auteur);
		Element zoneDeDessin = getDocument().createElement("ZoneDeDessin");
		racine.appendChild(zoneDeDessin);
		for (int i = 0 ; i < dessin.size() ; i++){
			Element élément = créeElémentVueForme(dessin.get(i));
			zoneDeDessin.appendChild(élément);
		}
		enregistreDocument(nomFichier);
	}

	/**
	 * Crée un élément DOM représentant la vue donnée d'une forme et retourne
	 * cet élément. Cette méthode invoque les méthodes créeElément<Forme> en
	 * fonction du type de la vuse.
	 * @param vueForme la vue d'une forme
	 * @return l'élément DOM représentant la vue d'une forme
	 */
	public Element créeElémentVueForme(VueForme vueForme) {
		Element élément;
		String nom = vueForme.getClass().getSimpleName();
		if (nom.equals("VueRectangle")) {
			élément = créeElémentRectangle(vueForme);
		}
		else if (nom.equals("VueCarré")) {
			élément = créeElémentCarré(vueForme);
		}
		else if (nom.equals("VueEllipse")) {
			élément = créeElémentEllipse(vueForme);
		}
		else if (nom.equals("VueCercle")) {
			élément = créeElémentCercle(vueForme);
		}
		else if (nom.equals("VueLigne")) {
			élément = créeElémentLigne(vueForme);
		}
		else if (nom.equals("VueTracé")) {
			élément = créeElémentTracé(vueForme);
		}
		else {
			throw new Error("Vue non gérée");
		}
		getDocument().getDocumentElement().appendChild(élément);
		return élément;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le rectangle donné.
	 * @param forme le rectangle
	 * @return élément DOM représentant le rectangle
	 */
	public Element créeElémentRectangle(VueForme vue) {
		Rectangle forme = (Rectangle)vue.getForme();
		Element élément = getDocument().createElement("Rectangle");
		écrisAttribut(élément, "largeur", forme.getLargeur());
		écrisAttribut(élément, "hauteur", forme.getHauteur());
		écrisAttribut(élément, "abscisse", forme.getMinX());
		écrisAttribut(élément, "ordonnee", forme.getMinY());
		écrisAttribut(élément, "rempli", vue.estRempli());
		écrisAttribut(élément, "r", vue.getCouleurLigne().getRed());
		écrisAttribut(élément, "g", vue.getCouleurLigne().getGreen());
		écrisAttribut(élément, "b", vue.getCouleurLigne().getBlue());
		return élément;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le carré donné.
	 * @param forme le carré
	 * @return élément DOM représentant le carré
	 */
	public Element créeElémentCarré(VueForme vue) {
		Carré forme = (Carré)vue.getForme();
		Element élément = getDocument().createElement("Carre");
		écrisAttribut(élément, "cote", (int)forme.getCote());
		écrisAttribut(élément, "abscisse", forme.getMinX());
		écrisAttribut(élément, "ordonnee", forme.getMinY());
		écrisAttribut(élément, "rempli", vue.estRempli());
		écrisAttribut(élément, "r", vue.getCouleurLigne().getRed());
		écrisAttribut(élément, "g", vue.getCouleurLigne().getGreen());
		écrisAttribut(élément, "b", vue.getCouleurLigne().getBlue());
		return élément;
	}
	

	/**
	 * Renvoie un nouvel élément DOM représentant l'ellipse donnée.
	 * @param forme l'ellipse
	 * @return élément DOM représentant l'ellipse
	 */
	public Element créeElémentEllipse(VueForme vue) {
		Ellipse forme = (Ellipse)vue.getForme();
		Element élément = getDocument().createElement("Ellipse");
		écrisAttribut(élément, "largeur", forme.getLargeur());
		écrisAttribut(élément, "hauteur", forme.getHauteur());
		écrisAttribut(élément, "abscisse", forme.getMinX());
		écrisAttribut(élément, "ordonnee", forme.getMinY());
		écrisAttribut(élément, "rempli", vue.estRempli());
		écrisAttribut(élément, "r", vue.getCouleurLigne().getRed());
		écrisAttribut(élément, "g", vue.getCouleurLigne().getGreen());
		écrisAttribut(élément, "b", vue.getCouleurLigne().getBlue());
		return élément;
	}
	

	/**
	 * Renvoie un nouvel élément DOM représentant le cercle donné.
	 * @param forme le cercle
	 * @return élément DOM représentant le cercle
	 */
	public Element créeElémentCercle(VueForme vue) {
		Cercle forme = (Cercle)vue.getForme();
		Element élément = getDocument().createElement("Cercle");
		écrisAttribut(élément, "cote", (int)forme.getHauteur());
		écrisAttribut(élément, "abscisse", forme.getMinX());
		écrisAttribut(élément, "ordonnee", forme.getMinY());
		écrisAttribut(élément, "rempli", vue.estRempli());
		écrisAttribut(élément, "r", vue.getCouleurLigne().getRed());
		écrisAttribut(élément, "g", vue.getCouleurLigne().getGreen());
		écrisAttribut(élément, "b", vue.getCouleurLigne().getBlue());
		return élément;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant la ligne donnée.
	 * @param forme la ligne
	 * @return élément DOM représentant la ligne
	 */
	public Element créeElémentLigne(VueForme vue) {
		Ligne forme = (Ligne)vue.getForme();
		Element élément = getDocument().createElement("Ligne");
		écrisAttribut(élément, "largeur", forme.getLargeur());
		écrisAttribut(élément, "hauteur", forme.getHauteur());
		écrisAttribut(élément, "abscisse", forme.getMinX());
		écrisAttribut(élément, "ordonnee", forme.getMinY());
		écrisAttribut(élément, "rempli", vue.estRempli());
		écrisAttribut(élément, "r", vue.getCouleurLigne().getRed());
		écrisAttribut(élément, "g", vue.getCouleurLigne().getGreen());
		écrisAttribut(élément, "b", vue.getCouleurLigne().getBlue());
		return élément;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le tracé donné.
	 * @param forme le tracé
	 * @return élément DOM représentant le tracé
	 */
	public Element créeElémentTracé(VueForme vue) {
		Element élément = getDocument().createElement("Trace");
		Element ligne;
		écrisAttribut(élément, "r", vue.getCouleurLigne().getRed());
		écrisAttribut(élément, "g", vue.getCouleurLigne().getGreen());
		écrisAttribut(élément, "b", vue.getCouleurLigne().getBlue());
		for(Ligne l : ((Tracé)vue.getForme()).getLignes()){
			ligne = getDocument().createElement("Ligne");
			écrisAttribut(ligne, "largeur", l.getLargeur());
			écrisAttribut(ligne, "hauteur", l.getHauteur());
			écrisAttribut(ligne, "abscisse", l.getMinX());
			écrisAttribut(ligne, "ordonnee", l.getMinY());
			écrisAttribut(ligne, "rempli", vue.estRempli());
			écrisAttribut(ligne, "r", vue.getCouleurLigne().getRed());
			écrisAttribut(ligne, "g", vue.getCouleurLigne().getGreen());
			écrisAttribut(ligne, "b", vue.getCouleurLigne().getBlue());
			élément.appendChild(ligne);
		}
		
		return élément;
	}

}
