package co.kr.sist.team.login.vo;

public class LoginVO {
	private String id, password;

	public LoginVO(String id, String password) {
		this.id = id;
		this.password = password;
	}// 古鯵持失切

	public String getId() {
		return id;
	}// getId

	public String getPassword() {
		return password;
	}// getPassword

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", password=" + password + "]";
	}// toString

}// class