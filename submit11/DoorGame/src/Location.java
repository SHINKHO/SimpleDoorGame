import java.util.ArrayList;
import java.util.Arrays;

public class Location implements Nonmovable,PerTickofGame,Nonplayable {
	
	private int locationId;
	private String locationName;

	private int counter;
	private int[] coordinate = new int [2]; /* {x,y}*/
	private int pop;
	private int goldCost;
	private int misfortune;
	private int timeRequried;
	private ArrayList<Npc> npcStayIn = new ArrayList<Npc>();
	
	public Location() {
		
	}
	public Location(int locationId,String locationName, int counter, int[] coordinate, int pop, int goldCost, int misfortune,
			int timeRequried) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.counter = counter;
		this.coordinate = coordinate;
		this.pop = pop;
		this.goldCost = goldCost;
		this.misfortune = misfortune;
		this.timeRequried = timeRequried;
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
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public int getGoldCost() {
		return goldCost;
	}
	public void setGoldCost(int goldCost) {
		this.goldCost = goldCost;
	}
	
	public void addNpc(Npc npc) {
		npcStayIn.add(npc);
	}
	
	public Npc takeNpc(Npc npc) {
		for(int i = 0 ;i<npcStayIn.size();i++) {
			if(npcStayIn.get(i).getNpcId()==npc.getNpcId()) {
				
				return npcStayIn.remove(i);
			}
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName +", counter=" + counter + ", coordinate="
				+ Arrays.toString(coordinate) + ", pop=" + pop + ", goldCost=" + goldCost + ", misfortune="
				+ misfortune + ", timeRequried=" + timeRequried + ", npcStayIn=" + npcStayIn + "]";
	}
	@Override
	/**
	 * give approximate distance from dest to here
	 */
	public int findDistance(int[] dest) {
		//x^2 + y^2 = z^2
		return (int)Math.sqrt(Math.pow((dest[0]-coordinate[0]),2) + Math.pow((dest[1]-coordinate[1]),2));
	}

	public int[] getWhere() {
		return coordinate;
	}
	public Location copy() {
		return new Location(locationId,locationName,counter,new int[]{coordinate[0],coordinate[1]},pop,goldCost,misfortune,timeRequried);
	}
}