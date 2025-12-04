package rechenarten;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import daten.DatenDivision;
import kopfrechnen2.OutputPanel;

public class Division extends DatenDivision {

	OutputPanel op;
 
	
	public Division(OutputPanel op) {
		this.op = op;
		
		division = true;
		quotient = zufallszahlenQuotient(11);
		divisor = zufallszahlenDivisor(11);
		divident = divident(quotient,divisor);
	}
	
	public void draw(Graphics2D d2g) {
		if (op.aufgabe) {
			d2g.setColor(Color.blue);
			d2g.setFont(new Font("Arial", 0, 40));
			if (op.zwei) {
				d2g.drawString("Wieviel ergibt ", 50, 130);
				d2g.setColor(Color.decode("200210200"));
				d2g.drawString(" " + divident[op.zaehler] + " / " + divisor[op.zaehler], 80, 190);
				 
			}
	}
}
	
	public void update() {
		 
		ergebniss = divident[op.zaehler] / divisor[op.zaehler];
		 
	}
	
	public void updateLevel(int length) {
		quotient = zufallszahlenQuotient(length);
		divisor = zufallszahlenDivisor(length);
		divident = divident(quotient,divisor);
	}
	
	
}
