package EvsForm;

import java.awt.*;
import java.util.Date;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;

class LoginForm implements ActionListener {
	
	  JButton SUBMIT;
	  JPanel panel;
	  JLabel label1,label2;
	  JFrame frame;
	  JTextField  text1,text2;
	   public void Login()
	   {
	   label1 = new JLabel();
	   label1.setText("UserId:");
	   text1 = new JTextField(15);
	   
	   text1.setText("Am1000");
	 
	   label2 = new JLabel();
	   label2.setText("Password:");
	   text2 = new JPasswordField(15);
	
	   text2.setText("Amy@1234");
	  
	   SUBMIT=new JButton("SUBMIT");
	   frame=new JFrame();
	   
	   panel=new JPanel(new GridLayout(3,1));
	   panel.add(label1);
	   panel.add(text1);
	   panel.add(label2);
	   panel.add(text2);
	   panel.add(SUBMIT);
	   frame.add(panel,BorderLayout.CENTER);
	   SUBMIT.addActionListener(this);
	   frame.setTitle("LOGIN FORM");
	   frame.setSize(400,100);
	   }
	  public void actionPerformed(ActionEvent ae)
	   {
		 
	   String value1=text1.getText();
	   String value2=text2.getText();
	   LoginValidation lf=new LoginValidation(value1,value2);
	   lf.Validate(frame);
//	   if (value1.equals("roseindia") && value2.equals("roseindia")) {
//	   NextPage page=new NextPage();
//	   page.setVisible(true);
//	   JLabel label = new JLabel("Welcome:"+value1);
//	   page.getContentPane().add(label);
//	   }
//	   else{
//	   System.out.println("enter the valid username and password");
//	   JOptionPane.showMessageDialog(this,"Incorrect login or password",
//	   "Error",JOptionPane.ERROR_MESSAGE);
//	   }
	 }
	   
	   
	 public JFrame getFrame() {
			 return this.frame;
		 }
}
