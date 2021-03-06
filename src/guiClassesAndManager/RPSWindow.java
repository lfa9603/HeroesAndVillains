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
	private MainGameWindow mainGameWindow;
	private boolean battleFought = false;

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
	
	public RPSWindow(GameWindowManager gameWindowManager, MainGameWindow mainGameWindow) {
//		this.selectedHeroIndex = selectedHeroIndex;
		manager = gameWindowManager;
		this.mainGameWindow = mainGameWindow;
		initialize();
		RPSWindow.setVisible(true);

	}
	
	public void closeWindow() {
		RPSWindow.dispose();
	}
	
	public void finishedWindow() {
		manager.closeRpsWindow(this, mainGameWindow);
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

	
		JTextPane Dialouge = new JTextPane();
		Dialouge.setEditable(false);
		Dialouge.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Dialouge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dialouge.setText("Dialouge");
		Dialouge.setBounds(180, 49, 467, 145);
		RPSWindow.getContentPane().add(Dialouge);
		String RPSRules = "You are playing Rock, paper, Scissors\n"
				+ "The Villain is ready, click one of the buttons below to make your choice.";
		Dialouge.setText(RPSRules);
		
		JTextPane Abilties = new JTextPane();
		Abilties.setEditable(false);
		Abilties.setText("Abilties");
		Abilties.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Abilties.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Abilties.setBounds(180, 205, 467, 131);
		RPSWindow.getContentPane().add(Abilties);
		HeroesSquad squad = manager.getSquad();
		Villain villain = manager.getVillains().getCurrentVillain(manager.getCurrentIndex());
		int selectedHeroIndex = manager.getMiniGameEngine().getSelectedHeroIndex();
		String abiltyString = manager.getMiniGameEngine().getHeroEffectsFromUtils(villain, squad, selectedHeroIndex);
		System.out.println(abiltyString);
		Abilties.setText(abiltyString);
		
		
//		JLabel Abilities = new JLabel("");
//		Abilities.setHorizontalAlignment(SwingConstants.CENTER);
//		Abilities.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		Abilities.setBounds(21, 249, 771, 62);
//		RPSWindow.getContentPane().add(Abilities);
//		HeroesSquad squad = manager.getSquad();
//		Villain villain = manager.getVillains().getCurrentVillain(manager.getCurrentIndex());
//		int selectedHeroIndex = manager.getMiniGameEngine().getSelectedHeroIndex();
//		String abiltyString = manager.getMiniGameEngine().getHeroEffectsFromUtils(villain, squad, selectedHeroIndex);
//		System.out.println(abiltyString);
//		Abilities.setText(abiltyString);
		//manager.getMiniGameEngine().runGuiMiniGameEngine(villain, squad, selectedHeroIndex);
		
		
		//RockPaperScissorsbuttons
		
		JButton btnRock = new JButton("Rock");
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!battleFought) {
					battleFought = true;
					manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).setVillainsChoice(3);
					int villainsIntChoice = manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).getVillainsChoice();
					String villainsChoice = GuiMiniGameUtilities.getRPS(villainsIntChoice);
					manager.getMiniGameEngine().setPlayerChoice(1);
					String result = manager.getMiniGameEngine().runGuiMiniGameEngine(villain, squad, selectedHeroIndex);
					Dialouge.setText("You chose Rock the villain chose " + villainsChoice +"\n"
							+ result);
				}
				
				else {
					Dialouge.setText("Click the continue button.");
				}
			}
		});
		btnRock.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRock.setBounds(21, 390, 243, 62);
		RPSWindow.getContentPane().add(btnRock);
		
		JButton btnPaper = new JButton("Paper");
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!battleFought) {
					battleFought = true;
					manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).setVillainsChoice(3);
					int villainsIntChoice = manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).getVillainsChoice();
					String villainsChoice = GuiMiniGameUtilities.getRPS(villainsIntChoice);
					manager.getMiniGameEngine().setPlayerChoice(2);
					String result = manager.getMiniGameEngine().runGuiMiniGameEngine(villain, squad, selectedHeroIndex);
					Dialouge.setText("You chose Paper the villain chose " + villainsChoice +"\n"
							+ result);
				}
				
				else {
					Dialouge.setText("Click the continue button.");
				}

			}
		});
		btnPaper.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnPaper.setBounds(285, 390, 243, 62);
		RPSWindow.getContentPane().add(btnPaper);
		
		JButton btnScissors = new JButton("Scissors");
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!battleFought) {
					battleFought = true;
					manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).setVillainsChoice(3);
					int villainsIntChoice = manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).getVillainsChoice();
					String villainsChoice = GuiMiniGameUtilities.getRPS(villainsIntChoice);
					manager.getMiniGameEngine().setPlayerChoice(3);
					String result = manager.getMiniGameEngine().runGuiMiniGameEngine(villain, squad, selectedHeroIndex);
					Dialouge.setText("You chose Scissors the villain chose " + villainsChoice +"\n"
							+ result);
				}
				
				else {
					Dialouge.setText("Click the continue button.");
				}
			}
		});
		btnScissors.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnScissors.setBounds(549, 390, 243, 62);
		RPSWindow.getContentPane().add(btnScissors);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (battleFought) {
					finishedWindow();
				}
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnContinue.setBounds(285, 460, 243, 62);
		RPSWindow.getContentPane().add(btnContinue);
	}
}
