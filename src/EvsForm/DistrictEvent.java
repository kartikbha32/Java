package EvsForm;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

public class DistrictEvent implements ItemListener {
	
	String[] stringArray;
	Map<String,List<String>> dis_con,con_can;
	JComboBox city=null,state;
	
	public DistrictEvent(JComboBox city,Map<String,List<String>> dis_con, Map<String,List<String> > con_can,JComboBox state){
		this.city=city;
		this.dis_con=dis_con;
		this.con_can=con_can;
		this.state=state;
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		String s="";
		//JComboBox state=(JComboBox) ie.getSource();
		
		if(ie.getSource()==state&& ie.getStateChange()==ItemEvent.SELECTED)
		{
				s=state.getSelectedItem().toString();
				//System.out.println(s);
				if(s.equalsIgnoreCase("Select district"))
				{
					List<String> a=new ArrayList<String>();
					
					stringArray = Arrays.stream(a.toArray())
			                .toArray(String[]::new);
				}
				
				if(s.equals("AP"))
				{
						//areas=new ArrayList<String>();
						List<String> a=new ArrayList<String>();
						a=dis_con.get("AP");
						
						stringArray = Arrays.stream(a.toArray())
				                .toArray(String[]::new);
						
						
						
				}
				 if(s.equals("Bengal"))
				{
						//areas=new ArrayList<String>();
						List<String> a=new ArrayList<String>();
						a=dis_con.get("Bengal");
						
						stringArray = Arrays.stream(a.toArray())
				                .toArray(String[]::new);
						
				}
				 if(s.equals("Delhi"))
				{
					//areas=new ArrayList<String>();
					List<String> a=new ArrayList<String>();
					a=dis_con.get("Delhi");
					stringArray = Arrays.stream(a.toArray())
			                .toArray(String[]::new);
					
			}
			 if(s.equals("Gujarat"))
			{
					//areas=new ArrayList<String>();
					List<String> a=new ArrayList<String>();
					//System.out.println(dis_con);
					a=dis_con.get("Gujarat");
					
					stringArray = Arrays.stream(a.toArray())
			                .toArray(String[]::new);
					
					
			}
			 if(s.equals("TN"))
			{
					//areas=new ArrayList<String>();
					List<String> a=new ArrayList<String>();
					a=dis_con.get("TN");
					
					stringArray = Arrays.stream(a.toArray())
			                .toArray(String[]::new);
					
			}
			if(s.equals("UP"))
			{
					//areas=new ArrayList<String>();
					List<String> a=new ArrayList<String>();
					a=dis_con.get("UP");
					
					stringArray = Arrays.stream(a.toArray())
			                .toArray(String[]::new);
					
			}
			
				
			//for(String x:stringArray)	
				//System.out.println(x);	
			
			if(city.getItemCount()!=0) 
				city.removeAllItems();
			
			for(String i:stringArray)
				city.addItem(i);
				
			}
		
	}
	

}
