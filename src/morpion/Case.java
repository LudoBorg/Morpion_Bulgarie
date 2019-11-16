/**
 * Constructeur de case, permet la génération de cases dans Plateau.java
 * 
 * @author LudovicB
 * @version 1.2
 */

package morpion;

public class Case {
	public int horizontal;
	public int vertical;
	public char etat;

/**
 * Méthode getHorizontal()
 * 
 * @return horizontal : Retourne la position horizontal de la case
 */
	public int getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(char horizontal) {
		this.horizontal = horizontal;
	}

/**
 * Méthode getVertical()
 * 
 * @return vertical : Retourne la position vertical de la case
 */
	public int getVertical() {
		return vertical;
	}

	public void setVertical(char vertical) {
		this.vertical = vertical;
	}

/**
 * Méthode getEtat()
 * 
 * @return etat : Retourne l'etat de la case (vide ou X ou O)
 */
	public char getEtat() {
		return etat;
	}

	public void setEtat(char etat) {
		this.etat = etat;
	}

/**
 * Constructeur Case
 * 
 * @param i : Position de la colonne ou se situe la case (0 ou 1 ou 2)
 * @param j : Position ligne ou se situe la case (0 ou 1 ou 2)
 * @param etat_c : Etat de la case (0 (vide) ou X ou O)
 */
	public Case (int i, int j, char etat_c) {
		horizontal = j;
		vertical = i;
		etat = etat_c;
	}
}

