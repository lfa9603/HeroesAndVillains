package GUIPOC;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import characters.Types;
import characters.Abilities;
import characters.Hero;
import characters.HeroTypes;
import characters.HeroesSquad;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SetupAddHeros {

	private JFrame frmTeamBuilder;
	private static GameWindowManager manager;
	private JTextField txtHerosName;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetupAddHeros window = new SetupAddHeros(manager);
//					window.frmTeamBuilder.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	/**
	 * Create the application.
	 */
	public SetupAddHeros(GameWindowManager gameWindowManager) {
		manager = gameWindowManager;
		initialize();
		frmTeamBuilder.setVisible(true);
	}
	
	public void closeWindow() {
		frmTeamBuilder.dispose();
	}
	
	public void backWindow() {
		manager.closeSetupAddHeros(this);
	}
	
	public void finishedWindow() {
		manager.finalcloseSetupAddHeros(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeamBuilder = new JFrame();
		frmTeamBuilder.getContentPane().setName("heros name");
		frmTeamBuilder.setTitle("Team builder");
		frmTeamBuilder.setBounds(100, 100, 769, 610);
		frmTeamBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamBuilder.getContentPane().setLayout(null);
		
		JLabel lblCurrentTeam = new JLabel("Current Team:");
		lblCurrentTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentTeam.setBounds(374, 79, 338, 20);
		frmTeamBuilder.getContentPane().add(lblCurrentTeam);
		
		JLabel lblPleaseSelectUp = new JLabel("Please select up to 3 heros to add to your team:");
		lblPleaseSelectUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseSelectUp.setBounds(10, 348, 338, 20);
		frmTeamBuilder.getContentPane().add(lblPleaseSelectUp);
		
		JLabel ErrorLabel = new JLabel("");
		ErrorLabel.setForeground(new Color(128, 0, 0));
		ErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ErrorLabel.setBounds(371, 348, 323, 20);
		frmTeamBuilder.getContentPane().add(ErrorLabel);
		
		JTextPane txtpnTeamOptions = new JTextPane();
		txtpnTeamOptions.setEditable(false);
		txtpnTeamOptions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnTeamOptions.setText(manager.getCharacterTypes());
		txtpnTeamOptions.setBounds(10, 146, 338, 191);
		frmTeamBuilder.getContentPane().add(txtpnTeamOptions);
		
		JTextPane txtpnEmpty = new JTextPane();
		txtpnEmpty.setToolTipText("Your Current Team");
		txtpnEmpty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnEmpty.setText("Empty...");
		txtpnEmpty.setBounds(371, 146, 323, 158);
		frmTeamBuilder.getContentPane().add(txtpnEmpty);
		txtpnEmpty.setText(manager.getSquad().toString());
		
		JLabel lblAvaliableHeroTypes = new JLabel("Avaliable Hero types below:");
		lblAvaliableHeroTypes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAvaliableHeroTypes.setBounds(10, 79, 338, 20);
		frmTeamBuilder.getContentPane().add(lblAvaliableHeroTypes);
		
		JComboBox<HeroTypes> comboBox = new JComboBox<HeroTypes>();
		comboBox.setToolTipText("select the type of hero");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<HeroTypes>(HeroTypes.values()));
		comboBox.setBounds(10, 373, 95, 29);
		frmTeamBuilder.getContentPane().add(comboBox);
		
		txtHerosName = new JTextField();
		txtHerosName.setName("");
		txtHerosName.setToolTipText("Please enter a name for your Hero");
		txtHerosName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHerosName.setBounds(114, 373, 263, 29);
		frmTeamBuilder.getContentPane().add(txtHerosName);
		txtHerosName.setColumns(10);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setToolTipText("select index of hero you want to remove");
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3"}));
		comboBox_1.setBounds(371, 315, 59, 20);
		frmTeamBuilder.getContentPane().add(comboBox_1);
		
		JButton btnRemoveHero = new JButton("Remove Hero");
		btnRemoveHero.setToolTipText("press to remove hero");
		btnRemoveHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedHero = comboBox_1.getSelectedIndex();
				if (selectedHero < manager.getSquad().getLength()) {
					manager.getSquad().removeHero(selectedHero);
					txtpnEmpty.setText(manager.getSquad().toString());
				}
				else {
					ErrorLabel.setText("invalid index selected");
				}
				
			}
		});
		btnRemoveHero.setBounds(442, 314, 127, 23);
		frmTeamBuilder.getContentPane().add(btnRemoveHero);
		
		JButton btnReset = new JButton("Reset Team");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getSquad().squadReset();
				txtpnEmpty.setText(manager.getSquad().toString());
			}
		});
		btnReset.setToolTipText("Press to reset your team");
		btnReset.setBounds(579, 314, 115, 23);
		frmTeamBuilder.getContentPane().add(btnReset);

		
		JButton btnAddToTeam = new JButton("Add to Team");
		btnAddToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HeroTypes currentType = (HeroTypes) comboBox.getSelectedItem();
				Types heroType = manager.typeConversion(currentType);
				String heroName = txtHerosName.getText();
				Abilities heroAbility = manager.getHeroAbility(heroType);
				
				Hero hero = new Hero(heroName, heroType, heroAbility);  
				HeroesSquad squad = manager.getSquad();
				if (squad.getLength() < 3) {
					squad.addHero(hero);
				}
				
				else {
					ErrorLabel.setText("Maximum number of team members reached");
				}
				
				txtpnEmpty.setText(squad.toString());
				System.out.println(squad.toString());
			}
		});
		btnAddToTeam.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddToTeam.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddToTeam.setToolTipText("Click to add to your team");
		btnAddToTeam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddToTeam.setBounds(464, 373, 175, 29);
		frmTeamBuilder.getContentPane().add(btnAddToTeam);
		
		JButton ContinueToGame = new JButton("Continue to Game");
		ContinueToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getSquad().getLength() == 0) {
					ErrorLabel.setText("You must choose at least one Hero");
				}
				else {
					characters.InitialAbiltyEffects.applyHeroSquadAbilties(manager.getSquad().getHeroSquad());
					finishedWindow();
				}
			}
		});
		ContinueToGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ContinueToGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ContinueToGame.setBounds(370, 446, 187, 50);
		frmTeamBuilder.getContentPane().add(ContinueToGame);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(157, 446, 187, 50);
		frmTeamBuilder.getContentPane().add(btnBack);
		
		JLabel label = new JLabel("Setup");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setBounds(67, 11, 572, 49);
		frmTeamBuilder.getContentPane().add(label);
		

		
	}
}
