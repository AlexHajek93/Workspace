package ers.beans;

public class ErsUser {
	private int id;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String email;
	private ErsRole role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ErsRole getRole() {
		return role;
	}
	public void setRole(ErsRole role) {
		this.role = role;
	}
	public ErsUser() {
		super();
	}
	public ErsUser(int id, String username, String password, String fname, String lname, String email, ErsRole role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}
	@Override
	public String toString() {
		return "ErsUser [id=" + id + ", username=" + username + ", password=ENCRYPTED, fname=" + fname + ", lname="
		    + lname + ", email=" + email + ", role=" + role + "]";
	}
}
