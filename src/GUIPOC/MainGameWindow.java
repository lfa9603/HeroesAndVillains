package GUIPOC;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.util.ArrayList;

import java.awt.Color;


import javax.swing.SwingConstants;

import city.buildings.Building;

import java.awt.Font;


public class MainGameWindow {

	private JDialog dialog;
	
	private GameWindowManager manager;
	
	private ArrayList<JLabel> entrances;
	private ArrayList<JLabel> infos;
	private ArrayList<JLabel> infosPopUpMessage;
	//decided to instantiate it at class level so that once the 
	//the squad exits a place I can change its position to move 
	//it away from the building
	private JLabel movingLabel;
	
	
	public MainGameWindow(GameWindowManager incomingManager) {
		manager = incomingManager;
		initialize();
		dialog.setModal(true);
		dialog.setVisible(true);		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		entrances = new ArrayList<JLabel>();
		infos = new ArrayList<JLabel>();
		infosPopUpMessage = new ArrayList<JLabel>();
		
		dialog = new JDialog();
		dialog.setResizable(false);
		dialog.setBounds(100, 100, 800, 800);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(null);
		
		movingLabel = new JLabel("0");
		movingLabel.setForeground(Color.BLACK);
		movingLabel.setBackground(Color.BLACK);
		movingLabel.setBounds(336, 300, 11, 26);
		dialog.getContentPane().add(movingLabel);
		
		//GUI for HomeBase object
		JLabel homeLabel = new JLabel("Home Base");
		homeLabel.setBounds(319, 327, 75, 75);
		entrances.add(homeLabel);
		dialog.getContentPane().add(homeLabel);
		
		JLabel homeInfoLabel = new JLabel("info");
		homeInfoLabel.setBounds(226, 325, 75, 75);
		infos.add(homeInfoLabel);
		dialog.getContentPane().add(homeInfoLabel);
		
		JLabel amHomeInfoLabel = new JLabel("Space For Home Infos");
		amHomeInfoLabel.setBounds(81, 399, 383, 75);
		infosPopUpMessage.add(amHomeInfoLabel);
		dialog.getContentPane().add(amHomeInfoLabel);
		
		//////////////GUI objects in the Northern Part of the map
		JLabel northLabel = new JLabel("Entrance");
		northLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northLabel.setBackground(Color.WHITE);
		northLabel.setBounds(247, 0, 130, 75);
		entrances.add(northLabel);
		dialog.getContentPane().add(northLabel);
		
		JLabel northInfoLabel = new JLabel("Info");
		northInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northInfoLabel.setBounds(382, 0, 38, 75);
		infos.add(northInfoLabel);
		dialog.getContentPane().add(northInfoLabel);
		
		JLabel amOnTheNorthInfoLabel = new JLabel("Space for Northern Builidng Info");
		amOnTheNorthInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		amOnTheNorthInfoLabel.setBounds(441, 17, 247, 58);
		infosPopUpMessage.add(amOnTheNorthInfoLabel);
		dialog.getContentPane().add(amOnTheNorthInfoLabel);

		//////////////GUI objects in the Western Part of the map
		JLabel westLabel = new JLabel("Entrance");
		westLabel.setHorizontalAlignment(SwingConstants.CENTER);
		westLabel.setBackground(Color.WHITE);
		westLabel.setBounds(0, 248, 75, 130);
		entrances.add(westLabel);
		dialog.getContentPane().add(westLabel);
		
		JLabel westInfoLabel = new JLabel("Info");
		westInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		westInfoLabel.setBounds(0, 209, 75, 38);
		infos.add(westInfoLabel);
		dialog.getContentPane().add(westInfoLabel);
		
		JLabel amOnTheWestInfoLabel = new JLabel("Space for Western Builidng Info");
		amOnTheWestInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		amOnTheWestInfoLabel.setBounds(21, 133, 264, 58);
		infosPopUpMessage.add(amOnTheWestInfoLabel);
		dialog.getContentPane().add(amOnTheWestInfoLabel);
		////////////////////////////////////////////////////////
		
		//////////////GUI objects in the Southern Part of the map

		JLabel southLabel = new JLabel("Entrance");
		southLabel.setHorizontalAlignment(SwingConstants.CENTER);
		southLabel.setBackground(Color.WHITE);
		southLabel.setBounds(306, 654, 130, 75);
		entrances.add(southLabel);
		dialog.getContentPane().add(southLabel);
		
		JLabel southInfoLabel = new JLabel("Info");
		southInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		southInfoLabel.setBounds(247, 654, 38, 75);
		infos.add(southInfoLabel);
		dialog.getContentPane().add(southInfoLabel);
		
		JLabel amOnSouthInfoLabel = new JLabel("Space For South Builidng Info");
		amOnSouthInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		amOnSouthInfoLabel.setBounds(12, 654, 229, 58);
		infosPopUpMessage.add(amOnSouthInfoLabel);
		dialog.getContentPane().add(amOnSouthInfoLabel);
		///////////////////////////////////
		
		
		//////////////GUI objects in the Eastern Part of the map
		JLabel eastLabel = new JLabel("Entrance");
		eastLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eastLabel.setBackground(Color.WHITE);
		eastLabel.setBounds(699, 196, 75, 103);
		entrances.add(eastLabel);
		dialog.getContentPane().add(eastLabel);
		
		JLabel eastInfoLabel = new JLabel("Info");
		eastInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eastInfoLabel.setBounds(699, 300, 75, 38);
		infos.add(eastInfoLabel);
		dialog.getContentPane().add(eastInfoLabel);
		
		JLabel amOnEastInfoLabel = new JLabel("Space for Eastern Builidng Window");
		amOnEastInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		amOnEastInfoLabel.setBounds(524, 372, 229, 58);
		infosPopUpMessage.add(amOnEastInfoLabel);
		dialog.getContentPane().add(amOnEastInfoLabel);
	
		///////////////////////////////////////////////////////////
		
		
		dialog.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				
				if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
					keepObjectInBoundariesWhileMoving(0, movingLabel);
				}
				if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
					keepObjectInBoundariesWhileMoving(1, movingLabel);	
				}
				if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {

					keepObjectInBoundariesWhileMoving(2, movingLabel);
				}
				if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
					keepObjectInBoundariesWhileMoving(3, movingLabel);	
				}
				
