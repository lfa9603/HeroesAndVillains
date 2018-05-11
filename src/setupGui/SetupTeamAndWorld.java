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
import characters.HeroTypes;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel jlbCurrentTeam = new JLabel("empty...");
		jlbCurrentTeam.setVerticalAlignment(SwingConstants.TOP);
		jlbCurrentTeam.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		jlbCurrentTeam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlbCurrentTeam.setHorizontalAlignment(SwingConstants.LEFT);
		jlbCurrentTeam.setBounds(374, 45, 338, 224);
		frmTeamBuilder.getContentPane().add(jlbCurrentTeam);
		
		JLabel lblCurrentTeam = new JLabel("Current Team:");
		lblCurrentTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentTeam.setBounds(374, 11, 338, 20);
		frmTeamBuilder.getContentPane().add(lblCurrentTeam);
		
		JLabel lblPleaseSelectUp = new JLabel("Please select up to 3 heros to add to your team:");
		lblPleaseSelectUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseSelectUp.setBounds(10, 280, 338, 20);
		frmTeamBuilder.getContentPane().add(lblPleaseSelectUp);
		
		JTextPane txtpnTeamOptions = new JTextPane();
		txtpnTeamOptions.setEditable(false);
		txtpnTeamOptions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnTeamOptions.setText(manager.getCharacterTypes());
		txtpnTeamOptions.setBounds(10, 45, 338, 224);
		frmTeamBuilder.getContentPane().add(txtpnTeamOptions);
		
		JLabel lblAvaliableHeroTypes = new JLabel("Avaliable Hero types below:");
		lblAvaliableHeroTypes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAvaliableHeroTypes.setBounds(10, 11, 338, 20);
		frmTeamBuilder.getContentPane().add(lblAvaliableHeroTypes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(HeroTypes.values()));
		comboBox.setBounds(10, 305, 95, 29);
		frmTeamBuilder.getContentPane().add(comboBox);
		
		txtHerosName = new JTextField();
		txtHerosName.setText("Hero's name");
		txtHerosName.setName("Heros name");
		txtHerosName.setToolTipText("Please enter a name for your Hero");
		txtHerosName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHerosName.setBounds(114, 305, 263, 29);
		frmTeamBuilder.getContentPane().add(txtHerosName);
		txtHerosName.setColumns(10);
		
		JButton btnAddToTeam = new JButton("Add to Team");
		btnAddToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddToTeam.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddToTeam.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddToTeam.setToolTipText("Click to add to your team");
		btnAddToTeam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddToTeam.setBounds(464, 305, 175, 29);
		frmTeamBuilder.getContentPane().add(btnAddToTeam);
	}
}
