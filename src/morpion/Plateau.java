/**
 * @author LudovicB
 * @version 1.1
 * 
 */

package morpion;

import java.util.*;

public class Plateau {

	private static Case[][] l_tabCases = new Case[3][3];
	
	private static String gagnant = null;
	
//	public static void main (String [] args) {
//		Plateau.ConstructionGrille();
//	DemandeCaseUtilisateur();
//
//	}
	
/**
 * Méthode qui constuit un tableau de 3X3
 * 	  
 */	
	public static void ConstructionGrille() {
		//Parcourt par ligne et initialisation de toutes les cases vides
		for(int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				l_tabCases[i][j] = new Case(i,j,' ');		
				//System.out.println("Case "+(i*3+j)+": x="+j+" y="+i);
			}
		}
	}
	
/**
 * Méthode afficheGrille() dans la console
 * 
 * Affiche la grille du jeu 
 */
	private static void afficheGrille() {
		//Affichage de la grille 3X3	
		int i;		// Nombre de lignes
		int j;		// Nombre d'éléments par ligne
		int col; 	// Axe des abscisses
		
		System.out.println(""); //Sauter une ligne			
		System.out.printf("      ");
		//Affichage du numéro de colonne :
		for (col=0; col<3; col++) {
			System.out.print("  "+(col+1)+" ");
		}
		System.out.println("");
		System.out.println("	_   _   _");
		
		//Initialisation du compteur:
		i=0;
		
		//Affichage du tableau à 2 dimensions :
		while (i < 3) {
		  j = 0;	  
		  //Affichage du nombre de lignes :
		  System.out.print("   "+(i+1)+"  | ");
		  while(j < 3) {
		    System.out.print(l_tabCases[i][j].getEtat());
		    System.out.print(" | ");
		    j++;
		  }
		  //Retour à la ligne pour chaque ligne du tableau :
		  System.out.println("");
		  i++;
		}
		System.out.println("	_   _   _");
		System.out.println("");
	}
	
/**
 * Méthode DemandeCaseUtilisateur() dans la console
 * 
 * L'état de la case change seulement si elle est vide
 */
	public static void DemandeCaseUtilisateur() {
		afficheGrille();
		
			int coordonnee_x_j1 = 0;
			int coordonnee_y_j1 = 0;
			int coordonnee_x_j2 = 0;
			int coordonnee_y_j2 = 0;
			
			//bool fin de partie
			boolean game_over = true;
			
			do { //partie en cours
				
				boolean case_occupee_tour_j1 = false;
				
				if(game_over) {
				do {
//					try {
					// Demande au joueur 1 une case
					Scanner case_choisie_j1 = new Scanner(System.in);
					System.out.println(Joueurs.Joueur1.getNom() + ", choisissez une case en donnant ses coordonnées (numéro de la colonne puis numero de la ligne) :");
					String case_j1 = case_choisie_j1.nextLine();

					String cases_j1[] = case_j1.split(","); // Sépare les membres du string en plusieurs string (entre chaque virgule)
					coordonnee_x_j1 = Integer.parseInt(cases_j1[0])-1; // Transformation de string en int de la coordonnée x (-1 car tableau)
					coordonnee_y_j1 = Integer.parseInt(cases_j1[1])-1;
					
					// Si la case est vide, on change l'etat de la case, on met le booleen en false pour sortir de la boucle
					if(l_tabCases[coordonnee_y_j1][coordonnee_x_j1].getEtat() == ' ') {
					l_tabCases[coordonnee_y_j1][coordonnee_x_j1].setEtat(Joueurs.Joueur1.getSigne());
					case_occupee_tour_j1 = false;
					}
					else {
						System.out.println("Case occupée...");
						case_occupee_tour_j1 = true;
					}
					} while (case_occupee_tour_j1 == true);
					game_over = VerifPartieTerminee_J1(coordonnee_y_j1,coordonnee_x_j1);
					}
					
//					catch(ArrayIndexOutOfBoundsException ex) {
//						System.out.println("La case n'existe pas..." );
//						    // traitement à faire dans ce cas
//					}

				

				afficheGrille();
				
				boolean case_occupee_tour_j2 = false;
				
				if(game_over) {
				do {
				// Demande au joueur 2 une case
				Scanner case_choisie_j2 = new Scanner(System.in);
				System.out.println(Joueurs.Joueur2.getNom() + ", choisissez une case en donnant ses coordonnées (numéro de la colonne puis numero de la ligne) :");
				String case_j2 = case_choisie_j2.nextLine();
				
				String cases_j2[] = case_j2.split(","); // Sépare les membres du string en plusieurs string (entre chaque virgule)
				coordonnee_x_j2 = Integer.parseInt(cases_j2[0])-1; // Transformation de string en int de la coordonnée x (-1 car tableau)
				coordonnee_y_j2 = Integer.parseInt(cases_j2[1])-1;
				
				// Si la case est vide, on change l'etat de la case, on met le booleen en false pour sortir de la boucle
				if(l_tabCases[coordonnee_y_j2][coordonnee_x_j2].getEtat() == ' ') {
				l_tabCases[coordonnee_y_j2][coordonnee_x_j2].setEtat(Joueurs.Joueur2.getSigne());
				case_occupee_tour_j2 = false;
				}
				else {
					System.out.println("Case occupée...");
					case_occupee_tour_j2 = true;
				}
				} while (case_occupee_tour_j2 == true);
				game_over = VerifPartieTerminee_J2(coordonnee_y_j2, coordonnee_x_j2);
				}
				
				afficheGrille();
			} while(game_over); //Fin du jeu
			System.out.println(gagnant + " a gagné");

			

			
//			sc_nom_j1.close();
//			sc_signe_j1.close();
//			sc_nom_j2.close();
//			case_choisie_j1.close();
//			case_choisie_j2.close();			
			
		}
	
