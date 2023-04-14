import java.util.ArrayList;
import java.util.Scanner;

public class GameControl {

	private boolean isAdmin = false;
	private int[] screenSize = new int[] {180,90};
	private Map map;
	private Player player;
	private Scanner scan = new Scanner(System.in);
	private final char[] BORDER_EDGES = new char[]{'━','┃'};/* x and y */
	private final char[] BORDER_VERTEXS = new char[] {'┏','┓','┗','┛'};/*clockwise from northwest*/
	private ArrayList<PointedString> bucketOfAsker = new ArrayList<PointedString>();
	public GameControl(Map map) {
		init();
		this.map = Map.getInstance();
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public Map getMap() {
		return map;
	}


	/*there are two mode in control
	 * 1.Admin mode , adding piece such as location or npc 
	 * 2.Plyaer mode , play by the rule
	 * when this object is initiated, the program will ask which mode user would like to choose.(default non-admin)
	 * After choosing a user type, user will make a screen size for the total game
	 * since Linux Terminal could set the size , UI that made by the size would suit for entire gameplay( the Most used ratio of screen, 180:90 would be selected) 
	 *
	 * Each game control contains a Map instance which is singleton. so then, although there were several actions would be done to the map , there would be 
	 * only one map would be affected
	 */
	private void init() {
		System.out.println("Setting up screen size.");
		boolean done=false;
		while(!done) {
			System.out.println("enter the size of Screen (use x,y format)");
			System.out.print(">>>");
			try {
				String sin= scan.nextLine();
				String[] scrsz=sin.trim().split(",");
				this.screenSize[0] = Integer.parseInt(scrsz[0]);
				this.screenSize[1] = Integer.parseInt(scrsz[1]);
			}catch(Exception x) {
				System.out.println("wrong input");
				continue;
			}
			//ask if the user want to use admin mode
			this.bucketOfAsker = new ArrayList<>(); 
			PointedString asker = new PointedString(new int[] {screenSize[0]/4,0},"Do you want to proceed in Admin mode?");
			bucketOfAsker.add(asker);
			asker = new PointedString(new int[] {screenSize[0]/4-5,3},"You can add or change NPC of the game or Modify Game Environment");
			bucketOfAsker.add(asker);
			asker = new PointedString(new int[] {screenSize[0]/4-3,5},"Enter Y or Yes to proceed as Admin N if you don't");
			bucketOfAsker.add(asker);
			printsInBox(bucketOfAsker);
			try {
				char selad = scan.nextLine().charAt(0);
				isAdmin = (selad=='Y'||selad=='y') ? true : false;
				break;
			}catch(Exception x) {
				asker = new PointedString(new int[] {screenSize[0]/2,screenSize[1]/2},"wrong input");
				bucketOfAsker.add(asker);
				continue;
			}
		}
	}
	
	/*
	 * I guess this should be ui related obejct need to be implemented, this spoils entire code as its volume
	 */
	public int adminMenu(){
		while (true) {
			this.bucketOfAsker = new ArrayList<>(); 
			String stringToPrint = "ADMIN MODE";
			PointedString asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),0},stringToPrint);
			bucketOfAsker.add(asker);
			stringToPrint = "1. NPC CONFIGURATION(NOT YET DEVELOPED)";
			asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2-2},stringToPrint);
			bucketOfAsker.add(asker);
			stringToPrint = "2. GLOBAL VARIABLE CONFIGURATION(NOT YET DEVELOPED)";
			asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2},stringToPrint);
			bucketOfAsker.add(asker);
			stringToPrint = "3. LOCATION CONFIGURATION(NOT YET DEVELOPED)";
			asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2+2},stringToPrint);
			bucketOfAsker.add(asker);
			printsInBox(bucketOfAsker);
			
	
			try {
				String userSelection = scan.nextLine();
				return Integer.parseInt(userSelection);
			}catch(Exception e) {
				stringToPrint = "INPUT HAS SOME PROBLEM, TRY AGAIN";
				asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),0},stringToPrint);
				bucketOfAsker.add(asker);
			}
		}
	}
	
	/*
	 * needs some automation using loop
	 */
	public void setPlayer() {
		bucketOfAsker = new ArrayList<>(); int[] xay= {screenSize[0]/2,screenSize[1]/2};
		
		String stringToPrint = "ADMIN MODE";
		PointedString asker = new PointedString(new int[] {xay[0]-stringToPrint.length(),0},stringToPrint);
		bucketOfAsker.add(asker);
		
		stringToPrint = "IT SEEMES LIKE YOU ARE AT THE FIRST TIME TO JOIN THE GAME";
		xay = new int[] {xay[0]-stringToPrint.length(),xay[1]};
		asker = new PointedString(xay,stringToPrint);
		bucketOfAsker.add(asker);
		
		xay = new int[] {xay[0]-stringToPrint.length(),xay[1]+2};
		stringToPrint = "PLEASE WRITE DOWN INFORMATION";
		asker = new PointedString(xay,stringToPrint);
		bucketOfAsker.add(asker);
		
		xay = new int[] {xay[0]-stringToPrint.length(),xay[1]+4};
		stringToPrint = "FORM OF gold,hp,speed,luck";
		asker = new PointedString(xay,stringToPrint);
		bucketOfAsker.add(asker);
		
		printsInBox(bucketOfAsker);
		
		String[] input = scan.nextLine().split(",");
		int[] status = new int[] {Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3])};
		
		this.player = new Player(status[0], status[1],status[2],status[3]);
	}
	
	public int userMenu() {
		while(true) {
			bucketOfAsker = new ArrayList<>(); 
			String stringToPrint = "PLAYER MODE";
			PointedString asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),0},stringToPrint);
			bucketOfAsker.add(asker);
			stringToPrint = "1. VIEW MAP";
			asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2-4},stringToPrint);
			bucketOfAsker.add(asker);
			stringToPrint = "2. MOVE";
			asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2-2},stringToPrint);
			bucketOfAsker.add(asker);
			stringToPrint = "3. CHECK ITEM(NOT YET DEVELOPED)";
			asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2-0},stringToPrint);
			bucketOfAsker.add(asker);
			stringToPrint = "4. CHECK CURRENT SPOT(NOT YET DEVELOPED)";
			asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2+2},stringToPrint);
			bucketOfAsker.add(asker);
			stringToPrint = "5. SEARCH HIDDEN NPC(NOT YET DEVELOPED)";
			asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2+4},stringToPrint);
			bucketOfAsker.add(asker);
			printsInBox(bucketOfAsker);
			try {
				String userSelection = scan.nextLine();
				return Integer.parseInt(userSelection);
			}catch(Exception e) {
				stringToPrint = "INPUT HAS SOME PROBLEM, TRY AGAIN";
				asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),0},stringToPrint);
				bucketOfAsker.add(asker);
				printsInBox(bucketOfAsker);
			}
		}
		
	}
	
	/* Drawing Screen could need Specific Characters. To avoid hard coding, Array of Characters must be used.
	 * the size of message box would be a Field Variable that is array of int. index 0 notes x and index 1 notes y
	 *  ArrayList<PointedString> informations informations contains the cursor as Integer[] and message as String 
	 * ┏━━━━━━━━━━━━━━━━━━━━━(x pointer at y=0, till that, '━'would be printed, after the stringlength , print '━')━━━━━━━━┓ 
	 * ┃(first of each line should be character '┃'
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public void printsInBox(ArrayList<PointedString> informations){
		
		//print top border with anything if in the y=0;
		PointedString topString = new PointedString(new int[] {0,0},"");
		for (PointedString information : informations) {
			if(information.getPoint()[1]==0)topString=information;
			break;
		}
		
		System.out.print(BORDER_VERTEXS[0]);
		for(int i =1; i<topString.getPoint()[0];i++) {
			System.out.print(BORDER_EDGES[0]);
		}
		System.out.print(topString.getString());
		for(int i =topString.getPoint()[0]+topString.getString().length()-1; i<screenSize[0]-1;i++) {
			System.out.print(BORDER_EDGES[0]);
		}
		System.out.println(BORDER_VERTEXS[1]);
		
		//print content
		for(int y=1;y<screenSize[1];y++) {
			//if something match on y, get it to print;
			PointedString contentString = new PointedString(new int[] {0,0},"");
			for(int i = 0 ; i<informations.size();i++) {
				if(informations.get(i).getPoint()[1] == y) {
					contentString = informations.get(i);
					break;
				}
			}
			System.out.print(BORDER_EDGES[1]);
			//print padding till the point of contentString
			for(int x=1;x<contentString.getPoint()[0];x++) {
				System.out.print(' ');
			}
			//print the content
			System.out.print(contentString.getString());
			//print the rest padding
			if(contentString.getString().trim().length()!=0) {
				for(int x=contentString.getPoint()[0]+contentString.getString().trim().length();x<screenSize[0];x++) {
					System.out.print(' ');
				}
			}else {
				for(int x=contentString.getPoint()[0]+contentString.getString().trim().length();x<screenSize[0];x++) {
					System.out.print(' ');
				}
			}
			System.out.println(BORDER_EDGES[1]);
		}
		//bottom got no text.
		System.out.print(BORDER_VERTEXS[2]);
		for(int i=1;i<screenSize[0];i++)System.out.print(BORDER_EDGES[0]);
		System.out.println(BORDER_VERTEXS[3]);
	}	
	
	public void user_viewMap(){
		ArrayList<PointedString> bucketOfAsker = new ArrayList<>(); 
		String stringToPrint = "PLAYER MODE";
		PointedString asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),0},stringToPrint);
		bucketOfAsker.add(asker);
		stringToPrint = "PLEASE CHOOSE THE AREA YOU WANT TO SEE";
		asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2-2},stringToPrint);
		bucketOfAsker.add(asker);
		
		stringToPrint = "Minimum x and y , form of x,y :";
		asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2},stringToPrint);
		bucketOfAsker.add(asker);
		printsInBox(bucketOfAsker);
		
		String[] input = scan.nextLine().trim().split(",");
		int[] mins = new int[] {Integer.parseInt(input[0]),Integer.parseInt(input[1])};
		
		stringToPrint = "Maximum x and y , form of x,y :";
		asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2+2},stringToPrint);
		bucketOfAsker.add(asker);
		printsInBox(bucketOfAsker);
		
		input = scan.nextLine().split(",");
		int[] maxs = new int[] {Integer.parseInt(input[0]),Integer.parseInt(input[1])};
		
		View v = new View(mins,maxs);
		ArrayList<Nonplayable> spots = map.getCopiedLocations();//is map vacant?
		v.addSpots(spots);
		v.setPlayerAt(player.getCoordinate());
		
		v.printView();

	}
	public void user_move(){
		ArrayList<PointedString> bucketOfAsker = new ArrayList<>(); 
		String stringToPrint = "PLAYER MODE";
		PointedString asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),0},stringToPrint);
		bucketOfAsker.add(asker);
		stringToPrint = "WHERE DO YOU WANT TO MOVE?";
		asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2-2},stringToPrint);
		bucketOfAsker.add(asker);
	
		stringToPrint = "NORTH -N , SOUTH -S , WEST-W , EAST -E";
		asker = new PointedString(new int[] {screenSize[0]/2-stringToPrint.length(),screenSize[1]/2},stringToPrint);
		bucketOfAsker.add(asker);
		printsInBox(bucketOfAsker);
		char s = scan.nextLine().charAt(0);
		player.goingTo(s);
	}
	
}
