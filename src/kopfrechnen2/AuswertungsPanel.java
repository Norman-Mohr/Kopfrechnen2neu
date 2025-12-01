package kopfrechnen2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AuswertungsPanel extends JPanel {

	MainPanel mp;

	JButton btnBeenden, btnNeuesSpiel;
	public int punkteGesammt, punkteAdd, punkteSub, punkteMult, punkteEinMal, punkteDiv;
 

	public AuswertungsPanel(MainPanel mp) {

		this.mp = mp;

		this.setSize(700, 450);
		this.setBounds(0, 0, getWidth(), getHeight());
		
		//this.setBackground(Color.blue);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		this.setVisible(true);
		this.setLayout(null);

		btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.setBounds(360, 300, 120, 30);
		btnNeuesSpiel.setVisible(true);
		btnNeuesSpiel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNeuesSpiel) {

					mp.op = new OutputPanel(mp);
					mp.op.setVisible(false);
					mp.ap.setVisible(false);
					mp.stp = new StartPanel(mp);
					mp.stp.setVisible(true);

					mp.add(mp.stp);
					mp.add(mp.op);
				 
				}

			}

		});
		this.add(btnNeuesSpiel);
	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D d2g = (Graphics2D) g;
		d2g.setFont(new Font("Arial", 3, 25));
		 
		GradientPaint gp = new GradientPaint(0,0,Color.blue, 700, 450, Color.white);
		d2g.setPaint(gp);
		d2g.fillRect(0, 0, 700, 450);
		
		d2g.setColor(Color.white);
		d2g.drawString("Addition                " + mp.ap.punkteAdd, 50, 50);
		d2g.drawString("Subtraction             " + mp.ap.punkteSub, 50, 90);
		d2g.drawString("Multiplikation          " + mp.ap.punkteMult, 50, 130);
		d2g.drawString("Ein Mal Eins            " + mp.ap.punkteMult, 50, 170);
		d2g.drawString("Division                " + mp.ap.punkteDiv, 50, 210);
		d2g.setColor(Color.cyan);
		d2g.drawString("Punkte Gesamt     " + mp.ap.punkteGesammt, 50, 280);

	}
}