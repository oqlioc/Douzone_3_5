package com.example.board.model;
 
public class MemberModel {
 
    private String userId;
    private String userPw;
    private String userName;
    private String userAdd;
    private int userAddCode;
    private Boolean isActive;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAdd() {
		return userAdd;
	}
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
	public int getUserAddCode() {
		return userAddCode;
	}
	public void setUserAddCode(int useAddCode) {
		this.userAddCode = useAddCode;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "MemberModel [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userAdd="
				+ userAdd + ", userAddCode=" + userAddCode + ", isActive=" + isActive + "]";
	}
	
}