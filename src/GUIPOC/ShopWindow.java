package GUIPOC;

import javax.swing.JFrame;

import city.buildings.shop.Shop;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 21, 691, 26);
		frame.getContentPane().add(lblNewLabel);
	}

}
