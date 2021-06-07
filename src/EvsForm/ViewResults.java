package EvsForm;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewResults {
   JFrame f;
   static String cid;
   List<String> woncan;
   int maxvc;
   Container ct;
   JLabel lbl;
   JPanel panel;
//	public ViewResults(JFrame f) {
//		this.f=f;
//	}

	public ViewResults() {
		woncan=new ArrayList<String>();
		f=new JFrame("Results");
		panel=new JPanel();
		maxvc=0;
	}

//	public ViewResults(String cid) {
//		System.out.println("cons "+cid);
//		this.cid=cid;
//	}

	public void viewRes() {
		LocalDate date=LocalDate.now();
		if(date.isEqual(LocalDate.of(2021, 06, 07))) {
			System.out.println("Announced ");
			ResultsDAO rdao=new ResultsDAO();
			woncan=rdao.selectRes();
			maxvc=rdao.getMaxVotes();
			if(woncan.size()==1) {
				lbl=new JLabel("winner is "+woncan.get(0)+" with votes "+maxvc);
				System.out.println("winner is "+woncan.get(0)+" with votes "+maxvc);
			}
			else {
				lbl=new JLabel("Tie between winners "+woncan+" with votes "+maxvc);
				System.out.println("Tie between winners "+woncan+" with votes "+maxvc);
			}
			
		}
		
		else
			lbl=new JLabel("Results are not yet announced");
		
		f.setSize(400,400);
		panel.add(lbl);
		f.add(panel);
		f.setVisible(true);
		ct=f.getContentPane();

	}
}
