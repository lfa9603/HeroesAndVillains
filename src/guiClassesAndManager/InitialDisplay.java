package guiClassesAndManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//import serial.Employee;
//import serial.GameWindowManager;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class InitialDisplay {

	private JFrame frame;
	private JTextField textField;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InitialDisplay window = new InitialDisplay();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public InitialDisplay() {
		frame = new JFrame();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 707, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JLabel noSavedGameAvailable = new JLabel("Heroes & Villains");
		noSavedGameAvailable.setFont(new Font("Tahoma", Font.PLAIN, 69));
		noSavedGameAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		noSavedGameAvailable.setBounds(21, 21, 639, 80);
		frame.getContentPane().add(noSavedGameAvailable);
		
		
		JButton newGameButton = new JButton("New Game");
		newGameButton.setToolTipText("Erases the savings created in a current game, choose only if you have finished your paused game");
		newGameButton.setBounds(177, 150, 310, 63);
		frame.getContentPane().add(newGameButton);
		
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameWindowManager manager = new GameWindowManager();
				manager.launchSetupTeamAndWorld();
				frame.dispose();
			}
		});
		
		JButton resumeGameButton = new JButton("Resume Game");
		resumeGameButton.setBounds(177, 234, 310, 63);
		frame.getContentPane().add(resumeGameButton);
		resumeGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameWindowManager manager = null;
				try {
					FileInputStream fileIn = new FileInputStream("src/manager.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					manager = (GameWindowManager) in.readObject();
					in.close();
					fileIn.close();
				} catch (IOException i) {
					i.printStackTrace();
					return;
				} catch (ClassNotFoundException c) {
					System.out.println("GameWindowManager class not found");
					c.printStackTrace();
				}
				
				if (manager == null) {
					noSavedGameAvailable.setVisible(true);
				} else {
					new MainGameWindow(manager);
				}
				
			}
		});
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(21, 366, 639, 175);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel previousScoresLbl = new JLabel("Previous scores");
		previousScoresLbl.setBounds(21, 332, 189, 26);
		frame.getContentPane().add(previousScoresLbl);
		
		JLabel lblNoSavedGame = new JLabel("No saved game available");
		lblNoSavedGame.setForeground(Color.RED);
		lblNoSavedGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoSavedGame.setBounds(177, 298, 310, 26);
		lblNoSavedGame.setVisible(false);
		frame.getContentPane().add(lblNoSavedGame);
		
	}
	
	public static void main(String[] args) {
		new InitialDisplay();
	}
}
