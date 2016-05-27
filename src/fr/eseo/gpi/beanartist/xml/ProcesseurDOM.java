package fr.eseo.gpi.beanartist.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSSerializer;

/**
 * Un processeur DOM permet de créer, charger et enregistrer des documents XML
 * en utilisant le standard DOM et son implémentation dans l'API Java. Il permet
 * également de manipuler les valeurs entières stockés dans des attributs ou/et
 * des éléments simples (feuilles de l'arbres DOM).
 * 
 * Cette classe ne doit PAS être modifiée.
 */
public abstract class ProcesseurDOM {

	/**
	 * L'implémentation de DOM Core.
	 */
	private DOMImplementation dom;

	/**
	 * L'implémentation de DOM Load & Save.
	 */
	private DOMImplementationLS domLS;

	/**
	 * Le document nouvellement créé, chargé ou/et enregistré.
	 */
	private Document document;

	/**
	 * Construit les instances représentant les implémentations de DOM Core et
	 * DOM Load & Save
	 */
	protected ProcesseurDOM() {
		try {
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			dom = registry.getDOMImplementation("XML 1.0");
			domLS = (DOMImplementationLS) registry.getDOMImplementation("LS");
		}
		catch (ClassNotFoundException e) {
		}
		catch (InstantiationException e) {
		}
		catch (IllegalAccessException e) {
		}
		catch (ClassCastException e) {
		}
	}

	/**
	 * Renvoie le document créé, chargé ou/et enregistré par l'une des méthodes
	 * associées.
	 * @return Le document créé, chargé ou/et enregistré.
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * Crée un nouveau document XML dont le nom de l'élément racine est donné.
	 * @param nomElementRacine le nom de l'élément racine
	 */
	public void créeDocumentXML(String nomElementRacine) {
		document = dom.createDocument(null, nomElementRacine, null);
	}

	/**
	 * Crée un nouveau document SVG.
	 */
	public void créeDocumentSVG() {
		document = dom.createDocument("http://www.w3.org/2000/svg", "svg", null);
	}

	/**
	 * Charge un nouveau document XML dont le nom du fichier est donné.
	 * @param nomFichier le nom du fichier XML (peut inclure le chemin complet)
	 * @throws FileNotFoundException si le fichier n'est pas trouvé ou
	 *             accessible
	 */
	public void chargeDocument(String nomFichier) throws FileNotFoundException {
		LSParser parser = domLS.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
		LSInput input = domLS.createLSInput();
		input.setByteStream(new FileInputStream(nomFichier));
		document = parser.parse(input);
	}

	/**
	 * Enregistre le document précédemment créé ou chargé dans le fichier donné.
	 * @param nomFichier le nom du fichier de sauvegarde
	 * @throws FileNotFoundException si le fichier ne peut être sauvegardé
	 *             (accès au répertoire non autorisé par exemple)
	 */
	public void enregistreDocument(String nomFichier) throws FileNotFoundException {
		LSSerializer writer = domLS.createLSSerializer();
		writer.getDomConfig().setParameter("xml-declaration", true);
		writer.getDomConfig().setParameter("format-pretty-print", true);
		LSOutput output = domLS.createLSOutput();
		output.setByteStream(new FileOutputStream(nomFichier));
		writer.write(document, output);
	}

	/**
	 * Renvoie la valeur entière stockée dans l'attribut donné.
	 * @param élément l'élément contenant l'attribut considéré
	 * @param nomAttribut le nom de l'attribut
	 * @return la valeur entière stockée dans l'attribut
	 * @throws NumberFormatException si la valeur stockée n'est pas un entier
	 */
	public int lisAttribut(Element élément, String nomAttribut) {
		return Integer.valueOf(élément.getAttribute(nomAttribut));
	}

	/**
	 * Ecris une valeur entière dans un attribut.
	 * @param élément l'élément contenant l'attribut considéré
	 * @param nomAttribut le nom de l'attribut
	 * @param valeurAttribut la valeur entière à stocker dans l'attribut
	 */
	public void écrisAttribut(Element élément, String nomAttribut, int valeurAttribut) {
		élément.setAttribute(nomAttribut, String.valueOf(valeurAttribut));
	}
	
	public void écrisAttribut(Element élément, String nomAttribut, boolean valeurAttribut) {
		élément.setAttribute(nomAttribut, String.valueOf(valeurAttribut));
	}
	
	public void écrisAttribut(Element élément, String nomAttribut, String valeurAttribut) {
		élément.setAttribute(nomAttribut, String.valueOf(valeurAttribut));
	}
	
	public void écrisAttributsCouleur(Element élément, String couleur, boolean estRempli){
		String style = "";
		if (estRempli){
			style += "fill:"+couleur+";stroke-width:1;";
		} else {
			style += "fill:none;stroke-width:1;";
		}
		style += "stroke:"+couleur;
		écrisAttribut(élément, "style", style);
	}

	/**
	 * Renvoie la valeur entière stockée dans l'élément simple donné. Soit
	 * l'élément e suivant : <a> <b>123</b> <c>456</c> </a>. L'invocation de
	 * lisElementSimple(e, "b") renvoie l'entier 123.
	 * @param élémentParent l'élément parent de l'élément simple considéré
	 * @param nomElementFils le nom de l'élément simple
	 * @return la valeur entière stockée dans l'élément simple
	 * @throws NumberFormatException si la valeur stockée n'est pas un entier
	 */
	public int lisElementSimple(Element élémentParent, String nomElementFils) {
		Node premier = élémentParent.getElementsByTagName(nomElementFils).item(0);
		String valeur = premier.getChildNodes().item(0).getNodeValue();
		return Integer.valueOf(valeur);
	}

	/**
	 * Ecris une valeur entière donnée dans un élément simple. Soit l'élément e
	 * suivant : <a/> L'invocation de ecrisElementSimple(e, "b", 123) modifie e
	 * comme suit : <a> <b>123</b> </a> .
	 * @param élémentParent l'élément parent de l'élément simple considéré
	 * @param nomElémentSimple le nom de l'élément simple
	 * @param valeurElémentSimple la valeur entière à stocker dans l'élément
	 *            simple
	 */
	public void écrisElementSimple(Element élémentParent, String nomElémentSimple, int valeurElémentSimple) {
		Text texte = getDocument().createTextNode(String.valueOf(valeurElémentSimple));
		Element élément = getDocument().createElement(nomElémentSimple);
		élément.appendChild(texte);
		élémentParent.appendChild(élément);
	}

	/**
	 * Décompose une chaîne de caractères constituée d'entiers séparés par un ou
	 * plusieur séparateurs en un tableau d'entiers. Soit c la chaîne
	 * "1,2 3,4 5,6". L'invocation de lisMotifs(c, " ,") renvoie le tableau
	 * {1,2,3,4,5,6}.
	 * @param chaîne La chaîne à décomposer
	 * @param séparateurs Les caractères possibles servant de séparateurs
	 * @return le tableau des entiers stockés dans la chaîne
	 * @throws NumberFormatException si l'une des valeurs stockées entre les
	 *             séparateurs n'est pas un entier
	 */
	public int[] lisMotifs(String chaîne, String séparateurs) {
		StringTokenizer tokenizer = new StringTokenizer(chaîne, séparateurs);
		int[] motifs = new int[tokenizer.countTokens()];
		for (int i = 0; i < motifs.length; i++) {
			motifs[i] = Integer.valueOf(tokenizer.nextToken());
		}
		return motifs;
	}
}
