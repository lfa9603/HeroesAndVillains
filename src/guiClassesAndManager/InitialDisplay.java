package guiClassesAndManager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Heroes & Villains");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 69));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 21, 639, 80);
		frame.getContentPane().add(lblNewLabel);
		
		
		JButton newGameButton = new JButton("New Game");
		newGameButton.setToolTipText("Erases the savings created in a current game, choose only if you have finished your paused game");
		newGameButton.setBounds(177, 150, 310, 63);
		frame.getContentPane().add(newGameButton);
		
		JButton resumeGameButton = new JButton("Resume Game");
		resumeGameButton.setBounds(177, 234, 310, 63);
		frame.getContentPane().add(resumeGameButton);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(21, 366, 639, 175);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel previousScoresLbl = new JLabel("Previous scores");
		previousScoresLbl.setBounds(21, 332, 189, 26);
		frame.getContentPane().add(previousScoresLbl);
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
