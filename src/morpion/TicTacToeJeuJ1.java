package morpion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLayeredPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToeJeuJ1 {

	private JFrame frame;
	private JTextField txtInterface;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeJeuJ1 window = new TicTacToeJeuJ1();
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
	public TicTacToeJeuJ1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Morpion - Tic Tac Toe");
		frame.getContentPane().setLayout(null);
		
		txtInterface = new JTextField();
		txtInterface.setBounds(34, 31, 361, 20);
		txtInterface.setEditable(false);
		txtInterface.setHorizontalAlignment(SwingConstants.CENTER);
		txtInterface.setText("Interface de " + Joueurs.Joueur1.getNom());
		frame.getContentPane().add(txtInterface);
		txtInterface.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 62, 361, 275);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3,3,1,1));
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		
		for(int i = 0; i<9; i++){
		   JPanel ptest = new JPanel();
		   JButton btnNewButton_i = new JButton("");
		   panel.add(btnNewButton_i);
		   ptest.setBorder(blackline);
		   
		   btnNewButton_i.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					char signe = Joueurs.Joueur1.getSigne();
					String signeToString = Character.toString(signe);
					btnNewButton_i.setText(signeToString);
					

				}		
		   });
		}
		panel.setBorder(blackline);
		frame.getContentPane().add(panel);
		
		 

		



	}
	
	
}
