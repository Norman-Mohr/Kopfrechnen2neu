package kopfrechnen2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import exceptions.FormatEingabeException;
import exceptions.LeereEingabeException;
import rechenarten.EinMalEins;

public class StartPanel extends JPanel implements ActionListener {

	public JButton btnAddition, btnSubtraction, btnMultiplikation, btnEinMalEins, btnDivision;
	public JButton btnZumSpiel;
	private JTextField txfEinmalEins;
	public String code;
	MainPanel mp;
	private boolean btnEinMal = false;

	Timer timer;
	boolean eingabeNeu;
	String eingabe;
	 
	public StartPanel(MainPanel mp) {
		this.mp = mp;

		this.setSize(700, 450);
		this.setBounds(0, 0, getWidth(), getHeight());
		this.setVisible(true);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		this.setLayout(null);

		btnAddition = new JButton("Addition");
		btnAddition.setBounds(20, 50, 120, 40);
		btnAddition.addActionListener(this);
		this.add(btnAddition);

		btnSubtraction = new JButton("Subtraction");
		btnSubtraction.setBounds(20, 95, 120, 40);
		btnSubtraction.addActionListener(this);
		this.add(btnSubtraction);

		btnMultiplikation = new JButton("Multiplikation");
		btnMultiplikation.setBounds(20, 140, 120, 40);
		btnMultiplikation.setVisible(true);
		btnMultiplikation.addActionListener(this);
		this.add(btnMultiplikation);

		btnEinMalEins = new JButton("EinmalEins");
		btnEinMalEins.setBounds(20, 185, 120, 40);
		btnEinMalEins.setVisible(true);
		btnEinMalEins.addActionListener(this);
		this.add(btnEinMalEins);

		btnDivision = new JButton("Division");
		btnDivision.setBounds(20, 230, 120, 40);
		btnDivision.setVisible(true);
		btnDivision.addActionListener(this);
		this.add(btnDivision);

		btnZumSpiel = new JButton("Zum Spiel");
		btnZumSpiel.setBounds(getWidth() / 2 - 60, 375, 120, 40);
		btnZumSpiel.setVisible(false);
		btnZumSpiel.setEnabled(false);
		btnZumSpiel.addActionListener(this);
		this.add(btnZumSpiel);

		txfEinmalEins = new JTextField();
		txfEinmalEins.setBounds(getWidth() / 2 - 70, 200, 140, 40);
		txfEinmalEins.setVisible(false);
		txfEinmalEins.addActionListener(this);
		this.add(txfEinmalEins);

		timer = new Timer(1000, this);
		timer.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D d2g = (Graphics2D) g;
		if (btnEinMal) {
			d2g.setFont(new Font("Arial", 3, 30));
			d2g.drawString("Welches Ein mal Eins möchten Sie üben?", 40, 100);
			d2g.drawString("1, 2, 3, 4 ... ?", 100, 170);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAddition) {
			code = e.getActionCommand();
			System.out.println("Button code " + code);
			mp.op.setVisible(true);
			this.setVisible(false);
		}

		if (e.getSource() == btnSubtraction) {
			code = e.getActionCommand();
			System.out.println("Button code " + code);
			mp.op.setVisible(true);
			this.setVisible(false);
		}

		if (e.getSource() == btnMultiplikation) {
			code = e.getActionCommand();
			System.out.println("Button code " + code);
			mp.op.setVisible(true);
			this.setVisible(false);
		}

		if (e.getSource() == btnEinMalEins) {

			btnEinMal = true;
			code = e.getActionCommand();
			System.out.println("Button code " + code);
			txfEinmalEins.setVisible(true);
			txfEinmalEins.requestFocus();
			txfEinmalEins.setHorizontalAlignment(SwingConstants.CENTER);
			btnAddition.setVisible(false);
			btnSubtraction.setVisible(false);
			btnMultiplikation.setVisible(false);
			btnEinMalEins.setVisible(false);
			btnDivision.setVisible(false);

			btnZumSpiel.setVisible(true);
			 
			this.paintImmediately(0, 0, 700, 450);
		}
		
		 
		if(txfEinmalEins.getText().length()>8) {    txfEinmalEins.setText("");    repaint();   }
		
		exceptions();
		
		if(!eingabeNeu) {
			Graphics g;
		    String sicher = "Sind Sie sicher?";
			btnZumSpiel.setEnabled(true);
			EinMalEins.factor1 = Integer.parseInt(eingabe);
			if(EinMalEins.factor1>20) {  
				g = getGraphics();
				g.setFont(new Font("Arial",3,25));
				g.drawString(sicher, 250, 300);        } else {  repaint(); }
		 
			if(e.getSource()==btnZumSpiel) {    
			System.out.println("Button code " + code);
			mp.op.setVisible(true);
			this.setBounds(0, 0, 0, 0);
			   }
		}
		
		

		if (e.getSource() == btnDivision) {
			code = e.getActionCommand();
			System.out.println("Button code " + code);
			mp.op.setVisible(true);
			this.setVisible(false);
		}

	}
	
	void exceptions() throws LeereEingabeException, FormatEingabeException {

		try {

			if (txfEinmalEins.getText().equals("")) {
				throw new LeereEingabeException("Bitte geben Sie das Ergebniss ein!");
			} else {
				this.eingabe = txfEinmalEins.getText();
				eingabeNeu = false;
			}
 
			if (!txfEinmalEins.getText().matches("-?\\d+")) {
				throw new FormatEingabeException("Bitte geben Sie nur Zahlen ein");
			} else {
				this.eingabe = txfEinmalEins.getText();
				eingabeNeu = false;
			}
			 

		} catch (LeereEingabeException e) {
			System.out.println("Keine Eingabe : " + e.getMessage());
			txfEinmalEins.requestFocus();
			eingabeNeu = true;
		}

		catch (FormatEingabeException e) {
			System.out.println("Falsches Zeichenformat : " + e.getMessage());
			txfEinmalEins.setText(null);
			txfEinmalEins.requestFocus();
			eingabeNeu = true;
		}
	}


}
