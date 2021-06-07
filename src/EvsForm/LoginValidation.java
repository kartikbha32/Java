package EvsForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginValidation {
	String uid,password;
	Connection con;
	ResultSet res;
	PreparedStatement stat;
	JOptionPane op;

	public LoginValidation(String uid, String password) {
		super();
		this.uid = uid;
		this.password = password;
	}
	
	public void Validate(JFrame f) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evs_team1_schema", "root", "Kartik@25");
			stat=con.prepareStatement("select * from user_credentials where userid=?");
			//Executes SQL Select Query and returns data as ResultSet Object
			
			stat.setString(1,uid);
			
			res=stat.executeQuery();
			op=new JOptionPane();
			System.out.println(password);
			
			if(res.next()==false) {
				JOptionPane.showMessageDialog(f, "Not Registered?");
			}
			else if(password.equals(res.getString("password"))){
				if(res.getString("loginstatus").equals("0")) {
					new NextPage().display(); 
					
					}
				else {
					JOptionPane.showMessageDialog(f, "Already Logged In");
				}
			}
				else {
					JOptionPane.showMessageDialog(f, "Wrong Password");
					System.out.println(res.getString(password));				}
				
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
