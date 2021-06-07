package EvsForm;

import java.util.Date;

public class User {
	private String UserId;
	private String Name,Street,city,state,zip,MobileNo,Email;
	private Date Dob;
	private char Gender;
	public User(String userId, String name, String street, String city, String state, String zip, String mobileNo,
			String email, Date dob, char gender) {
		super();
		UserId = userId;
		Name = name;
		Street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		MobileNo = mobileNo;
		Email = email;
		Dob = dob;
		Gender = gender;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getDob() {
		return Dob;
	}
	public void setDob(Date dob) {
		Dob = dob;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	
	
	

}
