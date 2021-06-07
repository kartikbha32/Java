package EvsForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateDb {
	
	Date date;
	Connection con;
	ResultSet res;
	PreparedStatement stat,stat1;
	Map<String,List<String>> map= new HashMap<String,List<String>>();
	List<String> l;
	Map<String,List<String>> map1= new HashMap<String,List<String>>();
	public CandidateDb() {
		super();
	
	
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evs_team1_schema", "root", "Kartik@25");

		 
		   
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
	}
	public void getConstituencies(String dis)
	{
		try {
			l=new ArrayList<String>();
			stat=con.prepareStatement("Select constituency from evs_tbl_elections where district=? ");
			
			stat.setString(1, dis);
			 res= stat.executeQuery();
			 while(res.next()) {
				 l.add(res.getString(1));
			 }
			 map.put(dis, l);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //int id=50;
		 
	}
	public  void getCandidates(String constituency)
	{
		try {
			stat1=con.prepareStatement("select concat(CandidateId,\"-\",c.name,\"-\",p.name) con from evs_tbl_party p join (select candidateId , name , "
					+ "PartyId from evs_tbl_candidate where Constituency=?) c on c.Partyid=p.Partyid;");
			List<String> l1= new ArrayList<String>();
			stat1.setString(1, constituency);
			res=stat1.executeQuery();
			while(res.next())
			{
				
				l1.add(res.getString(1));
				
			}
			map1.put(constituency, l1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map<String, List<String>> getCandiConMap(){
		return map1;
	}
	
	public    Map<String, List<String>>  getMap()
	{
		
	    getConstituencies("AP");
		getConstituencies("TN");
	    getConstituencies("Bengal");
		getConstituencies("UP");
		getConstituencies("Delhi");
		getConstituencies("Gujarat");
		for(String k: map.keySet())
		{
			List<String> l=map.get(k);
			for(String consti: l)
			{
				getCandidates(consti);
			}
			
		}
        return map;
		
	
		
		//System.out.println(cdb.map);
	
	}

}
