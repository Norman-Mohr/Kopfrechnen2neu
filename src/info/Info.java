package info;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import kopfrechnen2.OutputPanel;

public class Info {

	OutputPanel op;
	
	public Info(OutputPanel op) {
	  this.op = op;	
	  
	}
	 
    public void draw(Graphics2D d2g) {
    	  drawAufgabe(d2g);
	      drawSchwierigkeit(d2g);
	      drawLevel(d2g);
	      drawEingabe(d2g);
	      drawKonzentrieren(d2g);
	      drawPunkte(d2g);
	    if(op.aufgabe) {  drawEingabe(d2g);  }
	      
  }
    public void drawPunkte (Graphics2D d2g) {
    	 d2g.setFont(new Font("Arial", 1, 25));
	     d2g.setColor(Color.decode("#00008B"));
    	 d2g.drawString("Punkte "+op.punkte, 20, 30);
    }
    
    public void drawAufgabe(Graphics2D d2g) {
    	 d2g.setFont(new Font("Arial", 1, 20));
	     d2g.setColor(Color.decode("#FFB90F"));
   	     d2g.drawString("Aufgabe : "+ (op.zaehler+1), 20, 60);
    }
    
    public void drawEingabe(Graphics2D d2g) {
    	if(op.aufgabe) {
    	 d2g.setFont(new Font("Arial", 1, 20));
	     d2g.setColor(Color.decode("230"));
	     d2g.drawString("Bitte geben Sie das richtige Ergebniss ein! ", 40, 290);
    	}
    }
    
    public void drawKonzentrieren(Graphics2D d2g) {
    	if(this.op.konzentration) {
    	 d2g.setFont(new Font("Arial", 1, 45));
    	 d2g.setColor(Color.decode("30955"));
    	 d2g.drawString("Konzentrieren!", 60, 120);
    	}
    }
    
    public void drawSchwierigkeit(Graphics2D d2g) {
		 d2g.setFont(new Font("Arial", 1, 22));
	     d2g.setColor(Color.gray);
	     d2g.drawString("Schwierigkeit ",520, 60);
	        if(op.schwierigkeit <= 1) { d2g.setColor(Color.cyan); }
		    if(op.schwierigkeit == 2) { d2g.setColor(Color.blue); }
		    if(op.schwierigkeit == 3) { d2g.setColor(Color.darkGray); }
	     d2g.drawString(" "+op.schwierigkeit, 665, 60);
	     
	}
    
    public void drawLevel(Graphics2D d2g) {
    	 d2g.setFont(new Font("Arial", 1, 30));
	     d2g.setColor(Color.gray);
	     d2g.drawString("Level ", 520, 30);
	     d2g.setColor(Color.blue);
	     d2g.drawString(" "+op.level, 600, 30);
    }
}