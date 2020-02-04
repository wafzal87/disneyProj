package com.disney.test.util;

public class ShopPageData {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dateOfBirth;
	private String navElements;

	public ShopPageData(String firstName, String lastName, String email, String password, String dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}
			
	public ShopPageData(String firstName, String lastName, String email, String password, String phNumber,
			String navElements) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.navElements = navElements;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getdateOfBirth() {
		return dateOfBirth;
	}

	public String getNavElements() {
		return navElements;
	}

	@Override
	public String toString() {
		return "ShopPageData [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", phNumber=" + dateOfBirth + ", navElements=" + navElements + "]";
	}

}
