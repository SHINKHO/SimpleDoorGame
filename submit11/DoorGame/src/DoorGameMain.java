import java.util.ArrayList;

public class DoorGameMain {

	public static void main(String[] args) {
		Map map = Map.getInstance();
		for(Nonplayable l : map.getCopiedLocations()) {
		System.out.println(l.toString());
		}
		

		GameControl gc = new GameControl(map);
		
		int selection=-1;
		boolean isplayerset=false;
		while(true) {
			if(isplayerset == false) {
				gc.setPlayer();
				isplayerset=true;
			}
			if(gc.isAdmin()) {
				selection = gc.adminMenu();
				switch(selection) {
					case 1:	break;
					case 2:	break;
					case 3:	break;
					default : System.exit(0);
				}
			}else {
				selection = gc.userMenu();
				switch(selection) {
					case 1:	gc.user_viewMap();break;
					case 2:	gc.user_move();break;
					case 3:	break;
					default : System.exit(0);
				}	
			}
			
		}	
		//어드민 메뉴 물어보기
		/*테스트하던 라인
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
		*/
	}
	

}
