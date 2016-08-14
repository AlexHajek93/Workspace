package ers.beans;

public class ErsType {
	private int id;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ErsType() {
		super();
	}
	public ErsType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	@Override
	public String toString() {
		return "ErsType [id=" + id + ", type=" + type + "]";
	}
}
