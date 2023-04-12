
public class Affection {
	private String type;
	private int number;
	public Affection(String type,int number) {
		this.type = type;
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Affection [type=" + type + ", number=" + number + "]";
	}
	public Affection copy() {
		return new Affection(type,number);
	}
	
	
}
