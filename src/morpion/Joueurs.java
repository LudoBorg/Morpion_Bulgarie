/**
 * Constructeur de joueurs 
 * Définition du nom et du signe des joueurs
 * 
 * @author LudovicB
 * @version 1.2
 */

package morpion;

import java.util.Scanner;

public class Joueurs {
	public String nom; //Public car doit être accessible dans une autre class
	public char signe;
	
//Pour générer méthode : Sélectionne la class Joueur puis Source puis Generate getters and setters
/**
 * Méthode getNom()
 * 
 * @return nom : Retourne le nom du joueur 
 */
	public String getNom() { 
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

/**
 * Méthode getSigne()
 *  
 * @return signe : Retourne le signe du joueur (X ou O)
 */
	public char getSigne() {
		return signe;
	}

	public void setSigne(char signe) {
		this.signe = signe;
	}

/**
 * Constructeur Joueurs
 * 
 * @param nom_j : Nom du joueur
 * @param signe_j : Signe du joueur (X ou O)
 */
	public Joueurs (String nom_j, char signe_j) {
		nom = nom_j;
		signe = signe_j;
	}

/**
 * Définition du nom et du signe des joueurs
 * 
 * Demande a chaque joueur son nom et le joueur 1 choisi son signe, le joueur 2 a un signe par défaut
 */	
	public static Joueurs Joueur1; //Utilisation du constructeur joueurs
	public static Joueurs Joueur2;
	
	public static void DefinitionNomSigneJoueurs() {
		Scanner sc_nom_j1 = new Scanner(System.in); //Pour récupérer le nom du joueur1 tapé au clavier
		System.out.println("Entrez le nom du joueur 1 : ");
		String nom_j1 = sc_nom_j1.nextLine();
		//System.out.println("Vous avez saisi : " + nom_j1);

		//Vérification du caractère du signe du joueur 1
		char signe_j1 = ' ';
		Scanner sc_signe_j1;
		do {
			sc_signe_j1 = new Scanner(System.in);
			System.out.println("Choisissez le signe du joueur 1 : (O ou X)");
			signe_j1 = sc_signe_j1.nextLine().charAt(0);
			//System.out.println("Vous avez saisi : " + signe_j1);
		} while ( !(signe_j1 == 'O' || signe_j1 == 'X')); //Tant qu'il est différent de O ou X on refait le do

		Joueur1 = new Joueurs(nom_j1, signe_j1); //Construction du joueur 1
		System.out.println("Joueur 1 : " + Joueur1.getNom() + ", Signe : " + Joueur1.getSigne()); //Utilisation de méthodes pour afficher le nom et le signe du joueur 1

		Scanner sc_nom_j2 = new Scanner(System.in);
		System.out.println("Entrez le nom du joueur 2 : ");
		String nom_j2 = sc_nom_j2.nextLine();
		//System.out.println("Vous avez saisi : " + nom_j2);

		char signe_j2 = ' ';

		switch(signe_j1) { //Attribue le signe non sélectionné au joueur 2
		case 'X':
			signe_j2 = 'O';
			//System.out.println(signe_j2);
			break;
		case 'O':
			signe_j2 = 'X';
			//System.out.println(signe_j2);
			break;
		}
		
		Joueur2 = new Joueurs(nom_j2, signe_j2); //Construction du joueur 2
		System.out.println("Joueur 2 : " + Joueur2.getNom() + ", Signe : " + Joueur2.getSigne()); //Utilisation de méthodes pour afficher le nom et le signe du joueur 2
	}
	
	public static void CreerJoueur1(String nom, boolean signe) {
		if(signe) {
			Joueur1 = new Joueurs(nom, 'O');
		} else {
			Joueur1 = new Joueurs(nom, 'X');
		}
	}
	
	public static void CreerJoueur2(String nom) {
		char SigneJ1 = Joueur1.getSigne();
		if(SigneJ1 == 'X') {
			Joueur2 = new Joueurs(nom, 'O');
		} else {
			Joueur2 = new Joueurs(nom, 'X');
		}
	}
}

