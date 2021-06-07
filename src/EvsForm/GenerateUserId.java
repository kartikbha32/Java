package EvsForm;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateUserId {
	String usertype,gender,name,street,city,state,zip,MobileNo,email,uid,password,loginstatus="0";
	
	Date date;
	Connection con;
	ResultSet res;
	PreparedStatement stat,stat1;
	
	
	
	public GenerateUserId(String usertype, String gender, String name, String street, String city, String state,
			String zip, String mobileNo, String email, Date date,String uid,String password) {
		super();
		this.date=date;
		this.usertype = usertype;
		this.gender = gender;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.MobileNo = mobileNo;
		this.email = email;
		this.uid=uid;
		this.password=password;
		
		try 
		{
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evs_team1_schema", "root", "Kartik@25");
			 stat=con.prepareStatement("Insert into user(name,dob,gender,street,state,city,emailid,mobileno,zip,userid) "
			 		+ "values(?,?,?,?,?,?,?,?,?,?)");
			 //int id=50;
			 
			 stat1=con.prepareStatement("Insert into user_credentials(userid,password,usertype,loginstatus) "
				 		+ "values(?,?,?,?)");
			 
			 
			 
			 stat.setString(1,name);
			 stat.setDate(2, new java.sql.Date(date.getTime()));
			 stat.setString(3,gender);
			 stat.setString(4,street);
			 stat.setString(5,state);
			 stat.setString(6,city);
			 stat.setString(7,email);
			 stat.setString(8,MobileNo);
			 stat.setString(9,zip);
			 stat.setString(10, uid);
			 
			 stat1.setString(1, uid);
			 stat1.setString(2, password);
			 stat1.setString(3, usertype);
			 stat1.setString(4, loginstatus);
			 
			 
			 
			 stat.executeUpdate();
			 
			 stat1.executeUpdate();
			 
			 //res=stat.executeQuery("select * from evs_team1_schema");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	



}
