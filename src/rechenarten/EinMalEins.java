package rechenarten;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import kopfrechnen2.OutputPanel;
 
public class EinMalEins {

	OutputPanel op;
	public static int factor1, factor2;
	public int ergebniss;
	public static boolean factorPlus = false;
	public String name;
	public boolean einmaleins;
	
	public EinMalEins(OutputPanel op) {
		this.op = op;
		factor2 = 0;
		einmaleins = true;
	}
	
	public void draw(Graphics2D d2g) {
		if (op.aufgabe) {
			d2g.setColor(Color.blue);
			d2g.setColor(Color.decode("#00008B"));
			d2g.setFont(new Font("Arial", 0, 40));
			 
				d2g.drawString("Wieviel ergibt ", 50, 130);
				d2g.setColor(Color.decode("200210200"));
				d2g.drawString(" " + factor1 + " * " + factor2, 80, 190);

		}
	}
	public void update() {

		 if(factorPlus) {  factor2++;   factorPlus = false;  }
		ergebniss = factor1 * factor2;

	}
}
