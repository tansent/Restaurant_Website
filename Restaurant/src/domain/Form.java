package domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Form implements Serializable{
	
	
	public Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Form(String username, String password, String email,
			String checkcode, Map<String, String> error) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.checkcode = checkcode;
		this.errors = error;
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
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public Map<String, String> getError() {
		return errors;
	}
	public void setError(Map<String, String> error) {
		this.errors = error;
	}
	private String username;
	private String password;
	private String cpassword;
	private String email;
	private String checkcode;
	private Map<String, String> errors = new LinkedHashMap<String, String>();
	
	
}
