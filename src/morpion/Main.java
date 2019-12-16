package morpion;

import java.awt.*;

import javax.swing.*;

public class Main {
	

	public static void main(String[] args) {
		//Partie GUI
		TicTacToeJoueur1.main(args);
		TicTacToeJoueur2.main(args);		
		
	    //Partie console
		Joueurs.DefinitionNomSigneJoueurs();
		Plateau.ConstructionGrille();
		Plateau.DemandeCaseUtilisateur();

	}


	


}