/**
 * Méthode VerifPartieTerminee() dans la console
 * 
 * Vérification du signe des cases adjacentes à la case donnée par le joueur 1
 * Vérification du signe des diagonales
 * 
 * @param coordonnee_x_j1 
 * @param coordonnee_y_j1 
 * @return 
 */
	public static boolean VerifPartieTerminee_J1(int coordonnee_y_j1, int coordonnee_x_j1) {
		// Vérification si partie terminée verticalement
		if(l_tabCases[coordonnee_y_j1][0].getEtat() == Joueurs.Joueur1.getSigne() && l_tabCases[coordonnee_y_j1][1].getEtat() == Joueurs.Joueur1.getSigne() && l_tabCases[coordonnee_y_j1][2].getEtat() == Joueurs.Joueur1.getSigne()) {
			gagnant = Joueurs.Joueur1.getNom();
			return false;
		}
		// Vérification si partie terminée horizontalement
		if(l_tabCases[0][coordonnee_x_j1].getEtat() == Joueurs.Joueur1.getSigne() && l_tabCases[1][coordonnee_x_j1].getEtat() == Joueurs.Joueur1.getSigne() && l_tabCases[2][coordonnee_x_j1].getEtat() == Joueurs.Joueur1.getSigne()) {
			gagnant = Joueurs.Joueur1.getNom();
			return false;
		}
		// Vérification si partie terminée diagonalement
		if(l_tabCases[0][0].getEtat() == Joueurs.Joueur1.getSigne() && l_tabCases[1][1].getEtat() == Joueurs.Joueur1.getSigne() && l_tabCases[2][2].getEtat() == Joueurs.Joueur1.getSigne()) {
			gagnant = Joueurs.Joueur1.getNom();
			return false;
		}
		// Vérification si partie terminée diagonalement
		if(l_tabCases[2][0].getEtat() == Joueurs.Joueur1.getSigne() && l_tabCases[1][1].getEtat() == Joueurs.Joueur1.getSigne() && l_tabCases[0][2].getEtat() == Joueurs.Joueur1.getSigne()) {
			gagnant = Joueurs.Joueur1.getNom();
			return false;
		}
		return true;
	}
		
/**
 * Méthode VerifPartieTerminee_J2() dans la console
 * 
 * Vérification du signe des cases adjacentes à la case donnée par le joueur 2
 * Vérification du signe des diagonales
 * 
 * @param coordonnee_x_j2 
 * @param coordonnee_y_j2 
 * @return 
 */
	public static boolean VerifPartieTerminee_J2(int coordonnee_y_j2, int coordonnee_x_j2) {
		// Vérification si partie terminée verticalement
		if(l_tabCases[coordonnee_y_j2][0].getEtat() == Joueurs.Joueur2.getSigne() && l_tabCases[coordonnee_y_j2][1].getEtat() == Joueurs.Joueur2.getSigne() && l_tabCases[coordonnee_y_j2][2].getEtat() == Joueurs.Joueur2.getSigne()) {
			gagnant = Joueurs.Joueur2.getNom();
			return false;
		}
		// Vérification si partie terminée horizontalement
		if(l_tabCases[0][coordonnee_x_j2].getEtat() == Joueurs.Joueur2.getSigne() && l_tabCases[1][coordonnee_x_j2].getEtat() == Joueurs.Joueur2.getSigne() && l_tabCases[2][coordonnee_x_j2].getEtat() == Joueurs.Joueur2.getSigne()) {
			gagnant = Joueurs.Joueur2.getNom();
			return false;
		}
		// Vérification si partie terminée diagonalement
		if(l_tabCases[0][0].getEtat() == Joueurs.Joueur2.getSigne() && l_tabCases[1][1].getEtat() == Joueurs.Joueur2.getSigne() && l_tabCases[2][2].getEtat() == Joueurs.Joueur2.getSigne()) {
			return false;
		}
		// Vérification si partie terminée diagonalement
		if(l_tabCases[2][0].getEtat() == Joueurs.Joueur2.getSigne() && l_tabCases[1][1].getEtat() == Joueurs.Joueur2.getSigne() && l_tabCases[0][2].getEtat() == Joueurs.Joueur2.getSigne()) {
			gagnant = Joueurs.Joueur2.getNom();
			return false;
		}
		return true;
		}
}



		

