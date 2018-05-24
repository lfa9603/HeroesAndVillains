package guiClassesAndManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import collectables.Money;

public class YouLostWindow {

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
	public YouLostWindow(GameWindowManager incomingManager) {
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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 882, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("YOU LOST!!");
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 99));
		label.setBounds(21, 35, 814, 215);
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
					label.setForeground(Color.RED);
					
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					label.setForeground(Color.BLACK);
				}
				
			}
		});
		thread.start();
		
		JButton btnNewButton = new JButton("Exit Game");
		btnNewButton.setBounds(274, 295, 273, 84);
		frame.getContentPane().add(btnNewButton);
		
		
		JLabel gameResultSavedLbl = new JLabel("Game result saved successfully!");
		gameResultSavedLbl.setForeground(Color.GREEN);
		gameResultSavedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gameResultSavedLbl.setBounds(262, 400, 296, 26);
		gameResultSavedLbl.setVisible(false);
		frame.getContentPane().add(gameResultSavedLbl);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isThreadAlive = false;
				frame.dispose();
				
			}
		});
		
		
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.setBounds(274, 452, 273, 84);
		frame.getContentPane().add(btnSaveGame);
		
		long endTime = System.currentTimeMillis();
		long timeTakenMinutes = (((endTime - manager.getStartGameTime())/1000)/60);
		long timeTakenSeconds = ((endTime - manager.getStartGameTime()/1000)%60);
		String timeTakenString = String.format("%02d:%02d", timeTakenMinutes, timeTakenSeconds);
		
		
		JLabel lblGameTimeMins = new JLabel("Game Time: " + timeTakenString);
		lblGameTimeMins.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblGameTimeMins.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameTimeMins.setToolTipText("This is how long it toook you to complete the game.");
		lblGameTimeMins.setBounds(228, 236, 363, 48);
		frame.getContentPane().add(lblGameTimeMins);
		
		btnSaveGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timesClickedSaveButton < 1) {
					if (manager.saveScore()) {
						gameResultSavedLbl.setVisible(true);
						timesClickedSaveButton += 1;
					}
				} else {
					gameResultSavedLbl.setVisible(true);
					gameResultSavedLbl.setText("You already saved");
					gameResultSavedLbl.setForeground(Color.RED);
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
		YouLostWindow w = new YouLostWindow(manager);
		
	}
}

