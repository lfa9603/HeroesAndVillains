package GUIPOC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public class YouWonWindow {

	private JFrame frame;
	private GameWindowManager manager;
	
	private Thread thread;
	private boolean isThreadAlive;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					YouWonWindow window = new YouWonWindow();
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
	public YouWonWindow(GameWindowManager incomingManager) {
		manager = incomingManager;
		isThreadAlive = true;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 882, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("YOU WON!!");
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 99));
		label.setBounds(21, 72, 814, 249);
		frame.getContentPane().add(label);
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (isThreadAlive) {
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					label.setForeground(Color.GREEN);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					label.setForeground(Color.MAGENTA);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					label.setForeground(Color.CYAN);
				}
				
			}
		});
		thread.start();
		
		JButton btnNewButton = new JButton("Exit Game");
		btnNewButton.setBounds(274, 343, 273, 84);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isThreadAlive = false;
				frame.dispose();
				
			}
		});
	}
	
	public static void main(String[] args) {
		GameWindowManager manager = new GameWindowManager();
		YouWonWindow w = new YouWonWindow(manager);
		
	}
}
