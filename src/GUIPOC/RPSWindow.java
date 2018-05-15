package GUIPOC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.SoftBevelBorder;

import characters.HeroesSquad;

import javax.swing.border.BevelBorder;

public class RPSWindow {

	private JFrame RPSWindow;
	private GameWindowManager manager;
	private int selectedHeroIndex;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RPSWindow window = new RPSWindow();
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
	public RPSWindow(GameWindowManager gameWindowManager, int selectedHeroIndex) {
		initialize();
		this.selectedHeroIndex = selectedHeroIndex;
		manager = gameWindowManager;
		RPSWindow.setVisible(true);

	}
	
	public void closeWindow() {
		RPSWindow.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		RPSWindow = new JFrame();
		RPSWindow.setBounds(100, 100, 840, 544);
		RPSWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RPSWindow.getContentPane().setLayout(null);
		
		JLabel lblRockPaperScissors = new JLabel("Rock Paper Scissors");
		lblRockPaperScissors.setHorizontalAlignment(SwingConstants.CENTER);
		lblRockPaperScissors.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblRockPaperScissors.setBounds(0, 0, 808, 45);
		RPSWindow.getContentPane().add(lblRockPaperScissors);

		
		JButton btnRock = new JButton("Rock");
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRock.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRock.setBounds(21, 390, 243, 62);
		RPSWindow.getContentPane().add(btnRock);
		
		JButton btnPaper = new JButton("Paper");
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPaper.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnPaper.setBounds(285, 390, 243, 62);
		RPSWindow.getContentPane().add(btnPaper);
		
		JButton btnPaper_1 = new JButton("Scissors");
		btnPaper_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPaper_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnPaper_1.setBounds(549, 390, 243, 62);
		RPSWindow.getContentPane().add(btnPaper_1);
		
		JTextPane Dialouge = new JTextPane();
		Dialouge.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Dialouge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dialouge.setText("Dialouge");
		Dialouge.setBounds(180, 49, 467, 109);
		RPSWindow.getContentPane().add(Dialouge);
		String RPSRules = "You are playing Rock, paper, Scissors\n "
				+ "The Villain is ready, click one of the buttons below to make your choice.";
		Dialouge.setText(RPSRules);
		
		JLabel Abilities = new JLabel("");
		Abilities.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Abilities.setBounds(194, 179, 412, 62);
		RPSWindow.getContentPane().add(Abilities);
		HeroesSquad squad = manager.getSquad();
		Hero hero = squad.getHero()
		
		GuiMiniGameUtilities.getHeroAbiltyEffects(hero, villain, squad, villainsChoice, selectedGame)
		
	}
}
