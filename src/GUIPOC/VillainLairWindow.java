package GUIPOC;

import java.awt.EventQueue;

import javax.swing.JFrame;

import setupGui.SetupManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import minigames_V2.Games;
import minigames_V2.MiniGameManager_archive;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VillainLairWindow {

	private JFrame battleWindow;
	private static GameWindowManager manager;
	private MainGameWindow mainGameWindow;
	private int selectedHeroIndex;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainGameWindow window = new MainGameWindow();
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
	public VillainLairWindow(GameWindowManager gameWindowManager, MainGameWindow mainGameWindow) {
		manager = gameWindowManager;
		this.mainGameWindow = mainGameWindow;
		initialize();
		battleWindow.setVisible(true);

	}
	
	public void closeWindow() {
		battleWindow.dispose();
	}
	
	public void finishedWindow() {
		manager.closeVillainLairWindow(this, selectedHeroIndex);
	}
	
	/**
	 * @return the selectedHeroIndex
	 */
	public int getSelectedHeroIndex() {
		return selectedHeroIndex;
	}

	/**
	 * @param selectedHeroIndex the selectedHeroIndex to set
	 */
	public void setSelectedHeroIndex(int selectedHeroIndex) {
		this.selectedHeroIndex = selectedHeroIndex;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		battleWindow = new JFrame();
		battleWindow.setBounds(100, 100, 903, 778);
		battleWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleWindow.getContentPane().setLayout(null);
//		setVisibilty();
		
		JLabel Titlelbl = new JLabel("Pre Battle Screen");
		Titlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		Titlelbl.setFont(new Font("Tahoma", Font.BOLD, 28));
		Titlelbl.setBounds(10, 11, 855, 45);
		battleWindow.getContentPane().add(Titlelbl);
		
		JTextPane HeroSquadtextPane = new JTextPane();
		HeroSquadtextPane.setEditable(false);
		HeroSquadtextPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		HeroSquadtextPane.setBounds(471, 229, 394, 181);
		battleWindow.getContentPane().add(HeroSquadtextPane);
		HeroSquadtextPane.setText(manager.getSquad().toString());
		
		JTextPane VillaintextPane = new JTextPane();
		VillaintextPane.setEditable(false);
		VillaintextPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		VillaintextPane.setBounds(10, 229, 394, 181);
		battleWindow.getContentPane().add(VillaintextPane);
		int currentIndex = manager.getCurrentIndex();
		VillaintextPane.setText(manager.getVillains().getCurrentVillain(currentIndex).toString());
		
		JLabel VillainHealthLbl = new JLabel("Villains Health:");
		VillainHealthLbl.setHorizontalAlignment(SwingConstants.CENTER);
		VillainHealthLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		VillainHealthLbl.setBounds(10, 421, 92, 22);
		battleWindow.getContentPane().add(VillainHealthLbl);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(139, 0, 0));
		progressBar.setStringPainted(true);
		progressBar.setString("100%");
		progressBar.setValue(3);
		progressBar.setMaximum(3);
		progressBar.setToolTipText("the villains health");
		progressBar.setBounds(112, 421, 292, 22);
		battleWindow.getContentPane().add(progressBar);
		
		JTextPane dialogueTextPane = new JTextPane();
		dialogueTextPane.setEditable(false);
		dialogueTextPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		dialogueTextPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dialogueTextPane.setBounds(199, 67, 474, 151);
		battleWindow.getContentPane().add(dialogueTextPane);
		int selectedMiniGame = manager.getMiniGameEngine().selectNewGame(3);
		manager.getMiniGameEngine().setSelectedGame(selectedMiniGame);
		String gameString = manager.getMiniGameEngine().getGameString(selectedMiniGame);
		dialogueTextPane.setText("The Minigame will be: " + gameString);

		
		JLabel SelectedHero = new JLabel("Selected Hero");
		SelectedHero.setHorizontalAlignment(SwingConstants.CENTER);
		SelectedHero.setBounds(311, 500, 270, 26);
		battleWindow.getContentPane().add(SelectedHero);
		
		//Game Chooser 
		
		JComboBox<Games> comboBox = new JComboBox<Games>();
		comboBox.setModel(new DefaultComboBoxModel<Games>(Games.values()));
		comboBox.setBounds(199, 547, 83, 32);
		battleWindow.getContentPane().add(comboBox);
		
		JLabel lblUseChooseGame = new JLabel("Use Choose game abilty?");
		lblUseChooseGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblUseChooseGame.setBounds(300, 550, 270, 26);
		battleWindow.getContentPane().add(lblUseChooseGame);
		
		JButton btnChangeGame = new JButton("Change Game");
		btnChangeGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int game = comboBox.getSelectedIndex() + 1;
				manager.getMiniGameEngine().setSelectedGame(game);
				int selectedMiniGame = manager.getMiniGameEngine().getSelectedMiniGame();
				String gameString = manager.getMiniGameEngine().getGameString(selectedMiniGame);
				dialogueTextPane.setText("The Minigame will be: " + gameString);
			}
		});
		btnChangeGame.setBounds(598, 546, 194, 35);
		battleWindow.getContentPane().add(btnChangeGame);
		comboBox.setVisible(false);
		lblUseChooseGame.setVisible(false);
		btnChangeGame.setVisible(false);
		
		
		//Hero Selection buttons
		JButton heroBtn1 = new JButton("Select " + manager.getSquad().getHero(0).getCharacterName());
		heroBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectedHero.setText(manager.getSquad().getHero(0).getCharacterName() + " selected");
				if (manager.getSquad().getHero(0).getIsGameChooser()) {
					comboBox.setVisible(true);
					lblUseChooseGame.setVisible(true);
					btnChangeGame.setVisible(true);
				}
				else {
					comboBox.setVisible(false);
					lblUseChooseGame.setVisible(false);
					btnChangeGame.setVisible(false);
				}
			}
		});
		heroBtn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		heroBtn1.setToolTipText("Click to select this hero to fight with");
		heroBtn1.setBounds(471, 421, 159, 23);
		battleWindow.getContentPane().add(heroBtn1);
		
		
		//BATTLE BUTTON
				
		JButton btnBattle = new JButton("Battle");
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Minigame number: " + selectedMiniGame);
				finishedWindow();
			}
		});
		btnBattle.setBounds(259, 630, 371, 56);
		battleWindow.getContentPane().add(btnBattle);

		// to Confirm level transition and test other game logic
		
