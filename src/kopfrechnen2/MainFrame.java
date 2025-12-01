package kopfrechnen2;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainFrame extends JFrame {
 
	
	MainPanel mp;
	 
	public static void main(String[] args) {
		  
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				 
				 MainFrame mainframe = new MainFrame("Kopfrechnen 2");
				   mainframe.setVisible(true);
			}
			
		});
		 
	}
	
	public MainFrame(String string) {
		
		this.setTitle(string);
	
		mp = new MainPanel(this);
		 
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point sp = ge.getCenterPoint();
		System.out.println(sp.getX());
		System.out.println(sp.getY());
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			 
			e.printStackTrace();
		}  
		 
		for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {             // Look and Feel Info
			System.out.println("Looks "+info);
		}
		 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(mp.getWidth(), mp.getHeight());
		this.setResizable(false);
		this.setFocusable(true); 
		this.setLocation((int)sp.getX()-mp.getWidth()/2,(int)sp.getY()-mp.getHeight()/2);
		
		this.add(mp);
		pack();
	}
}
