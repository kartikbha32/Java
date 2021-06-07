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

import javax.swing.JComboBox;

public class CandidateEvent implements ItemListener {

	JComboBox city;
	Map<String,List<String>> dis_con,con_can;
	JComboBox candidate;
	String[] stringArray;
	public CandidateEvent(Map<String,List<String>> dis_con, Map<String,List<String> > con_can,JComboBox candidate,JComboBox city) {
		
		this.dis_con=dis_con;
		this.con_can=con_can;
		this.candidate=candidate;
		this.city=city;
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		String s="";
		//city=(JComboBox) ie.getSource();
		
		if(ie.getSource()==city&& ie.getStateChange()==ItemEvent.SELECTED) {
		
				s=city.getSelectedItem().toString();
				Set<String> cities= con_can.keySet();
				
				for(String c: cities)
				{
					if(s.equalsIgnoreCase(c))
					{
						List<String> a=  new ArrayList<String>();
						a=con_can.get(c);
						stringArray = Arrays.stream(a.toArray())
				                .toArray(String[]::new);
						
					}
				}
				}
			for(String x:stringArray)	
				System.out.println(x);	
			
			if(candidate.getItemCount()!=0) 
				candidate.removeAllItems();
			
			for(String i:stringArray)
				candidate.addItem(i);
		}
	
	
}

