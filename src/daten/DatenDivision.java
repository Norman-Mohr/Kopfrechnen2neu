package daten;

import java.util.Random;

public class DatenDivision {

	public int[]divident;
	public int[]divisor;
	public int[]quotient;

	public double moduloR;

	public String name;
	public String eingabe;
	public int ergebniss;
	public int stufe = 1;
	public int z = 0;
	public boolean division;

	public static Random rand = new Random();

	public int[] zufallszahlen(int[] zahl1) {

		for (int z = 0; z < zahl1.length; z++) {
			zahl1[z] = rand.nextInt(zahl1.length) + 1;
			for (int t = 0; t < z; t++) {
				if (zahl1[t] == zahl1[z]) {
					z--;
				}

			}
		}
		return zahl1;
	}

	public int[] zufallszahlenQuotient(int length) {

		quotient = new int[length];

		for (int z = 0; z < length; z++) {
			quotient[z] = rand.nextInt(length) + 1;
			for (int t = 0; t < z; t++) {
				if (quotient[t] == quotient[z]) {
					z--;
				}
			}
		}
		return quotient;
	}

	public int[] zufallszahlenDivisor(int length) {

		divisor = new int[length];

		for (int z = 0; z < length; z++) {
			divisor[z] = rand.nextInt(length) + 1;
			for (int t = 0; t < z; t++) {
				if (divisor[t] == divisor[z]) {
					z--;
				}
			}
		}
		return divisor;

	}

	public int[] divident(int[] quotient, int[] divisor) {
		divident = new int[quotient.length];
		for (int z = 0; z < quotient.length; z++) {
			divident[z] = quotient[z] * divisor[z];
		}

		return divident;
	}

	public void ausgabe(int[] zahl) {
		for (int z = 0; z < zahl.length; z++) {
			System.out.println("Zahl " + z + " " + zahl[z]);
		}
	}
}
