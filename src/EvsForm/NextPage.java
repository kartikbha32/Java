package EvsForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  
class NextPage extends JFrame
 {
	Container ct;
	JLabel l1,l2;
	JButton b,b2;
	JPanel panel;
   NextPage()
  {
  setDefaultCloseOperation(javax.swing.
   WindowConstants.DISPOSE_ON_CLOSE);
  setTitle("Welcome");
  setSize(400, 200);
  setVisible(true);
   }
   
   public void display() {
	   l1=new JLabel("Results will be announced on 27-04-2021");
	   b=new JButton("Cast Vote");
	   b2=new JButton("View Results");
	   b.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   new CastVote().cast();
		   }
	   });
	   
	   b2.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   new ViewResults().viewRes();
		   }
	   });
	   
	   panel=new JPanel();
	   panel.add(l1);
	   panel.add(b);
	   panel.add(b2);
	   add(panel);
	   ct=getContentPane();
   }
   public JFrame getFrame() {
		 return this;
	 }
   
  }