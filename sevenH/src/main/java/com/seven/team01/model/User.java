package com.seven.team01.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	@NotBlank(message="아이디를 입력해주세요")
	private String userID;
	@NotBlank(message="비밀번호를 입력해주세요")
	private String userPwd;
	@NotBlank(message="이름을 입력해주세요")
	private String userName;
	@NotBlank(message="이메일을 입력해주세요")
	private String userEmail;
	@Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다")
	private String userPhone;
	private String userAddress;
	private Date   userRegdate;
	private int    adminYN;
	
	public  String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(Date userRegdate) {
		this.userRegdate = userRegdate;
	}
	public int getAdminYN() {
		return adminYN;
	}
	public void setAdminYN(int adminYN) {
		this.adminYN = adminYN;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userPwd=" + userPwd + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", userAddress=" + userAddress + ", userRegdate=" + userRegdate
				+ ", adminYN=" + adminYN + "]";
	}

	
}
