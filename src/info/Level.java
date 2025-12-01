package info;

import kopfrechnen2.OutputPanel;

public class Level {

	OutputPanel op;

	public Level(OutputPanel op) {
		this.op = op;
	}

	public void update() {

		if(op.levelUp) {
		switch (op.level) {
		
		case 1: 
			if(op.addition != null) {
				op.addition.updateLevel(30);
			}
			if (op.subtraction != null) {
				op.subtraction.updateLevel(30);
			}        
			
			if (op.multiplikation != null) {
				op.multiplikation.updateLevel(9);
			}       
		/*	if (op.division != null) {
		 *		op.division.updateLevel(10);
			}    */     
			
			break;
		
		case 2:
			if (op.addition != null) {
				op.addition.updateLevel(80);
			}
			if (op.subtraction != null) {
				op.subtraction.updateLevel(80);
			}               
			if (op.multiplikation != null) {
				op.multiplikation.updateLevel(10);
			}       
			if (op.division != null) {
				op.division.updateLevel(12);
			}       
			
			break;
		case 3:
			if (op.addition != null) {
				op.addition.updateLevel(120);
			}
			if (op.subtraction != null) {
				op.subtraction.updateLevel(120);
			}       
			if (op.multiplikation != null) {
				op.multiplikation.updateLevel(15);
			}     
			if (op.division != null) {
				op.division.updateLevel(14);
			}       
			
			break;
		case 4:
			if (op.addition != null) {
				op.addition.updateLevel(120);
			}
			if (op.subtraction != null) {
				op.subtraction.updateLevel(120);
			}       
			if (op.multiplikation != null) {
				op.multiplikation.updateLevel(9);
			}       
			if (op.division != null) {
				op.division.updateLevel(16);
			}       
			
			break;
			
		}
	        op.levelUp = false;     }
	}
}
