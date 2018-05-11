package GUIPOC;

import java.awt.EventQueue;

import javax.swing.JFrame;

import city.buildings.hospital.Hospital;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class HospitalWindow {

	private JFrame frame;
	
	private GameWindowManager manager;
	private Hospital hospitalBuilding;
	private MainGameWindow mainWindow;
	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HospitalWindow window = new HospitalWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public HospitalWindow(GameWindowManager incomingManager, Hospital hospitalBuild, MainGameWindow mainWind) {
		
		manager = incomingManager;
		hospitalBuilding = hospitalBuild;
		mainWindow = mainWind;
		
		initialize();
		
		frame.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea healingWardTxtArea = new JTextArea();
		healingWardTxtArea.setWrapStyleWord(true);
		healingWardTxtArea.setText((String) null);
		healingWardTxtArea.setLineWrap(true);
		healingWardTxtArea.setEditable(false);
		healingWardTxtArea.setBackground(SystemColor.menu);
		healingWardTxtArea.setBounds(10, 81, 338, 231);
		
		healingWardTxtArea.setText(hospitalBuilding.get);
		
		frame.getContentPane().add(healingWardTxtArea);
		
		//Done
		JTextArea welcomeToHospitalTxtArea = new JTextArea();
		welcomeToHospitalTxtArea.setWrapStyleWord(true);
		welcomeToHospitalTxtArea.setText("Welcome to the Hospital! Select a Healing item and apply it to your hero!");
		welcomeToHospitalTxtArea.setLineWrap(true);
		welcomeToHospitalTxtArea.setEditable(false);
		welcomeToHospitalTxtArea.setBackground(SystemColor.menu);
		welcomeToHospitalTxtArea.setBounds(10, 11, 714, 35);
		frame.getContentPane().add(welcomeToHospitalTxtArea);
		
		JTextArea squadHealingItemsTxtArea = new JTextArea();
		squadHealingItemsTxtArea.setWrapStyleWord(true);
		squadHealingItemsTxtArea.setText((String) null);
		squadHealingItemsTxtArea.setLineWrap(true);
		squadHealingItemsTxtArea.setEditable(false);
		squadHealingItemsTxtArea.setBackground(SystemColor.menu);
		squadHealingItemsTxtArea.setBounds(396, 81, 338, 231);
		frame.getContentPane().add(squadHealingItemsTxtArea);
		
		JLabel hospitalhealingWardLbl = new JLabel("Hospital Healing ward");
		hospitalhealingWardLbl.setBounds(20, 57, 180, 14);
		frame.getContentPane().add(hospitalhealingWardLbl);
		
		JLabel squadHealingItemsLbl = new JLabel("Squad Healing items");
		squadHealingItemsLbl.setBounds(386, 56, 180, 14);
		frame.getContentPane().add(squadHealingItemsLbl);
		
		JButton backToMapBtn = new JButton("Back to the Map! ");
		backToMapBtn.setBounds(109, 509, 504, 35);
		frame.getContentPane().add(backToMapBtn);
		
		JLabel selectHeroLabel = new JLabel("Select a hero");
		selectHeroLabel.setBounds(10, 323, 180, 14);
		frame.getContentPane().add(selectHeroLabel);
		
		JComboBox<String> selectHeroComboBox = new JComboBox<String>();
		selectHeroComboBox.setSelectedIndex(0);
		selectHeroComboBox.setMaximumRowCount(3);
		selectHeroComboBox.setBounds(10, 348, 180, 32);
		frame.getContentPane().add(selectHeroComboBox);
		
		JComboBox<String> selectHealingItemComboBox = new JComboBox<String>();
		selectHealingItemComboBox.setSelectedIndex(0);
		selectHealingItemComboBox.setMaximumRowCount(3);
		selectHealingItemComboBox.setBounds(200, 348, 180, 32);
		frame.getContentPane().add(selectHealingItemComboBox);
		
		JLabel selectHealingItemLbl = new JLabel("Select healing item");
		selectHealingItemLbl.setBounds(200, 323, 180, 14);
		frame.getContentPane().add(selectHealingItemLbl);
		
		JTextArea showSuccessOrFailureApplyingHealItemTxtArea = new JTextArea();
		showSuccessOrFailureApplyingHealItemTxtArea.setWrapStyleWord(true);
		showSuccessOrFailureApplyingHealItemTxtArea.setText((String) null);
		showSuccessOrFailureApplyingHealItemTxtArea.setLineWrap(true);
		showSuccessOrFailureApplyingHealItemTxtArea.setEditable(false);
		showSuccessOrFailureApplyingHealItemTxtArea.setBackground(SystemColor.menu);
		showSuccessOrFailureApplyingHealItemTxtArea.setBounds(386, 393, 338, 105);
		frame.getContentPane().add(showSuccessOrFailureApplyingHealItemTxtArea);
		
		JButton applyHealingItemToHeroBtn = new JButton("Apply healing item!");
		applyHealingItemToHeroBtn.setBounds(427, 348, 144, 33);
		frame.getContentPane().add(applyHealingItemToHeroBtn);
		
		
	}
}
