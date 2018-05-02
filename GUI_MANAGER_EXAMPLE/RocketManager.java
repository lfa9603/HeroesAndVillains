import java.util.ArrayList;

public class RocketManager {
	
	
	String name;
	ArrayList<Rocket> RocketList = new ArrayList<Rocket>();
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the rocketList
	 */
	public ArrayList<Rocket> getRocketList() {
		return RocketList;
	}
	/**
	 * @param rocketList the rocketList to set
	 */
	public void setRocketList(ArrayList<Rocket> rocketList) {
		RocketList = rocketList;
	}
	
	public void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeWindow();
	}
	
	public void launchSetUpScreen() {
		SetUpScreen setUpWindow = new SetUpScreen(this);
	}
	
	public void closeSetUpScreen(SetUpScreen setUpWindow) {
		setUpWindow.closeWindow();
		launchMainScreen();
	}
	
	
	public static void main(String[] args) {
		RocketManager manager = new RocketManager();
		manager.launchSetUpScreen();
	}
	
}
