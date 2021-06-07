package EvsForm;


import java.awt.*;
import java.util.Date;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;

// 1.after clicking the submit button userid is created in action event

public class RegisterationForm implements ActionListener {
		private int c=1000;

		private String name,street,city,state,zip,MobileNo,email;
		private String UserType[]=new String[3];
		private String dob;
		private char gender;
		private String password;
		JComboBox comboBox;
		JPasswordField value;
		JLabel l_type;
		JFrame frame1;
		JTextField t1_name,t2_street,t3_city,t4_state,t5_zip,t6_MobileNo,t7_email,t8_dob;
		JButton bg1;
		JRadioButton r1,r2;
		Container ct;
	public void Register(){
		
		UserType[0]= "User";
		UserType[1]= "EO";
		UserType[2]= "Admin";
		
		frame1 = new JFrame("Registeration Form");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 400);
        JPanel frame=new JPanel();
        
        l_type=new JLabel("UserType");
        
        comboBox = new JComboBox(UserType);
        

        
        
        JLabel l1=new JLabel("name");
        t1_name = new JTextField(10);
        t1_name.setText("Amy");
        
        JLabel l10=new JLabel("password(Min. 8)");
        value = new JPasswordField(); 
        value.setText("Amy@1234");
        
        
        


        JLabel l2=new JLabel("street");
        t2_street = new JTextField(10);
        t2_street.setText("Sainik");
        

        JLabel l3=new JLabel("city");
        t3_city = new JTextField(10);
        t3_city.setText("Faridabad");
        

        JLabel l4=new JLabel("state");
        t4_state = new JTextField(10);
        t4_state.setText("Haryana");

        JLabel l5=new JLabel("zip");
        t5_zip = new JTextField(10);
        t5_zip.setText("121004");

        JLabel l6=new JLabel("MobileNo");
        t6_MobileNo = new JTextField(10);
        t6_MobileNo.setText("9999876543");

        JLabel l7=new JLabel("email");
        t7_email= new JTextField(10);
        t7_email.setText("am@gmail.com");

        JLabel l8=new JLabel("dob (YYYY-mm-dd)");
        t8_dob = new JTextField("YYYY-mm-dd",10);
        t8_dob.setText("1999-10-14");

        JLabel l9=new JLabel("gender");
        r1=new JRadioButton("A) Male");    
        r2=new JRadioButton("B) Female");
       

        //r1.setBounds(75,50,100,30);    
        //r2.setBounds(75,100,100,30);    
        ButtonGroup bg=new ButtonGroup();    
        bg.add(r1);
        bg.add(r2);
        
        bg1=new JButton("Submit");
        bg1.addActionListener(this);
        
        
        frame.add(comboBox);

        frame.add(l1);
        frame.add(t1_name);
        frame.add(l2);
        frame.add(t2_street);
        frame.add(l3);
        frame.add(t3_city);
        frame.add(l4);
        frame.add(t4_state);
        frame.add(l5);
        frame.add(t5_zip);
        frame.add(l6);
        frame.add(t6_MobileNo);
        frame.add(l7);
        frame.add(t7_email);
        frame.add(l8);
        frame.add(t8_dob);
        frame.add(l9);
        frame.add(r1);
        frame.add(r2);
        frame.add(bg1);
        frame.add(l10);
        frame.add(value);
        frame1.add(frame);
        
        
        //frame1.getContentPane().add(BorderLayout.SOUTH, frame);

        
        ct=frame1.getContentPane();
        
        
        
        
        

	
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String uid,usertype,gender,name,street,city,state,zip,MobileNo,email;
		String dob;
		String password;
		Date date=null;
		usertype=(String) comboBox.getSelectedItem();
		if(r2.isSelected())
			gender="F";
		else
			gender="M";
		name=(String) t1_name.getText();
		street=(String) t2_street.getText();
		city=(String) t3_city.getText();
		state=(String) t4_state.getText();
		zip=(String) t5_zip.getText();
		MobileNo=(String) t6_MobileNo.getText();
		email=(String) t7_email.getText();
		dob=(String) t8_dob.getText();
		password=(String) value.getText();
		
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		try {
		date = formatter.parse(dob);
		
		//System.out.println(formatter.format(date));
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		uid=name.substring(0,2)+c++;
		JOptionPane.showMessageDialog(frame1, "Userid="+uid);
		
		
		
		GenerateUserId g=new GenerateUserId(usertype,gender,name,street,city,state,zip,MobileNo,email,date,uid,password);
		
	System.out.println(usertype+gender+name+street+city+state+MobileNo+email);
	System.out.println(formatter.format(date));
	
	
		
	
	
	
	}
	
	 public JFrame getFrame1() {
		 return this.frame1;
	 }
		
		
		
		
		
}
	


