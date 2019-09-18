package com.example.board.model;
 
public class MemberModel {
 
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_add;
    private int user_add_code;
    private boolean is_active;
    
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_add() {
		return user_add;
	}
	public void setUser_add(String user_add) {
		this.user_add = user_add;
	}
	public int getUser_add_code() {
		return user_add_code;
	}
	public void setUser_add_code(int user_add_code) {
		this.user_add_code = user_add_code;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
}