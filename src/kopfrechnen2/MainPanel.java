package kopfrechnen2;

import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	MainFrame mainFrame;
	StartPanel stp;
	public OutputPanel op;
	public AuswertungsPanel ap;
	
	  MainPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		stp = new StartPanel(this);
		op = new OutputPanel(this);
		ap = new AuswertungsPanel(this);
		 	
		op.setVisible(false);
		ap.setVisible(false);
		
		this.setSize(700, 450);
		this.setPreferredSize(new Dimension(getWidth(),getHeight()));
		this.setLayout(null);
		
		
		this.add(op);
		this.add(ap);
		this.add(stp);
		
	}
	  
	  
	
}
