package guiClassesAndManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import engine.Tuple;

//import serial.Employee;
//import serial.GameWindowManager;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;

/**
 * 
 * Initial game window, gives the chance to the player to see the prious scores and to start a new game or resume the active one.
 * Also contains the main method called by the executable.
 * 
 */
public class InitialDisplay implements java.io.Serializable {

	
	
	private static final long serialVersionUID = -1338608437428960096L;
	private JFrame frame;
	private JTextArea scoresTextArea;

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
		frame.setResizable(false);
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
		
		JLabel mainTitle = new JLabel("Heroes & Villains");
		mainTitle.setFont(new Font("Tahoma", Font.PLAIN, 69));
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitle.setBounds(21, 21, 639, 80);
		frame.getContentPane().add(mainTitle);
		
		JLabel lblNoSavedGame = new JLabel("No saved game available");
		lblNoSavedGame.setForeground(Color.RED);
		lblNoSavedGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoSavedGame.setBounds(177, 298, 310, 26);
		lblNoSavedGame.setVisible(false);
		frame.getContentPane().add(lblNoSavedGame);
		
		JButton newGameButton = new JButton("New Game");
		newGameButton.setToolTipText("Erases the savings created in a current game, choose only if you have finished your paused game");
		newGameButton.setBounds(177, 150, 310, 63);
		frame.getContentPane().add(newGameButton);
		
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GameWindowManager manager = new GameWindowManager();
				manager.launchSetupTeamAndWorld();
				
				manager.cleanManagerSerFil();
				
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
					FileInputStream fileIn = new FileInputStream("GameSaves/manager.ser");
					if (!(fileIn.available() == 0)) {
						ObjectInputStream in = new ObjectInputStream(fileIn);
						manager = (GameWindowManager) in.readObject();
//						System.out.println(manager.getSquad());
//						System.out.println("Ciao");
						in.close();
					}
					fileIn.close();

				} catch (IOException i) {
					i.printStackTrace();
					return;
				} catch (ClassNotFoundException c) {
					System.out.println("GameWindowManager class not found");
					c.printStackTrace();
				}
				if (manager == null) {
					lblNoSavedGame.setVisible(true);
					System.out.println("Ciao");
				} else {
					frame.dispose();
					new MainGameWindow(manager);
//					System.out.println(manager.getSquad())hjlk;
					//Already crashes here, manager is still null no matter what I think
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 366, 310, 203);
		frame.getContentPane().add(scrollPane);
		
		scoresTextArea = new JTextArea();
		scrollPane.setViewportView(scoresTextArea);
		scoresTextArea.setEditable(false);
		scoresTextArea.setBackground(Color.LIGHT_GRAY);
		scoresTextArea.setColumns(10);
		scoresTextArea.setText(giveScoresToScoreBoard());
		
		JLabel previousScoresLbl = new JLabel("Previous scores");
		previousScoresLbl.setBounds(177, 335, 189, 26);
		frame.getContentPane().add(previousScoresLbl);
		
//		JLabel lblNoSavedGame = new JLabel("No saved game available");
//		lblNoSavedGame.setForeground(Color.RED);
//		lblNoSavedGame.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNoSavedGame.setBounds(177, 298, 310, 26);
//		lblNoSavedGame.setVisible(false);
//		frame.getContentPane().add(lblNoSavedGame);
		
		
		
	}
//	Setup to retrieve the scores board 
	private String giveScoresToScoreBoard() {
		String string = new String();
		ArrayList<Tuple<String, Integer, String>> tripletList = null;
		try {
//			FileInputStream fileIn = new FileInputStream("src/saved_instances/scores_board.ser");
			FileInputStream fileIn = new FileInputStream("GameSaves/scores_board.ser");
			if (!(fileIn.available() == 0)) {
				ObjectInputStream in = new ObjectInputStream(fileIn);
				tripletList = (ArrayList<Tuple<String, Integer, String>>) in.readObject();
//				System.out.println(manager.getSquad());
//				System.out.println("Ciao");
				in.close();
			}
			fileIn.close();

		} catch (IOException i) {
			i.printStackTrace();
			
		} catch (ClassNotFoundException c) {
			System.out.println("GameWindowManager class not found");
			c.printStackTrace();
		}
		if (tripletList != null) {
			for (Tuple<String, Integer, String> triplet : tripletList) {
				string += "  " +triplet.getK() + "    " + triplet.getV() + "    " + triplet.getT() + "\n";
			}
		} else {
			string = "Looks like you have no older scores";
		}
		
		return string;
		
	}
	
	
	public static void main(String[] args) {
		File file = new File("GameSaves");
		
		System.out.println(file.mkdirs());
		
		File savingsFile = new File("GameSaves/manager.ser");
		File scoresFile = new File("GameSaves/scores_board.ser");
		
		try {
			savingsFile.createNewFile();
			scoresFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new InitialDisplay();
	}
}
