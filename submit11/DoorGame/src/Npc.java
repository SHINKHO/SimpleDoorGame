import java.util.ArrayList;
import java.util.Arrays;

public class Npc implements PerTickofGame,Nonplayable {
	private int npcId;
	private String name;
	private int[] coordinate= new int[2];
	private ArrayList<Affection> affections= new ArrayList<>();
	
	public Npc(int npcId,int[] coordination, ArrayList<Affection> affections) {
		super();
		this.npcId = npcId;
		this.coordinate = coordination;
		this.affections = affections;
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

	public int[] getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(int[] coordinate) {
		this.coordinate = coordinate;
	}
	public ArrayList<Affection> getaffections() {
		return affections;
	}
	public void setaffections(ArrayList<Affection> affections) {
		this.affections = affections;
	}

	public void perTurn() {
		
	}
	@Override
	public String toString() {
		return "Npc [npcId=" + npcId + ", name=" + name + ", coordinate=" + Arrays.toString(coordinate)
				+ ", affections=" + affections + "]";
	}

	public int[] getWhere() {
		// TODO Auto-generated method stub
		return coordinate;
	}
	
	public Npc copy() {
		ArrayList<Affection> returnAffection = new ArrayList<>();
		for(Affection a : affections) {
			returnAffection.add(a.copy());
		}
		return new Npc(npcId,new int[] {coordinate[0],coordinate[1]},returnAffection);
	}

}
