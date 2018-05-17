package guiClassesAndManager;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class newLevelWelcomeWindow {

	private JFrame frame;
	private GameWindowManager manager;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					newLevelWelcomeWindow window = new newLevelWelcomeWindow();
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
	public newLevelWelcomeWindow(GameWindowManager incomingManager) {
		manager = incomingManager;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
