
public class DoorGameMain {

	public static void main(String[] args) {
		// TODO 
		Map map = Map.getInstance();
		map.addLocation(new Location(0,"테스트용",100, new int[] {2,2}, 100, 5, 10,30));
		View aView = new View(new int[]{0,0},new int[] {100,100});
		aView.printView();
	}

}
