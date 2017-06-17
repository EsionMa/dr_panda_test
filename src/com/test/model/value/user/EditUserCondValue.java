/**
 * 2017年4月9日 下午5:26:14
 */
package com.test.model.value.user;

import java.sql.Timestamp;

/**
 * @author Esion
 *
 */
public class EditUserCondValue {
	/** 用户ID */
	private String userId;
	/** 用户昵称 */
	private String userNickname;
	/** 用户真实姓名 */
	private String userRealName;
	/** 用户头像 */
	private String userHeadImg;
	/** 用户心情 */
	private String userMood;
	/** 用户邮箱 */
	private String userEmail;
	/** 年龄 */
	private Integer userAge;
	/** 性别 */
	private Integer userGender;
	/** 出生日期 */
	private Timestamp userBirth;
	/** 专业 */
	private String userMajor;
	/** 学校 */
	private String userSchool;
	/** 住址 */
	private String userAddress;

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return userNickname
	 */
	public String getUserNickname() {
		return userNickname;
	}

	/**
	 * @param userNickname 要设置的 userNickname
	 */
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	/**
	 * @return userRealName
	 */
	public String getUserRealName() {
		return userRealName;
	}

	/**
	 * @param userRealName 要设置的 userRealName
	 */
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	/**
	 * @return userHeadImg
	 */
	public String getUserHeadImg() {
		return userHeadImg;
	}

	/**
	 * @param userHeadImg 要设置的 userHeadImg
	 */
	public void setUserHeadImg(String userHeadImg) {
		this.userHeadImg = userHeadImg;
	}

	/**
	 * @return userMood
	 */
	public String getUserMood() {
		return userMood;
	}

	/**
	 * @param userMood 要设置的 userMood
	 */
	public void setUserMood(String userMood) {
		this.userMood = userMood;
	}

	/**
	 * @return userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail 要设置的 userEmail
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return userAge
	 */
	public Integer getUserAge() {
		return userAge;
	}

	/**
	 * @param userAge 要设置的 userAge
	 */
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	/**
	 * @return userGender
	 */
	public Integer getUserGender() {
		return userGender;
	}

	/**
	 * @param userGender 要设置的 userGender
	 */
	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	/**
	 * @return userBirth
	 */
	public Timestamp getUserBirth() {
		return userBirth;
	}

	/**
	 * @param userBirth 要设置的 userBirth
	 */
	public void setUserBirth(Timestamp userBirth) {
		this.userBirth = userBirth;
	}

	/**
	 * @return userMajor
	 */
	public String getUserMajor() {
		return userMajor;
	}

	/**
	 * @param userMajor 要设置的 userMajor
	 */
	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}

	/**
	 * @return userSchool
	 */
	public String getUserSchool() {
		return userSchool;
	}

	/**
	 * @param userSchool 要设置的 userSchool
	 */
	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}

	/**
	 * @return userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress 要设置的 userAddress
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EditUserCondValue [userId=" + userId + ", userNickname=" + userNickname + ", userRealName=" + userRealName + ", userHeadImg=" + userHeadImg + ", userMood=" + userMood + ", userEmail=" + userEmail + ", userAge=" + userAge + ", userGender=" + userGender + ", userBirth=" + userBirth + ", userMajor=" + userMajor + ", userSchool=" + userSchool + ", userAddress=" + userAddress + "]";
	}

}
