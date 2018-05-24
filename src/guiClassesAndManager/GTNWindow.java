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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * The Guess the number minigame window. Gives the hero to select a number, if not correct it gives 
 * a hint (higher or lower), if the hero's choice is wrong again it show the hero lost.
 * In the other case it shows the hero wins.
 *
 */
public class GTNWindow {

	private JFrame GTNWindow;
	private GameWindowManager manager;
	private MainGameWindow mainGameWindow;
	private boolean battleFought = false;
	private int timesFought = 0;



	/**
	 * Create the application.
	 */
	public GTNWindow(GameWindowManager gameWindowManager, MainGameWindow mainGameWindow) {
//		this.selectedHeroIndex = selectedHeroIndex;
		manager = gameWindowManager;
		this.mainGameWindow = mainGameWindow;
		initialize();
		GTNWindow.setVisible(true);

	}
	
	/**
	 * Disposes the current GTNWindow.
	 */
	public void closeWindow() {
		GTNWindow.dispose();
	}
	
	/**
	 * Calls the manager to close the current GTNWindow and perform any other needed action.
	 */
	public void finishedWindow() {
		manager.closeGtnWindow(this, mainGameWindow);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GTNWindow = new JFrame();
		GTNWindow.setTitle("Guess the Number");
		GTNWindow.setBounds(100, 100, 840, 620);
		GTNWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GTNWindow.getContentPane().setLayout(null);
		
		JLabel lblRockPaperScissors = new JLabel("Guess the Number");
		lblRockPaperScissors.setHorizontalAlignment(SwingConstants.CENTER);
		lblRockPaperScissors.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblRockPaperScissors.setBounds(0, 0, 808, 45);
		GTNWindow.getContentPane().add(lblRockPaperScissors);

	
		JTextPane Dialouge = new JTextPane();
		Dialouge.setEditable(false);
		Dialouge.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Dialouge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dialouge.setText("Dialouge");
		Dialouge.setBounds(180, 49, 467, 145);
		GTNWindow.getContentPane().add(Dialouge);
		String GTNRules = "You are playing Guess the number\n"
				+ "You get to guesses to pick the number the villain has chosen."
				+ "The Villain is ready, choose a number in the combo box and click the 'choose number' button  to make your choice.";
		Dialouge.setText(GTNRules);
		
		JTextPane Abilties = new JTextPane();
		Abilties.setEditable(false);
		Abilties.setText("Abilties");
		Abilties.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Abilties.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Abilties.setBounds(180, 205, 467, 182);
		GTNWindow.getContentPane().add(Abilties);
		HeroesSquad squad = manager.getSquad();
		Villain villain = manager.getVillains().getCurrentVillain(manager.getCurrentIndex());
		villain.setVillainsChoice(10);
		System.out.println("VC Correct: " + villain.getVillainsChoice());
		int selectedHeroIndex = manager.getMiniGameEngine().getSelectedHeroIndex();
		String abiltyString = manager.getMiniGameEngine().getHeroEffectsFromUtils(villain, squad, selectedHeroIndex);
		System.out.println(abiltyString);
		Abilties.setText(abiltyString);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (timesFought >= 2 | manager.getMiniGameEngine().getHeroWonGTN()) {
					manager.getMiniGameEngine().setHeroWonGTN(false);
					finishedWindow();
				}
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnContinue.setBounds(284, 490, 243, 62);
		GTNWindow.getContentPane().add(btnContinue);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setMaximumRowCount(10);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(180, 428, 112, 33);
		GTNWindow.getContentPane().add(comboBox);
		
		
		
		JButton btnChooseNumber = new JButton("Choose number");
		btnChooseNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (timesFought < 2 & !manager.getMiniGameEngine().getHeroWonGTN()) {
					timesFought++;
					battleFought = true;
					manager.getMiniGameEngine().setGuessesInGTN(timesFought);
					System.out.println("VC from GTNwindow " + villain.getVillainsChoice());
					int playersChoice = comboBox.getSelectedIndex() + 1;
					manager.getMiniGameEngine().setPlayerChoice(playersChoice);
					String result = manager.getMiniGameEngine().runGuiMiniGameEngine(villain, squad, selectedHeroIndex);
					Dialouge.setText(result);
				}
				
				else {
					Dialouge.setText("Click the continue button.");
				}
				
			}
		});
		btnChooseNumber.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnChooseNumber.setBounds(404, 428, 243, 33);
		GTNWindow.getContentPane().add(btnChooseNumber);
	}
}
