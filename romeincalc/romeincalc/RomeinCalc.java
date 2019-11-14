package romeincalc;

//Naam : Yasin Yildirim

//Java Assestment Young Capital: RomeinCalc

//Datum : 11-11-2019

import java.io.PrintStream;

import java.util.Scanner;

public class RomeinCalc {


	// BEGIN

	public static void main(String[] argv) {


		new RomeinCalc().start();


	}


	void start() {

		Scanner in = new Scanner(System.in);

		startCalculator(in);

	}	


	//PrintStream out;

	int uitkomst = 0;

	public RomeinCalc() {

		//	out = new PrintStream(System.out);

	}

	// STRING ALS INPUT, DUS ROMEINS WORDT NAAR DECIMAAL OMGEZET

	int romeinsNaarDecimaal(String s) {

		int decimaal = 0;

		int[] romeins = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {

			romeins[i] = checkWaardeVanRomeinsCijfer(s.charAt(i));

		}

		decimaal = romeinsOmrekenen(romeins);

		return decimaal;

	}

	// RETURNED EEN INT WAARBIJ ROMEINS GETAL WORDT OMGEREKEND NAAR EEN DECIMAAL GETAL

	int romeinsOmrekenen(int[] romein) {

		int decimaal = 0;

		int eersteGetal = romein[0];

		for (int i = 1; i < romein.length; i++) {

			int tweedeGetal = romein[i];

			if (eersteGetal < tweedeGetal) {

				decimaal -= eersteGetal;

			} else {

				decimaal += eersteGetal;

			}

			eersteGetal = tweedeGetal;

		}

		decimaal += eersteGetal;

		return decimaal;

	}

	// HIER WORDT WAARDE VAN ROMEINSE LETTER NAAR DECIMAAL GETAL OMGEZET, DIT GELDT VOOR ZOWEL HOOFDLETTERS ALS KLEINE LETTERS

	int checkWaardeVanRomeinsCijfer(char letter) {

		switch (letter) {

		case 'I':
			return 1;

		case 'V':
			return 5;

		case 'X':
			return 10;

		case 'L':
			return 50;

		case 'C':
			return 100;

		case 'D':
			return 500;

		case 'M':
			return 1000;

		case 'i':
			return 1;

		case 'v':
			return 5;

		case 'x':
			return 10;

		case 'l':
			return 50;

		case 'c':
			return 100;

		case 'd':
			return 500;

		case 'm':
			return 1000;

		default:
			return -1;

		}

	}

	// HIER WORDT DECIMAAL NAAR ROMEINS OMGEZET

	String decimaalNaarRomeins(int getal) {

		int[] decimalenArray = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		String[] romeinseArray = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		String romeins = "";

		for (int i = 0; i < decimalenArray.length; i++) {

			while (getal >= decimalenArray[i]) {

				romeins += romeinseArray[i];

				getal -= decimalenArray[i];

			}

		}

		return romeins;

	}

	// HIER WORDT DE BEREKENING UITGVOERD

	int doeBerekening(int eersteGetal, int tweedeGetal, char operator) {

		int totaal = 0;

		if (operator == '+') {

			totaal = eersteGetal + tweedeGetal;

		} else if (operator == '-') {

			totaal = eersteGetal - tweedeGetal;

		} else if (operator == '/') {

			totaal = eersteGetal / tweedeGetal;

		} else if (operator == '*') {

			totaal = eersteGetal * tweedeGetal;

		} else {

			totaal = -1;

		}

		return totaal;

	}
	
	
	// BOOLEAN METHODE WAARBIJ DE INVOER WORDT GECONTROLEERD OP VALIDEIT VOOR DE CALCULATOR, ZOALS:
	// - EERSTE GETAL MOET EEN ROMEINSE CIJFER ZIJN TUSSEN 1 EN 3999 VERVOLGD MET EEN SPATIE
	// - VERVOLGENS MOET ER EEN OPERATOR INGEVOERD ZIJN, DUS EEN -, +, * OF / VERVOLGD MET EEN SPATIE
	// - TWEEDE GETAL MOET EEN ROMEINSE CIJFER ZIJN TUSSEN 1 EN 3999
	boolean checkInput(String s) {

		Scanner input = new Scanner(s);

		// KIJKEN OF EERST MET ROMEINS WORDT BEGONNEN

		if (operatorCheck(Character.toString(s.charAt(0))) == 0) {

			// HIER WORDT EERSTE INPUT GECHECKT

			if (checkRomeinsValideit(input.next())) {

			} else {

				System.out.println("EERSTE ROMEINS GETAL KLOPT NIET! BIJVOORBEELD: XIV, VERGEET DE SPATIE NIET TUSSEN GETAL EN OPERATOR.");
				return false;

			}

		}

		// HIER WORDT GECHECKED OF DE OPERATOR KLOPT, DUS EEN -, +, * OF /
		
		String operator = input.next();

		if (operatorCheck(operator) == 1) {

			// operator klopt dus

		} else {

			System.out.println("OPERATOR KLOPT NIET! MOET EEN -, +, * OF / ZIJN.");
			return false;

		}

		// HIER WORDT TWEEDE INPUT GECHECKT

		if (checkRomeinsValideit(input.next())) {
			
			return true;

		} else {
			
			System.out.println("TWEEDE ROMEINS GETAL KLOPT NIET! VERGEET DE SPATIE NIET TUSSEN OPERATOR EN GETAL.");
			return false;
			
		}

		

	}

