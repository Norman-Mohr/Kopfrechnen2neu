package daten;

import java.util.Random;

import kopfrechnen2.OutputPanel;

public class SuperZahlen {
  
	public int[] zahlen;
	
	public int[] zahl1 = new int[30];
	public int[] zahl2 = new int[30];
	public int[] zahl3 = new int[30];
	public int[] zahl4 = new int[30];
	public int[] zahl5 = new int[30]; 
	
	public int a;
	public int b;
	public int c;
	public int d;
	public int e;
 
	public int ergebniss;
	public String name;
	public boolean addition=false, subtraction=false, multiplikation=false;
 
	OutputPanel op;
	public int punkte = 0;
	 
	 
	public static Random rand = new Random();

	 

	public SuperZahlen(OutputPanel op) {
		 this.op = op;
	}
 
	 
	 
	public int[] zufallVonBis(int min, int max) {
		int length = max - min;
		zahlen = new int[length];

		for (int z = 0; z < length; z++) {
			zahlen[z] = rand.nextInt((max - min) + 1) + min;
			for (int t = 0; t < z; t++) {
				if (zahlen[t] == zahlen[z]) {
					z--;
				}
			}
		}
		return zahlen;
	}

/*	public int[] zufallszahlen(int length) {

		zahlen = new int[length];
		
		for (int z = 0; z < length; z++) {
			zahlen[z] = rand.nextInt(length) + 1;
			for (int t = 0; t < z; t++) {
				if (zahlen[t] == zahlen[z]) {
					z--;
				}

			}
		}
		return zahlen;
	}
	 */
	
	
	
	public void updateLevel(int min, int max) {
		    int index = max-min;
			a = 0; b = 0; c = 0; d = 0; e = 0;
			zahl1 = new int[index];
			zahl2 = new int[index];
			zahl3 = new int[index];
			zahl4 = new int[index];
			zahl5 = new int[index];
			zahl1 = zufallVonBis(min, max);
			zahl2 = zufallVonBis(min, max);
			zahl3 = zufallVonBis(min, max);
			zahl4 = zufallVonBis(min, max);
			zahl5 = zufallVonBis(min, max);
			
			a = zahl1[0];
			b = zahl2[0];
			 
	}
	public void updateLevelMulti(int min, int max) {
		int index = max-min;
		a = 0; b = 0; c = 0;
		zahl1 = new int[index];
		zahl2 = new int[index];
		zahl3 = new int[index];
		zahl1 = zufallVonBis(min, max);
		zahl2 = zufallVonBis(min, max);
		zahl3 = zufallVonBis(min, max);
	}
	 
}