//		JButton btnWin = new JButton("Win");
//		btnWin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				manager.closeVillainLairWindow(VillainLairWindow.this, mainGameWindow, true);
//			}
//		});
//		btnWin.setBounds(644, 641, 194, 35);
//		battleWindow.getContentPane().add(btnWin);
//		
//		JButton button_1 = new JButton("lose");
//		button_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				manager.closeVillainLairWindow(VillainLairWindow.this, mainGameWindow, false);
//			}
//		});
//		button_1.setBounds(644, 595, 194, 35);
//		battleWindow.getContentPane().add(button_1);

		
		
		switch (manager.getSquad().getLength()) {
		case 2: 		JButton herobtn2 = new JButton("Select " + manager.getSquad().getHero(1).getCharacterName());
		herobtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectedHero.setText(manager.getSquad().getHero(1).getCharacterName() + " selected");
				if (manager.getSquad().getHero(1).getIsGameChooser()) {
					comboBox.setVisible(true);
					lblUseChooseGame.setVisible(true);
					btnChangeGame.setVisible(true);
				}
				else {
					comboBox.setVisible(false);
					lblUseChooseGame.setVisible(false);
					btnChangeGame.setVisible(false);
				}
			}
		});
		herobtn2.setToolTipText("Click to select this hero to fight with");
		herobtn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		herobtn2.setBounds(706, 421, 159, 23);
		battleWindow.getContentPane().add(herobtn2); break;
		
		case 3: JButton herobtn22 = new JButton("Select " + manager.getSquad().getHero(1).getCharacterName());
		herobtn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectedHero.setText(manager.getSquad().getHero(1).getCharacterName() + " selected");
				if (manager.getSquad().getHero(1).getIsGameChooser()) {
					comboBox.setVisible(true);
					lblUseChooseGame.setVisible(true);
					btnChangeGame.setVisible(true);
				}
				else {
					comboBox.setVisible(false);
					lblUseChooseGame.setVisible(false);
					btnChangeGame.setVisible(false);
				}
			}
		});
		herobtn22.setToolTipText("Click to select this hero to fight with");
		herobtn22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		herobtn22.setBounds(706, 421, 159, 23);
		battleWindow.getContentPane().add(herobtn22);
		
		JButton heroBtn3 = new JButton("Select " + manager.getSquad().getHero(2).getCharacterName());
		heroBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectedHero.setText(manager.getSquad().getHero(2).getCharacterName() + " selected");
				if (manager.getSquad().getHero(2).getIsGameChooser()) {
					comboBox.setVisible(true);
					lblUseChooseGame.setVisible(true);
					btnChangeGame.setVisible(true);
				}
				else {
					comboBox.setVisible(false);
					lblUseChooseGame.setVisible(false);
					btnChangeGame.setVisible(false);
				}
			}
		});
		heroBtn3.setToolTipText("Click to select this hero to fight with");
		heroBtn3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		heroBtn3.setBounds(585, 455, 159, 23);
		battleWindow.getContentPane().add(heroBtn3); break;
		}
		}
}