	boolean checkRomeinsValideit(String s) {

		int aantalChar = s.length();

		for (int i = 0; i < aantalChar; i++) {

			char c = s.charAt(i);

			if (c == 'x' || c == 'X' || c == 'v' || c == 'V' || c == 'i' || c == 'I' || c == 'm' || c == 'M' || c == 'c'
					||

					c == 'C' || c == 'd' || c == 'D' || c == 'l' || c == 'L') {

			} else {

				System.out.println("Input Verkeerd!");

				return false;

			}

		}

		return true;

	}

	// HIER DRAAIT ALLES IN, OOK DE RECURSIE OM STEEDS TE HERHALEN VAN BEGIN TOT
	// STOPOPERATIE "1" WORDT GEGEVEN

	void startCalculator(Scanner inputV) {


		System.out.println(	"WELKOM BIJ DE ROMEINSE CALCULATOR! " 
				+ "\n- MET 1 KUNT U AANGEVEN TE WILLEN STOPPEN " +
				"\n- BEREIK IS VAN 0 - 3999 " +
				"\n- INVOER VB: MMI - IV || LET OP DE SPATIE TUSSEN LETTERS! " +
				"\nVOER HIER UW REKENSOM IN ROMEINSE LETTERS:");

		String eersteInput = inputV.nextLine();

		Scanner input = new Scanner(eersteInput);

		String eersteVondst = input.next();

		Scanner eersteVondsScanner = new Scanner(eersteVondst);

		boolean inputCorrect = true;

		boolean stopOpdracht = false;

		while (stopOpdracht == false || inputCorrect == true) {

			if (checkStopOpdracht(Character.toString(eersteVondst.charAt(0))) == true) {

				stopOpdracht = true;

				System.out.println("U HEEFT EEN 1 INGOEVOERD: EINDE ROMEINSE CALCULATOR!");

				break;

			}

			if (checkInput(eersteInput) == false) {

				inputCorrect = false;

				break;

			}

			if (operatorCheck(eersteVondst) == 1) {

				String operator = eersteVondsScanner.next();

				int tweedeGetal = romeinsNaarDecimaal(input.next());

				uitkomst = doeBerekening(uitkomst, tweedeGetal, operator.charAt(0));

			} else {

				int eersteGetal = romeinsNaarDecimaal(eersteVondsScanner.next());

				String operator = input.next();

				int tweedeGetal = romeinsNaarDecimaal(input.next());

				uitkomst = doeBerekening(eersteGetal, tweedeGetal, operator.charAt(0));

			}

			if (uitkomst < 0) {

				System.out.println("TE LAGE UITKOMST! "
						+ "\nJE UITKOMST IS: " + uitkomst);

				System.exit(1);

			}

			if (uitkomst > 3999) {

				System.out.println("TE HOGE UITKOMST! "
						+ "\nJE UITKOMST IS: " + uitkomst);

				System.exit(1);

			}

			System.out.printf("HIER IS UW ANTWOORD VOOR DE REKENSOM: %s \n", decimaalNaarRomeins(uitkomst));

			Scanner in = new Scanner(System.in);

			startCalculator(in);

			break;

		}

	}

	// HIER WORDT DE OPERATOR GECHECKED OP VALIDEIT, DUS MOET EEN +, -, * OF / ZIJN
	int operatorCheck(String een) {

		if (een.equals("+") || een.equals("-") || een.equals("*") || een.equals("/")) {

			return 1;

		}

		return 0;

	}

	// RETURNED EEN BOOLEAN AFHANKELIJK OF EEN 1 WORDT INGEVOERD, DUS OF ER MOET WORDEN GESTOPT MET DE CALCULATOR
	boolean checkStopOpdracht(String een) {

		if (een.equals("1")) {

			return true;

		}

		return false;

	}



}