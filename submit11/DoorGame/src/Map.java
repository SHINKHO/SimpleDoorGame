import java.util.ArrayList;
import java.util.Arrays;

public class Map {
	private ArrayList<Location> locations = new ArrayList<>();
	private ArrayList<Npc> npcs = new ArrayList<>();
	private int[] maxCoordinate = new int[]{-1,-1};
	private static Map instance= new Map();
	
	private Map() {
		locations.add(new Location(000,"시작지점", 100,new int[] {0,0}, 100, 0, 0,
				0));
	}
	
	public static Map getInstance() {
		return instance;
	}
	
	public void addNpc(Npc npc,int[] coordi) {
		for(int i = 0 ; i<locations.size();i++) {
			if(coordi[0]==locations.get(i).getWhere()[0]&&
				coordi[1]==locations.get(i).getWhere()[1]) {			
				npc.setLocationinstance(locations.get(i));
				locations.get(i).addNpc(npc);
			}
		}
		this.npcs.add(npc);
	}
	public void matchNpc(Npc npc) {
		for(int i = 0 ; i<locations.size();i++) {
			if(npc.getWhere()[0]==locations.get(i).getWhere()[0]&&
					npc.getWhere()[1]==locations.get(i).getWhere()[1]) {
				npc.setLocationinstance(locations.get(i));
				locations.get(i).addNpc(npc);
			}
		}
		
	}
	
	//printing of giving user a msg that could be helpful to the shit 
	public String getInfoOf(int[] coordi){
		String returnString="";
		for(Location l : locations) {
			if(l.getCoordinate()[0]==coordi[0]&&l.getCoordinate()[1]==coordi[1]) {
				returnString +=l.toString();
				for(Npc n : npcs) {
					if(n.getLocationinstance()==l) {
						returnString+=n.toString();
					}
				}
				return returnString;
			}
		}
		return null;
		
	}
	
	/**
	 * remove everything on the coordinate[x,y] and return pop
	 * @param x : coordinate of x;
	 * @param y : coordinate of y;
	 * @return popGotRemoved : POP damaged from destroyed city
	 */
	public int destroyLocation(int x,int y) {
		int popGotRemoved = 0;
		for(Location l : locations) {
			if(l.getCoordinate()[0]==x&&l.getCoordinate()[1]==y) {
				for(Nonplayable n : npcs) {
					if(n.getWhere()[0]==x&&n.getWhere()[1]==y) {
						npcs.remove(n);
					}
				}
				popGotRemoved = l.getPop();
				locations.remove(l);
				break;
			}
		}
		return popGotRemoved;
	}
	
	/**
	 * Every time the map got new location, this process check if there is a new max coordinate is added
	 * @return if it is any change, return true; else false
	 */
	public boolean findMaxLocation() {
		boolean isChanged = false;
		for(Location n : locations) {
			int tempX=n.getCoordinate()[0];
			int tempY=n.getCoordinate()[1];
			if(tempX>maxCoordinate[0]) {
				maxCoordinate[0] = tempX;
				isChanged= true;
			}
			if(tempY>maxCoordinate[1]) {
				maxCoordinate[1] = tempY;
				isChanged = true;
			}
		}
		return isChanged;
	}
	
	/**
	 * Adding of Location here
	 * @param the location you want to add here
	 */
	public void addLocation(Location newLoc) {
		newLoc.setLocationId(lastLocationId()+1);
		locations.add(newLoc);
		if(findMaxLocation())System.out.println("due to adding new location, new max Coordination is set x:"+maxCoordinate[0]+" y:"+maxCoordinate[1]);
	}
	
	public Location[] getCopiedLocations(){
		Location[] returnArray = new Location[locations.size()];
		for(int i = 0 ; i<returnArray.length;i++) {
			returnArray[i] = locations.get(i).copy();
		}
		return returnArray;
	}
	
	public int lastLocationId() {
		int lastId=0;
		for(Location l : locations) {
			if(l.getLocationId()>lastId)lastId=l.getLocationId();
		}
		return lastId;
	}

	public ArrayList<Npc> getNpcs() {
		return npcs;
	}
	public Location getLocationInstanceAt(int[] coordi) {
		for(int i =0; i<locations.size();i++) {
			if(locations.get(i).getWhere()[0]==coordi[0]&&locations.get(i).getWhere()[1]==coordi[1])return locations.get(i); 
		}
		return null;
	}

	public int[] getMaxCoordinate() {
		return maxCoordinate;
	}
	
}
