package guiClassesAndManager;

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
import characters.Villain;
import minigames_V2.GuiMiniGameUtilities;
import minigames_V2.MiniGameEngine;

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
	
	public RPSWindow(GameWindowManager gameWindowManager) {
//		this.selectedHeroIndex = selectedHeroIndex;
		manager = gameWindowManager;
		initialize();
		RPSWindow.setVisible(true);

	}
	
	public void closeWindow() {
		RPSWindow.dispose();
	}
	
	public void finishedWindow() {
		manager.closeRpsWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		RPSWindow = new JFrame();
		RPSWindow.setBounds(100, 100, 840, 620);
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
		
		
		JTextPane Dialouge = new JTextPane();
		Dialouge.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Dialouge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dialouge.setText("Dialouge");
		Dialouge.setBounds(180, 49, 467, 189);
		RPSWindow.getContentPane().add(Dialouge);
		String RPSRules = "You are playing Rock, paper, Scissors\n "
				+ "The Villain is ready, click one of the buttons below to make your choice.";
		Dialouge.setText(RPSRules);
		
		JLabel Abilities = new JLabel("");
		Abilities.setHorizontalAlignment(SwingConstants.CENTER);
		Abilities.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Abilities.setBounds(21, 249, 771, 62);
		RPSWindow.getContentPane().add(Abilities);
		HeroesSquad squad = manager.getSquad();
		Villain villain = manager.getVillains().getCurrentVillain(manager.getCurrentIndex());
		String abiltyString = manager.getMiniGameEngine().getHeroEffectsFromUtils(villain, squad, selectedHeroIndex);
		System.out.println(abiltyString);
		Abilities.setText(abiltyString);
		//manager.getMiniGameEngine().runGuiMiniGameEngine(villain, squad, selectedHeroIndex);
		
		
		JButton btnPaper = new JButton("Paper");
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).setVillainsChoice(3);
				int villainsIntChoice = manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).getVillainsChoice();
				String villainsChoice = GuiMiniGameUtilities.getRPS(villainsIntChoice);
				String result = manager.getMiniGameEngine().runGuiMiniGameEngine(villain, squad, selectedHeroIndex);
				Dialouge.setText("You chose Paper the villain chose " + villainsChoice +"\n"
						+ result);
			}
		});
		btnPaper.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnPaper.setBounds(285, 390, 243, 62);
		RPSWindow.getContentPane().add(btnPaper);
		
		JButton btnScissors = new JButton("Scissors");
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnScissors.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnScissors.setBounds(549, 390, 243, 62);
		RPSWindow.getContentPane().add(btnScissors);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnContinue.setBounds(285, 460, 243, 62);
		RPSWindow.getContentPane().add(btnContinue);
	}
}
