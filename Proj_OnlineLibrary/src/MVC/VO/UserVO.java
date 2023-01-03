package MVC.VO;

public class UserVO {

	private String id;
	private String nickname;
	private String pw;
	private String email;
	private String phone;
	private String identquest;
	private String identanswer;
	private String tier;

	
	
	public UserVO(String id, String nickname, String pw) {
		this.id = id;
		this.nickname = nickname;
		this.pw = pw;
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getNickname() {return nickname;}
	public void setNickname(String nickname) {this.nickname = nickname;}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getIdentquest() {return identquest;}
	public void setIdentquest(String identquest) {this.identquest = identquest;}
	public String getIdentanswer() {return identanswer;}
	public void setIdentanswer(String identanswer) {this.identanswer = identanswer;}
	public String getTier() {return tier;}
	public void setTier(String tier) {this.tier = tier;}
	
	
}