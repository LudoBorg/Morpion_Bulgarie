package morpion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToeJoueur2 {

	private JFrame frame;
	private JTextField txtBienvenueDansLe;
	private JTextField textField;
	private JTextField txtLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeJoueur2 window = new TicTacToeJoueur2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToeJoueur2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Morpion - Tic Tac Toe");
		
		txtBienvenueDansLe = new JTextField();
		txtBienvenueDansLe.setEditable(false);
		txtBienvenueDansLe.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenueDansLe.setText("Bienvenue dans le jeu du Tic-Tac-Toe de Ludovic Borgagni");
		txtBienvenueDansLe.setBounds(34, 31, 361, 20);
		frame.getContentPane().add(txtBienvenueDansLe);
		txtBienvenueDansLe.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(166, 87, 155, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setEditable(false);
		txtLogin.setText("Login :");
		txtLogin.setBounds(103, 87, 64, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton btnNewButton = new JButton("Lancer une partie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joueurs.CreerJoueur2(textField.getText());
				System.out.println(Joueurs.Joueur2.getNom() + " " + Joueurs.Joueur2.getSigne());
				TicTacToeJeuJ2.main(null);
				frame.dispose();
			}
		});
		
		btnNewButton.setBounds(103, 213, 218, 23);
		frame.getContentPane().add(btnNewButton);
	}
}


