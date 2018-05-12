package GUIPOC;

import javax.swing.JFrame;

import city.buildings.shop.Shop;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JPanel;

public class ShopWindow {

	private JFrame frame;
	
	private GameWindowManager manager;
	private MainGameWindow mainWindow;
	private Shop shopBuilding;
	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShopWindow window = new ShopWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public ShopWindow() {
//		initialize();
//	}
	
	public ShopWindow(GameWindowManager incomingWindow, Shop shopBuild, MainGameWindow mainWind) {
		
		manager = incomingWindow;
		shopBuilding = shopBuild;
		mainWindow = mainWind;
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setWrapStyleWord(true);
		txtrWelcome.setText("Welcome to the Shop! Make " + shopBuilding.getNameOfInnkeeper() +", the owner, happy spending your money here!");
		txtrWelcome.setLineWrap(true);
		txtrWelcome.setEditable(false);
		txtrWelcome.setBackground(SystemColor.menu);
		txtrWelcome.setBounds(21, 21, 691, 43);
		frame.getContentPane().add(txtrWelcome);
		
		JToggleButton justBrowsingTgBtn = new JToggleButton("Just Browsing");
		justBrowsingTgBtn.setBounds(60, 72, 207, 35);
		frame.getContentPane().add(justBrowsingTgBtn);
		
		JToggleButton talkToInnkeeperTgBtn = new JToggleButton("Talk to " + shopBuilding.getNameOfInnkeeper());
		talkToInnkeeperTgBtn.setBounds(435, 72, 207, 35);
		frame.getContentPane().add(talkToInnkeeperTgBtn);
		
		JPanel justBrowsingPanel = new JPanel();
		justBrowsingPanel.setBounds(21, 129, 313, 382);
		frame.getContentPane().add(justBrowsingPanel);
		
		JPanel talkToInnkeeperPanel = new JPanel();
		talkToInnkeeperPanel.setBounds(399, 129, 313, 382);
		frame.getContentPane().add(talkToInnkeeperPanel);
		
		JButton backToMapBtn = new JButton("Back to the Map! ");
		backToMapBtn.setBounds(105, 532, 504, 35);
		frame.getContentPane().add(backToMapBtn);
		
	}
	
	public void closeWindow() {
		frame.dispose();
	}
}
