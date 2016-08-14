package ers.beans;

public class ErsRole {
	private int role;
	private String title;
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ErsRole() {
		super();
	}
	public ErsRole(int role, String title) {
		super();
		this.role = role;
		this.title = title;
	}
	@Override
	public String toString() {
		return "ErsRole [role=" + role + ", title=" + title + "]";
	}
}
