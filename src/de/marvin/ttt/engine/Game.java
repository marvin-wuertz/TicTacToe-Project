package de.marvin.ttt.engine;

import de.marvin.ttt.gui.Frames;

/**
 * @author Marvin Würtz
 * 
 *         Copyright 06.06.2020 Marvin Würtz TicTacToe-Project
 */
public class Game {
	Frames frames = new Frames(this); //Der Frameclasse die Aktuelle Instance(Object) der Klasse Game ueberliefern um auf die turn methode zugriff zu haben
	private int player = 0; // 0=X, 1=O
	private String[] matchfield = new String[9];

	public void turn(int pos) {
		if (matchfield[pos] == null) {
			frames.updateGameframe(pos, player);
			if (player == 0) {
				matchfield[pos] = "X";
				player = 1;
			} else {
				matchfield[pos] = "O";
				player = 0;
			}
			if(checkWin()) {
				System.out.println("Spiel vorbei. //TODO");
			}
		}
	}

	private boolean checkWin() {
		for (int i = 0; i < 8; i++) {
			String temp = null;
			switch (i) {
			case 0:
				temp = matchfield[0] + matchfield[1] + matchfield[2];
				break;
			case 1:
				temp = matchfield[3] + matchfield[4] + matchfield[5];
				break;
			case 2:
				temp = matchfield[6] + matchfield[7] + matchfield[8];
				break;
			case 3:
				temp = matchfield[0] + matchfield[3] + matchfield[6];
				break;
			case 4:
				temp = matchfield[1] + matchfield[4] + matchfield[7];
				break;
			case 5:
				temp = matchfield[2] + matchfield[5] + matchfield[8];
				break;
			case 6:
				temp = matchfield[0] + matchfield[4] + matchfield[8];
				break;
			case 7:
				temp = matchfield[2] + matchfield[4] + matchfield[6];
				break;
			}
			if (temp.equals("XXX")) {
				System.out.println("Spieler X hat gewonnen");
				return true;
			} else if (temp.equals("OOO")) {
				System.out.println("Spieler O hat gewonnen");
				return true;
			}
		}

		if(isMatchfieldFull()) {
			System.out.println("Keiner hat gewonnen");
			return true;
		} else {
			return false;
		}
		
	}
	
	private boolean isMatchfieldFull() {
		int counter = 0;
		for(int i = 0; i < 9; i++) {
			if(matchfield[i] != null) {
				counter++;
			}
		}
		if(counter == 9) {
			return true;
		} else {
			return false;
		}
	}

}
