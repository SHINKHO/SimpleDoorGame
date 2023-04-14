import java.util.ArrayList;

public class View {
	private int curMax[] = new int[2];
	private int curMin[] = new int[2];
	private int playerAt[] = new int[]{-1,-1};
	private ArrayList<Nonplayable> spot = new ArrayList<>();
	int scale = 1;
	
	public View(int[] curMin,int[] curMax) {
		this.curMin = curMin;
		this.curMax = curMax;
	}
	
	public void addSpot(Nonplayable newLoc) {
		spot.add(newLoc);
	}
	public void addSpots(ArrayList<Nonplayable> newLocs) {
		for(Nonplayable n : newLocs) spot.add(n);
	}
	public void setPlayerAt(int[] coordi) {
		playerAt[0]= coordi[0];
		playerAt[1]= coordi[1];
	}
	
	// TODO something doens't got well,
	public void printView() {
		String lastLineofX="";
		String vacantFromYNote="";
		//finding the least length of y notifier
		int vacantNumFromYNote = 0;
		int tYNote = curMax[1];
		for(int i =1; tYNote/10>0;i++) {
			vacantNumFromYNote=i;
			tYNote/=10;
		}
		for(int i=0;i<=vacantNumFromYNote;i++) {
			vacantFromYNote+=" ";
		}
		
		for(int y=curMax[1];y>=curMin[1];y--) {
			//y printer
			System.out.print(y);
			//space from y note to the map calculator
			String spacer = ""; int spacerCount=0;
			int tempY=y;
			
			for(int i=0;i<vacantNumFromYNote&&tempY/10!=0;i++) {
				spacerCount++;
				tempY/=10;
			}
			for(int i=spacerCount;i<vacantNumFromYNote;i++) {
				spacer+=" ";
			}
			System.out.print(spacer);
			//x printer
 			for(int x=curMin[0];x<curMax[0];x++) {
				// TODO change the print x to per type of object
  				int numInThere=0;
 					for(Nonplayable n : spot) {
						if(n.getWhere()[0]==x&&n.getWhere()[1]==y) { // this should be changed per ranged like if the salce is 2 , 1 to 10 , spot at 1 and 2 is grouped together
							numInThere++; 
						}
					}
 				if(playerAt[0]==x&&playerAt[1]==y) {
 					System.out.print("P");
 				}else if(numInThere >0) {
 					System.out.print(numInThere);
 				}else {
 					System.out.print("-");
 				}
 				if(y==0)lastLineofX+=(x)%10;
			}
			System.out.println();
		}
		System.out.println(vacantFromYNote+lastLineofX);
		
		//the 10th things
		System.out.print(vacantFromYNote);

		for(int i=curMin[0]; i<=curMax[0];i+=10) {
			int numDigits=1;int tempI=i;
			while(tempI>9) {
				tempI/=10;
				numDigits++;
			}

			int spaces = 10- numDigits;
            System.out.print(i);

            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
		}
		System.out.println();
	}

}
