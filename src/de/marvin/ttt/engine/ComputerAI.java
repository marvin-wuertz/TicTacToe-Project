/**
 * 
 */
package de.marvin.ttt.engine;

import java.util.Random;

/**
 * @author Marvin Würtz
 * 
 *         Copyright 10.06.2020 Marvin Würtz TicTacToe-Project
 */
public class ComputerAI {

									// Gewinn IDs
									// 1 1 1 2 2 2 3 3 3 4 4 4 5 5 5 6 6 6 7 7 7 8 8 8
	private int[] guesses = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 3, 6, 1, 4, 7, 2, 5, 8, 0, 4, 8, 2, 4, 6 };
									// 0 1 2 3 4 5 6 7 8 9...
	private int comp = 1;
	private int human = 0;

	public ComputerAI() {

	}

	/**
	 * @param board Spielfeld
	 * @return Das best moegliche Feld welches der Bot belegen soll
	 */
	public int getField(String[] board) {
		int[] matchfield = new int[9];
		//Das Spielfeld wird uebertragen -> X wird durch 0 ersetzt und O durch 1 und leere Felder zu -1
		for (int i = 0; i < board.length; i++) {
			System.out.println("Schleifen nr. " + i);
			if (board[i] != null) {
				if (board[i].equals("X")) {
					matchfield[i] = 0; // 0 = Human -> X
				} else if (board[i].equals("O")) {
					matchfield[i] = 1; // 1 = Comp -> O
				}
			} else {
				matchfield[i] = -1;
			}
		}
		//Holt sich die best moegliche zahl
		int best = getBest(matchfield);
		//Wenn die best moegliche Zahl -1 ist dann gibt es keinen guten zug -> Zufaelliger zug
		if (best == -1) {
			return getRandomField(matchfield);
		} else {
			return best;
		}
	}

	/**
	 * @param board Spielfeld
	 * @return Eine zufaellige Zahl welche noch nicht belegt ist -> Wird aufgerufen wenn es kein bestes Feld gibt
	 */
	private int getRandomField(int[] board) {
		int rand;
		while (true) {
			rand = getRandom(0, 8);
			if (board[rand] == -1) {
				return rand;
			}
		}
	}

	/**
	 * @param min Mimimaler wert
	 * @param max Maximaler wert
	 * @return Liefert eine Zahel im bereich der angegebenen Werte
	 */
	private int getRandom(int min, int max) {
		Random r = new Random();
		// max - min + 1 + min
		return r.nextInt((max - min) + 1) + min;
	}

	/**
	 * @param board Spielfeld
	 * @return Den besten Platz um zu gewinnen oder den gegner zu blocken -> Zusammengesetzt aus allen anderen methoden
	 */
	private int getBest(int[] board) {
		// Ueberpruefen ob der Human 2 in einer gewinnerreihe hat
		if (hasTwo(human, board) > 0) {
			// Jetzt ueberpruefen, ob comp zwei in einer gewinner Reihe habe
			if (hasTwo(comp, board) > 0) {
				// Da der Comp an der Reihe ist und selber eine moeglichekit zum gewinnen hat ->
				// Reinsetzen um zu gewinnen
				return getFree(comp, board, hasTwo(comp, board));
			} else {
				// Freier Platz fuer den Spieler waere dort. -> Wenn nicht geblockt wird kann
				// der Spieler gewinnen ->
				// D.h. der computer muss den freien platz belegen sonst kann der Spieler
				// gewinnen
				// Da der Comp keine 2 in einer gewinnmoeglichkeit hat muss er den Human blocke,
				// weil dieser zwei hat
				return getFree(human, board, hasTwo(human, board));
			}
		} else if (hasTwo(comp, board) != -1) { // Wenn comp zwei hat reinsetzen zum gewinnen
			return getFree(comp, board, hasTwo(comp, board));
		} else if (hasOne(comp, human, board) > 0) { // Sollte der bot bereits 1 in einer gewinner Reihe haben soll
														// er natuerlich passend setzen
			return getFree(comp, board, hasOne(comp, human, board));
		} else {
			return -1;
		}
	}

	/**
	 * @param player Spieler fuer wen das Freie feld gesucht wird
	 * @param board -> Spielfeld
	 * @param pos Gewinnerpositions anfang -> In dem bereich wird gesucht
	 * @return Freies Feld an einer gewinnerposition
	 */
	private int getFree(int player, int[] board, int pos) {
		for (int i = 0; i < 3; i++) {
			if (board[guesses[pos + i]] == -1) {
				return guesses[pos + i];
			}
		}
		return -1;
	}

	/**
	 * @param player Spieler fuer welchen gesucht werden soll
	 * @param otherPlayer Gegnerische Spieler
	 * @param board Spielfeld
	 * @return Gibt die Startposition einer gewinnerreihe zurueck an welcher er ein Feld belegt hat und der gegner keins
	 */
	private int hasOne(int player, int otherPlayer, int[] board) {
		for (int i = 0; i < 8; i++) {
			int pos = i * 3;
			int counter = 0;
			for (int j = 0; j < 3; j++) {
				if (board[guesses[pos]] == player) {
					counter++;
				}
				if (board[guesses[pos]] == otherPlayer) {
					counter--;
				}
				pos++;
			}
			pos = i * 3;
			if (counter > 0) {
				return pos;
			}
		}
		return -1;
	}

	
	/**
	 * @param player Spieler fuer welchen gesucht werden soll, wo er zwei stellen hat
	 * @param board Spielfeld
	 * @return Gibt die startposition einer gewinner reihe zurueck in welcher er zwei hat
	 */
	private int hasTwo(int player, int[] board) { // 0 = X -> Human | 1 = O -> Computer
		for (int i = 0; i < 8; i++) {
			int pos = i * 3;
			int counter = 0;
			for (int j = 0; j < 3; j++) {
				if (board[guesses[pos]] == player) {
					counter++;
				} else {
					counter--;
				}
				pos++;
			}
			pos = i * 3;
			if (counter > 0) {
				return pos;
			}
		}
		return -1;
	}
}
