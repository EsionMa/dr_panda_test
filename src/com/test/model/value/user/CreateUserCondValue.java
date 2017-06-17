/**
 * CreateUserCondValue.java
 * 
 * 2017
 * 
 * Esion
 */
package com.test.model.value.user;

/**
 * @author Esion
 *
 */
public class CreateUserCondValue {
	private String userName;
	private String password;
	private String lastName;
	private String firstName;

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName 要设置的 lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName 要设置的 firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreateUserCondValue [userName=" + userName + ", password=" + password + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}

}
