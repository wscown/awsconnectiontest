public class User {
	private int iduser;
	private String username;
	private String userpassword;
	
	public User() {}
	
	public User(String username, String userpassword) {
		this.username = username;
		this.userpassword = userpassword;
	}
	
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", username=" + username + ", userpassword=" + userpassword + "]";
	}
	
}