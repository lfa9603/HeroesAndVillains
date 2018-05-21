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
import engine.Utilities;
import minigames_V2.GuiMiniGameUtilities;
import minigames_V2.MiniGameEngine;

import javax.swing.border.BevelBorder;

public class DWWindow {

	private JFrame DWWindow;
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
	
	public DWWindow(GameWindowManager gameWindowManager, MainGameWindow mainGameWindow) {
//		this.selectedHeroIndex = selectedHeroIndex;
		manager = gameWindowManager;
		this.mainGameWindow = mainGameWindow;
		initialize();
		DWWindow.setVisible(true);

	}
	
	public void closeWindow() {
		DWWindow.dispose();
	}
	
	public void finishedWindow() {
		manager.closeDWWindow(this, mainGameWindow);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DWWindow = new JFrame();
		DWWindow.setTitle("Dice Wars");
		DWWindow.setBounds(100, 100, 840, 620);
		DWWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DWWindow.getContentPane().setLayout(null);
		
		JLabel lblDiceWars = new JLabel("Dices Wars");
		lblDiceWars.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceWars.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblDiceWars.setBounds(0, 0, 808, 45);
		DWWindow.getContentPane().add(lblDiceWars);

	
		JTextPane Dialouge = new JTextPane();
		Dialouge.setEditable(false);
		Dialouge.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Dialouge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dialouge.setText("Dialouge");
		Dialouge.setBounds(180, 49, 467, 145);
		DWWindow.getContentPane().add(Dialouge);
		String GTNRules = "You are playing Dice Wars\n"
				+ "You need to roll a higher number than the Villain"
				+ "The Villain is ready, click the 'roll dice' button  to make your choice.";
		Dialouge.setText(GTNRules);
		
		JTextPane Abilties = new JTextPane();
		Abilties.setEditable(false);
		Abilties.setText("Abilties");
		Abilties.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Abilties.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Abilties.setBounds(180, 205, 467, 131);
		DWWindow.getContentPane().add(Abilties);
		HeroesSquad squad = manager.getSquad();
		Villain villain = manager.getVillains().getCurrentVillain(manager.getCurrentIndex());
		int selectedHeroIndex = manager.getMiniGameEngine().getSelectedHeroIndex();
		String abiltyString = manager.getMiniGameEngine().getHeroEffectsFromUtils(villain, squad, selectedHeroIndex);
		System.out.println(abiltyString);
		Abilties.setText(abiltyString);
		
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
		DWWindow.getContentPane().add(btnContinue);
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!battleFought) {
					battleFought = true;
					String result = "";
					manager.getMiniGameEngine().setPlayerChoice(Utilities.getRandInt(6));
					result = ("You rolled a " + manager.getMiniGameEngine().getPlayerChoice() + "\n");
					manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).setVillainsChoice(6);
					int villainsIntChoice = manager.getVillains().getCurrentVillain(manager.getCurrentIndex()).getVillainsChoice();
					result = result + ("The Villain rolled a " + villainsIntChoice + "\n");
					result = result + manager.getMiniGameEngine().runGuiMiniGameEngine(villain, squad, selectedHeroIndex);
					Dialouge.setText(result);
				}
				else {
					Dialouge.setText("Click the continue button.");
				}

			}
		});
		btnRollDice.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRollDice.setBounds(285, 371, 243, 62);
		DWWindow.getContentPane().add(btnRollDice);
	}
}
