package GUIPOC;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import city.buildings.Building;
import javax.swing.JButton;

public class HomeWindow {

	private JFrame frame;
	private GameWindowManager manager;
	private MainGameWindow mainWindow;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeWindow window = new HomeWindow();
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
	public HomeWindow(GameWindowManager incomingManager, Building homeBuilidng, MainGameWindow incomingMainWindow) {
		manager = incomingManager;
		mainWindow = incomingMainWindow;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Press To close window");
		btnNewButton.setBounds(148, 211, 340, 70);
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				manager.closeHomeBaseWindow(HomeWindow.this, mainWindow);
				
			}
		});
	}
	
	public void closeWindow() {
		frame.dispose();
		
	}
}
