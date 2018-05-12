package setupGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
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
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class SetupTeamAndWorld {

	private JFrame frmTeamBuilder;
	private static SetupManager manager;
	private JTextField txtHerosName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupTeamAndWorld window = new SetupTeamAndWorld(manager);
					window.frmTeamBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupTeamAndWorld(SetupManager incomingManger) {
		manager = incomingManger;
		initialize();
		frmTeamBuilder.setVisible(true);
	}
	
	public void closeWindow() {
		frmTeamBuilder.dispose();
	}
	
	public void finishedWindow() {
		manager.closeSetupScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeamBuilder = new JFrame();
		frmTeamBuilder.getContentPane().setName("heros name");
		frmTeamBuilder.setTitle("Team builder");
		frmTeamBuilder.setBounds(100, 100, 738, 541);
		frmTeamBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamBuilder.getContentPane().setLayout(null);
		
		JLabel lblCurrentTeam = new JLabel("Current Team:");
		lblCurrentTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentTeam.setBounds(374, 11, 338, 20);
		frmTeamBuilder.getContentPane().add(lblCurrentTeam);
		
		JLabel lblPleaseSelectUp = new JLabel("Please select up to 3 heros to add to your team:");
		lblPleaseSelectUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseSelectUp.setBounds(10, 280, 338, 20);
		frmTeamBuilder.getContentPane().add(lblPleaseSelectUp);
		
		JLabel ErrorLabel = new JLabel("");
		ErrorLabel.setForeground(new Color(128, 0, 0));
		ErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ErrorLabel.setBounds(371, 280, 323, 20);
		frmTeamBuilder.getContentPane().add(ErrorLabel);
		
		JTextPane txtpnTeamOptions = new JTextPane();
		txtpnTeamOptions.setEditable(false);
		txtpnTeamOptions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnTeamOptions.setText(manager.getCharacterTypes());
		txtpnTeamOptions.setBounds(10, 78, 338, 191);
		frmTeamBuilder.getContentPane().add(txtpnTeamOptions);
		
		JLabel lblAvaliableHeroTypes = new JLabel("Avaliable Hero types below:");
		lblAvaliableHeroTypes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAvaliableHeroTypes.setBounds(10, 11, 338, 20);
		frmTeamBuilder.getContentPane().add(lblAvaliableHeroTypes);
		
		JComboBox<HeroTypes> comboBox = new JComboBox<HeroTypes>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<HeroTypes>(HeroTypes.values()));
		comboBox.setBounds(10, 305, 95, 29);
		frmTeamBuilder.getContentPane().add(comboBox);
		
		txtHerosName = new JTextField();
		txtHerosName.setName("");
		txtHerosName.setToolTipText("Please enter a name for your Hero");
		txtHerosName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHerosName.setBounds(114, 305, 263, 29);
		frmTeamBuilder.getContentPane().add(txtHerosName);
		txtHerosName.setColumns(10);
		
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
		btnAddToTeam.setBounds(464, 305, 175, 29);
		frmTeamBuilder.getContentPane().add(btnAddToTeam);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox_1.setBounds(374, 238, 43, 20);
		frmTeamBuilder.getContentPane().add(comboBox_1);
		
		JButton btnRemoveHero = new JButton("Remove Hero");
		btnRemoveHero.setBounds(427, 237, 102, 23);
		frmTeamBuilder.getContentPane().add(btnRemoveHero);
		
		JButton btnReset = new JButton("Reset Team");
		btnReset.setBounds(539, 237, 102, 23);
		frmTeamBuilder.getContentPane().add(btnReset);
		
		JTextPane txtpnEmpty = new JTextPane();
		txtpnEmpty.setToolTipText("Your Current Team");
		txtpnEmpty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnEmpty.setText("Empty...");
		txtpnEmpty.setBounds(371, 78, 323, 191);
		frmTeamBuilder.getContentPane().add(txtpnEmpty);
		

		
		
		

		
	}
}