//				System.out.println(movingLabel.getLocation());
				checkActionAvailable(movingLabel, entrances, infos);
				
			}
		});
		
	}
	
	private void keepObjectInBoundariesWhileMoving(int index, JLabel movingLabel) {
		
		Point newPosition = null;
		switch(index) {
			case 0:
				newPosition = new Point(movingLabel.getX(), movingLabel.getY() - 10 );
				break;
			case 1:
				newPosition = new Point(movingLabel.getX(), movingLabel.getY() + 10 );
				break;
			case 2:
				newPosition = new Point(movingLabel.getX() + 10, movingLabel.getY());
				break;
			case 3:
				newPosition = new Point(movingLabel.getX() - 10, movingLabel.getY());
				break;
		}
			
		if (newPosition.x <= 776 && newPosition.x >= 6 && newPosition.y <= 720 && newPosition.y >= 0) {
			movingLabel.setLocation(newPosition);
		}
	}
	
	private void checkActionAvailable(JLabel movingLabel, ArrayList<JLabel> entrances, ArrayList<JLabel> infos) {
		
		for (JLabel label : entrances) {
			int labelEntranceIndex = entrances.indexOf(label);
			Area labelArea = new Area(label.getBounds());
			Area movingLabelArea = new Area(movingLabel.getBounds());
			if (labelArea.intersects(movingLabelArea.getBounds2D())) {
				
				Building building = chooseRightBuilding(labelEntranceIndex);
				chooseNextWindowToOpen(building);
				
			}
		}
		
		for (JLabel label : infos) {
			
			int labelInfoIndex = infos.indexOf(label);
			Area labelArea = new Area(label.getBounds());
			Area movingLabelArea = new Area(movingLabel.getBounds());
			
			if (labelArea.intersects(movingLabelArea.getBounds2D())) {
				JLabel messageToShow =  infosPopUpMessage.get(labelInfoIndex);
				messageToShow.setText("This is the the " + chooseRightBuilding(labelInfoIndex).getBuildingName());
				//Creation of this Thread hadles the resetting of the message label for info labels.
				//I am not too happy to be forced to use another Thread, however it is such a small change that I do not see what could go wrong. 
				//If it will not work we will se what to do. For now it is based on a time limit. In future we might try to change it. Hard choice
				//as I have not a clue of what is better or not. I spoke to myself for long enough, now I am gonna achieve something, wish me luck Jay.
				
				Thread showingMessage = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						JLabel messageToShow =  infosPopUpMessage.get(labelInfoIndex);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						};
						messageToShow.setText("");
						
					}
				});
				
				showingMessage.start();
			}
		} 
		
	}
	
	
	private void chooseNextWindowToOpen(Building building) {
		dialog.setVisible(false);//I am really not sure this is the way to go, but closing completely the window would 
		//mean loosing the Heroes current position, so we will figure it out later
		manager.openBuildingWindow(building, this);
	}
	
	private Building chooseRightBuilding(int index) throws IndexOutOfBoundsException {
		switch (index) {
			case 0:
				return manager.getCurrentCity().returnBuildingAtSpecificCoordinates(new Point(0, 0));
			case 1:
				return manager.getCurrentCity().returnBuildingAtSpecificCoordinates(new Point(0, 4));
			case 2:
				return manager.getCurrentCity().returnBuildingAtSpecificCoordinates(new Point(-4, 0));
			case 3:
				return manager.getCurrentCity().returnBuildingAtSpecificCoordinates(new Point(0, -4));
			case 4:
				return manager.getCurrentCity().returnBuildingAtSpecificCoordinates(new Point(4, 0));
			default:
				throw new IndexOutOfBoundsException("There is no Builidng object left");
		}
	}
	
	
	//WATCH OUT: the newCoordinates value is hardcoded, which means that if the distances change
	//there is going to be a good chance that also this variables in the respective windows have 
	//to change
	public void moveSquadAwayFromBuilding(Point newCoordinates) {
		movingLabel.setLocation(newCoordinates);
	}
	
	public void closeWindow() {
		dialog.dispose();
	}
	
	public void finishedWindow(MainGameWindow mainGameWindow) {
		manager.closeMainGameWindow(mainGameWindow);
	}
	
//	/**
//	 * @return the frame
//	 */
//	public JFrame getFrame() {
//		return dialog;
//	}
//
//
//	/**
//	 * @param frame the frame to set
//	 */
//	public void setFrame(JFrame frame) {
//		this.dialog = frame;
//	}
	
	/**
	 * @return the frame
	 */
	public JDialog getDialog() {
		return dialog;
	}


	/**
	 * @param frame the frame to set
	 */
	public void setDialog(JDialog newDialog) {
		this.dialog = newDialog;
	}

}
