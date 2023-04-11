import java.util.ArrayList;

public class Npc implements PerTickofGame,Nonplayable {
	private int npcId;
	private String name;
	private int[] coordination= new int[2];
	private ArrayList<Affection> Affections= new ArrayList<>();
	
	public Npc(int npcId,int[] coordination, ArrayList<Affection> affections) {
		super();
		this.npcId = npcId;
		this.coordination = coordination;
		Affections = affections;
	}
	public int getNpcId() {
		return npcId;
	}
	public void setNpcId(int npcId) {
		this.npcId = npcId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getCoordination() {
		return coordination;
	}
	public void setCoordination(int[] coordination) {
		this.coordination = coordination;
	}
	public ArrayList<Affection> getAffections() {
		return Affections;
	}
	public void setAffections(ArrayList<Affection> affections) {
		Affections = affections;
	}

	public void perTurn() {
		
	}
	public Nonplayable returnAddress() {

		return null;
	}

}
