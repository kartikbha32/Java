package EvsForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

// itemlistener - menu

public class CastVote implements ActionListener,ItemListener{
	
	String election_date="2021-12-09";
	static Map<String,List<String>> map= new HashMap<String,List<String>>();
	static Map<String,List<String>> map1= new HashMap<String,List<String>>();
	Map<JMenuItem,String> constituency= new HashMap<JMenuItem,String>();
	JLabel l_type;
	JPanel frame1;
	JTextField t;
	JComboBox comboBox,comboBox1;
	int count=1000;
	Date date=null;
	JButton bg1;
	JMenu fileMenu;
	JMenuBar mb;
	JFrame frame;
	
	
	
	public void cast() {
		CastVote cv= new CastVote();
		CandidateDb cdb= new CandidateDb();
		map=cdb.getMap();
		map1=cdb.getCandiConMap();
		System.out.println(map);
		System.out.println(map1);
		//cv.createMenus();
		new DynamicComboBox(map,map1);
		
	}

	



	@Override
	public void actionPerformed(ActionEvent e) {
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
