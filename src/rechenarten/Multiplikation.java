package rechenarten;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import daten.SuperZahlen;
import kopfrechnen2.OutputPanel;

public class Multiplikation extends SuperZahlen {

	OutputPanel op;
	public boolean plus = true;

	public Multiplikation(OutputPanel op) {
		super(op);
		this.op = op;

		multiplikation = true;
		System.out.println("Hallo du hast es geschaft!  Multiplikation   ");
	 
	}

	public void draw(Graphics2D d2g) {
		if (op.aufgabe) {
			d2g.setColor(Color.blue);
			d2g.setFont(new Font("Arial", 0, 40));
			if (op.zwei) {
				d2g.drawString("Wieviel ergibt ", 50, 130);
				d2g.setColor(Color.decode("200210200"));
				d2g.drawString(" " + a + " * " + b, 80, 190);
			}
			if(op.drei) {
				d2g.drawString("Wieviel ergibt ", 50, 130);
				d2g.setColor(Color.decode("200210200"));
				d2g.drawString(" " + a + " * " + b + " * " + c, 80, 190);
			}
		}
	}

	public void update() {

		if (op.zwei) {

			a = zahl1[op.zaehler];
			b = zahl2[op.zaehler];
			ergebniss = a * b;
			
		}
		if (op.drei) {     

			a = zahl1[op.zaehler];
			b = zahl2[op.zaehler];
			c = zahl3[op.zaehler];
			ergebniss = a * b * c;
			
		}
		 
	}
	
}
