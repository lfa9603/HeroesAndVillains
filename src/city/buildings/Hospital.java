package city.buildings;

import characters.HeroesSquad;

public class Hospital extends Building {
	
	private static final TypeBuildings HOSPITAL_TYPE = TypeBuildings.Hospital; 


	public Hospital(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void interact(HeroesSquad heroesSquad) {
		// TODO Auto-generated method stub
		
	}
	
	public static TypeBuildings getHospitalType() {
		return HOSPITAL_TYPE;
	}
}
