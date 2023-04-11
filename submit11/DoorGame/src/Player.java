import java.util.ArrayList;

public class Player implements PerTickofGame{
	private int gold;
	private int hp;
	private int speed;
	private int luck;
	private ArrayList<Npc> companions;
	public Player(int gold, int hp, int speed, int luck, ArrayList<Npc> companions) {
		super();
		this.gold = gold;
		this.hp = hp;
		this.speed = speed;
		this.luck = luck;
		this.companions = companions;
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
	@Override
	public void perTurn() {
		// TODO Auto-generated method stub
		
	}
}
