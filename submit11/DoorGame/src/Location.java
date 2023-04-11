import java.util.ArrayList;
import java.util.Arrays;

public class Location implements Nonmovable,PerTickofGame {
	
	private int locationId;
	private int counter;
	private int[] coordinate = new int [2]; /* {x,y}*/
	private int pop;
	private int hpConsumed;
	private int misfortune;
	private int timeRequried;
	private ArrayList<Npc> npcStayIn;
	
	public Location(int locationId, int counter, int[] coordinate, int pop, int hpConsumed, int misfortune,
			int timeRequried,ArrayList<Npc> npcStayIn) {
		super();
		this.locationId = locationId;
		this.counter = counter;
		this.coordinate = coordinate;
		this.pop = pop;
		this.hpConsumed = hpConsumed;
		this.misfortune = misfortune;
		this.timeRequried = timeRequried;
		this.npcStayIn = npcStayIn;
	}
	//getters and setters
	public ArrayList<Npc> getNpcStayIn() {
		return npcStayIn;
	}

	public void setNpcStayIn(ArrayList<Npc> npcStayIn) {
		this.npcStayIn = npcStayIn;
	}

	public void perTurn() {
		
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int[] getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(int[] coordinate) {
		this.coordinate = coordinate;
	}

	public int getPop() {
		return pop;
	}

	public void setPop(int pop) {
		this.pop = pop;
	}

	public int getHpConsumed() {
		return hpConsumed;
	}

	public void setHpConsumed(int hpConsumed) {
		this.hpConsumed = hpConsumed;
	}

	public int getMisfortune() {
		return misfortune;
	}

	public void setMisfortune(int misfortune) {
		this.misfortune = misfortune;
	}

	public int getTimeRequried() {
		return timeRequried;
	}

	public void setTimeRequried(int timeRequried) {
		this.timeRequried = timeRequried;
	}
	
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", counter=" + counter + ", coordinate="
				+ Arrays.toString(coordinate) + ", pop=" + pop + ", hpConsumed=" + hpConsumed + ", misfortune="
				+ misfortune + ", timeRequried=" + timeRequried + ", npcStayIn=" + npcStayIn + "]";
	}
	@Override
	public int findDistance(int[] dest) {
		// TODO Auto-generated method stub
		return 0;
	}
}
