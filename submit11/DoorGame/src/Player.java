import java.util.ArrayList;

public class Player implements PerTickofGame{
	private int gold;
	private int hp;
	private int speed;
	private int luck;
	private int[] coordinate = new int[] {0,0};
	private ArrayList<Npc> companions;
	public int[] getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(int[] coordinate) {
		this.coordinate = coordinate;
	}
	public Player(int gold, int hp, int speed, int luck, ArrayList<Npc> companions) {
		super();
		this.gold = gold;
		this.hp = hp;
		this.speed = speed;
		this.luck = luck;
		this.companions = companions;
	}
	public Player(int gold, int hp, int speed, int luck) {
		super();
		this.gold = gold;
		this.hp = hp;
		this.speed = speed;
		this.luck = luck;
		this.companions = new ArrayList<Npc>();
		Npc ch = new Npc(001,"의자","낡은 의자이다");
		ch.setLocationinstance(null);
		companions.add(new Npc(001,"의자","낡은 의자이다"));
		
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getLuck() {
		return luck;
	}
	public void setLuck(int luck) {
		this.luck = luck;
	}
	public ArrayList<Npc> getCompanions() {
		return companions;
	}
	public void setCompanions(ArrayList<Npc> companions) {
		this.companions = companions;
	}
	public void goingTo(char dir) {
		switch (dir) {
		case 'N': this.coordinate[1]++;
					break;
		case 'S': this.coordinate[1]--;
					break;
		case 'W': this.coordinate[0]--;
					break;
		case 'E': this.coordinate[0]++;
					break;
			default : break;
		}
	}
	@Override
	public void perTurn() {
		// TODO Auto-generated method stub
		
	}
}
