package EvsForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultsDAO {
	Connection con;
	ResultSet res;
	PreparedStatement stat,stat1;
	String cid;
	int vc=0,maxvc=0;
	List<String> woncan;
	int updstat;
	public ResultsDAO() {
		super();
		//this.cid=cid;
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evs_team1_schema", "root", "Kartik@25");
			woncan=new ArrayList<String>();
			//stat=con.prepareStatement("insert into evs_tbl_result values(?,?,?,?)");
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
	}
	
	public void insertRes(String cid) {
		try {
			stat1=con.prepareStatement("select votecount from evs_tbl_result where candidateid=?");
			stat1.setString(1, cid);
			res=stat1.executeQuery();
			while(res.next()) {
				 vc=res.getInt(1);
			 }
			vc=vc+1;
			stat=con.prepareStatement("update evs_tbl_result set votecount=? where candidateid=?;");
			stat.setInt(1, vc);
			stat.setString(2,cid);
			updstat=stat.executeUpdate();
			System.out.println(updstat+" updated");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> selectRes() {
		try {
			stat1=con.prepareStatement("select candidateid,votecount from evs_tbl_result where votecount=(select max(votecount) from evs_tbl_result);");
			res=stat1.executeQuery();
			while(res.next()) {
				 woncan.add(res.getString(1));
				 maxvc=res.getInt(2);
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return woncan;
	}
	
	public int getMaxVotes() {
		return this.maxvc;
	}
	
}
