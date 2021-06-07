package EvsForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DynamicComboBox extends JFrame {

	JPanel p1;
	JLabel l1,l2,l3,msg;
	JComboBox state,city,candidate; 
	JButton b1;
	String name,cid;
	
	Map<String,List<String>> dis_con,con_can;
	List<String> areas;
	public DynamicComboBox(Map<String,List<String>> dist_con, Map<String,List<String> > con_can) 
	{
	   this.dis_con=dist_con;
	   this.con_can=con_can;
	   
		
		p1=new JPanel();
		l1=new JLabel("Select District");
		l2=new JLabel("Select Constituency");
		l3=new JLabel("Select Candidate");
		
		Set<String> d=dis_con.keySet();
		
		String[] stringArray = Arrays.stream(d.toArray())
                .toArray(String[]::new);
		
		
		state=new JComboBox(stringArray);
		state.addItem("Select District");
		state.setSelectedItem("Select District");
		
		city=new JComboBox();
		candidate=new JComboBox();
		
		DistrictEvent de=new DistrictEvent(city,this.dis_con,this.con_can,state);
		CandidateEvent ce=new CandidateEvent(dis_con,con_can,candidate,city);
		
		state.setFocusable(false);
		state.addItemListener(de);
		city.setFocusable(false);
		city.addItemListener(ce);
		
//		candidate.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				
//					   name=candidate.getSelectedItem().toString();
//					   cid=name.substring(0,6);
//					   System.out.println("cid "+cid);
//					  
//				
//			}
//		   });
			
		
		//candidate.addItem("Select Candidate");
		//candidate.setSelectedItem("Select Candidate");
		//candidate.addItemListener(this);
		
		
		
		b1=new JButton("Submit");
		
		b1.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   name=candidate.getSelectedItem().toString();
				   cid=name.substring(0,6);
				   new ResultsDAO().insertRes(cid);
				   getFrame().dispose();
			   }
		   });
		p1.add(l1);
		p1.add(state);
		p1.add(l2);
		p1.add(city);
		p1.add(l3);
		p1.add(candidate);
		p1.add(b1);
		add(p1);
		setVisible(true);
		setSize(300,300);
		//setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	public JFrame getFrame() {
		return this;
	}
			
}
	
