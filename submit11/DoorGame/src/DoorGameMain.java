import java.util.ArrayList;

public class DoorGameMain {

	public static void main(String[] args) {
		// TODO 
		Map map = Map.getInstance();
		map.addLocation(new Location(0,"테스트용",100, new int[] {2,2}, 100, 5, 10,30));
		View aView = new View(new int[]{0,0},new int[] {100,100});
		aView.addSpots(map.getCopiedLocations());
		aView.printView();
		aView.setPlayerAt(new int[] {0,0});
		aView.printView();
		aView.setPlayerAt(new int[] {2,0});
		aView.printView();
		System.out.println(System.identityHashCode(map.getLocationInstanceAt(new int[] {2,2}))+map.getInfoOf(new int[] {2,2}));
		System.out.println(System.identityHashCode(map.getLocationInstanceAt(new int[] {0,0}))+map.getInfoOf(new int[] {0,0}));
		System.out.println(System.identityHashCode(map.getLocationInstanceAt(new int[] {1,1}))+map.getInfoOf(new int[] {1,1}));
		Npc chair = new Npc(001,"의자","낡은 의자이다");
		map.addNpc(chair,new int[] {0,0});
		System.out.println(map.getInfoOf(new int[] {0,0}));
	}
	
//	public static void printLocInMap(Map map) {
//		for(int i=0;i<map.getCopiedLocations().length;i++) {
//			Location a= map.getLocationInstanceAt(map.getCopiedLocations()[i].getWhere());
//			System.out.println("index" +i+" location at : "+System.identityHashCode(a)
//			+"with object " +map.getLocationInstanceAt(map.getCopiedLocations()[i].getWhere()).getNpcStayIn().toString());
//		}
//	}
}
