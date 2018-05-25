package guiClassesAndManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import collectables.Money;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import java.awt.Color;

public class YouWonWindow {

	private JFrame frame;
	private GameWindowManager manager;
	
	private Thread thread;
	private boolean isThreadAlive;
	private int timesClickedSaveButton;

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
		timesClickedSaveButton = 0;
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
		label.setBounds(21, 72, 814, 165);
		frame.getContentPane().add(label);
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (isThreadAlive) {
					
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					label.setForeground(Color.GREEN);
					
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					label.setForeground(Color.MAGENTA);
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					label.setForeground(Color.CYAN);
				}
				
			}
		});
		thread.start();
		
		JButton btnNewButton = new JButton("Exit Game");
		btnNewButton.setBounds(274, 310, 273, 84);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JLabel saveResultLabel = new JLabel("Game result saved successfully!");
		saveResultLabel.setForeground(Color.GREEN);
		saveResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveResultLabel.setBounds(245, 424, 324, 26);
		saveResultLabel.setVisible(false);
		frame.getContentPane().add(saveResultLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isThreadAlive = false;
				frame.dispose();
				
			}
		});
		
		
		JButton saveGameBtn = new JButton("Save Game");
		saveGameBtn.setBounds(274, 461, 273, 84);
		frame.getContentPane().add(saveGameBtn);

		long endTime = System.currentTimeMillis();
		long timeTakenMinutes = (((endTime - manager.getStartGameTime())/1000)/60);
		long timeTakenSeconds = ((endTime - manager.getStartGameTime()/1000)%60);
		String timeTakenString = String.format("%02d:%02d Min:Sec", timeTakenMinutes, timeTakenSeconds);
		
		JLabel label_1 = new JLabel("Game Time: " + timeTakenString);
		label_1.setToolTipText("This is how long it toook you to complete the game.");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_1.setBounds(233, 248, 363, 48);
		frame.getContentPane().add(label_1);
		
		saveGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timesClickedSaveButton < 1) {
					if (manager.saveScore()) {
						saveResultLabel.setVisible(true);
						timesClickedSaveButton += 1;
					}
				} else {
					saveResultLabel.setVisible(true);
					saveResultLabel.setText("You already saved");
					saveResultLabel.setForeground(Color.RED);
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		GameWindowManager manager = new GameWindowManager();
		manager.setWorldSize(5);
		HeroesSquad squad = new HeroesSquad();
		squad.addHero(new Hero("Lorenzo",Types.level_2, Abilities.arrogance));
		manager.setSquad(squad);
		manager.getSquad().setWallet(new Money(2000));
		manager.getSquad().setTeamName("Ciao");
		YouWonWindow w = new YouWonWindow(manager);
		
	}
}
