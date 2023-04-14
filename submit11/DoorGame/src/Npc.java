import java.util.ArrayList;
import java.util.Arrays;

public class Npc implements PerTickofGame,Nonplayable {
	private int npcId;
	private String name;
	private Location locationInstance;
	private ArrayList<Affection> affections= new ArrayList<>();
	private String comment = "";
	private boolean hidden = true;
	
	public Npc(int npcId,String name, ArrayList<Affection> affections,String comment) {
		super();
		this.name = name;
		this.npcId = npcId;
		this.affections = affections;
		this.comment = comment;
	}
	public Npc(int npcId,String name,String comment) {
		super();
		this.name = name;
		this.npcId = npcId;
		this.comment = comment;
	}
	public void hideNpc() {
		this.hidden = true;
	}
	public void revealNpc() {
		this.hidden = false;
	}
	public boolean isHidden() {
		return this.hidden;
	}
	public Location getLocationinstance() {
		return this.locationInstance;
	}
	public void setLocationinstance(Location locationInstance) {
		this.locationInstance = locationInstance;
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
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommnet() {
		return this.comment;
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
		if(locationInstance !=null) {
		return "Npc [npcId=" + npcId + ", name=" + name + ", coordinate=" + Arrays.toString(locationInstance.getWhere())
				+ ", affections=" + affections + "]"+"\n comment ["+comment+"]" ;
		}else {
		return "Npc [npcId=" + npcId + ", name=" + name + ", coordinate=" + null
		+ ", affections=" + affections + "]"+"\n comment ["+comment+"]" ;
		}
	}

	public int[] getWhere() {
		return locationInstance.getWhere();
	}
	
	public Npc copy() {
		ArrayList<Affection> returnAffection = new ArrayList<>();
		for(Affection a : affections) {
			returnAffection.add(a.copy());
		}
		return new Npc(npcId,name,returnAffection,comment);
	}

}
