package de.marvin.ttt.engine;

import java.awt.Color;

import de.marvin.ttt.gui.Frames;

/**
 * @author Marvin Würtz
 * 
 *         Copyright 06.06.2020 Marvin Würtz TicTacToe-Project
 */
public class Game {
	Frames frames = new Frames(this); // Der Frameclasse die Aktuelle Instance(Object) der Klasse Game ueberliefern um
										// auf die turn methode zugriff zu haben
	private int player = 0; // 0=X, 1=O
	private String[] matchfield = new String[9];
	private boolean bot = false;
	ComputerAI comp = new ComputerAI();

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
			if (checkWin() != null) {
				System.out.println("Spiel vorbei. //TODO");
				String temp = checkWin();
				if (temp.equals("draw")) {
					frames.endscreenDraw();
				} else {
					String[] split = temp.split(":");
					if (split[0].equals("X")) {
						frames.endscreen(Color.BLUE, Integer.parseInt(split[1]));
					} else {
						frames.endscreen(Color.RED, Integer.parseInt(split[1]));
					}
				}
				// Spielfeld fuellen -> Nichts kann mehr gesetzt werden
				for (int i = 0; i < matchfield.length; i++) {
					if (matchfield[i] == null) {
						matchfield[i] = "Placeholder";
					}
				}
			}
			if (checkWin() == null) {
				if (bot == true) {
					botTurn();
				}
			}
		}
	}

	public void botTurn() {
		int place = comp.getField(matchfield);
		matchfield[place] = "O";
		player = 0;
		frames.updateGameframe(place, 1);
		if (checkWin() != null) {
			System.out.println("Spiel vorbei. //TODO");
			String temp = checkWin();
			if (temp.equals("draw")) {
				frames.endscreenDraw();
			} else {
				String[] split = temp.split(":");
				if (split[0].equals("X")) {
					frames.endscreen(Color.BLUE, Integer.parseInt(split[1]));
				} else {
					frames.endscreen(Color.RED, Integer.parseInt(split[1]));
				}
			}
			// Spielfeld fuellen -> Nichts kann mehr gesetzt werden
			for (int i = 0; i < matchfield.length; i++) {
				if (matchfield[i] == null) {
					matchfield[i] = "Placeholder";
				}
			}
		}
	}

	public boolean getBotStatus() {
		return bot;
	}

	public void setBot(boolean boo) {
		bot = boo;
	}

	public void reset() {
		matchfield = new String[9];
		player = 0;
	}

	private String checkWin() {
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
				return "X:" + i;
			} else if (temp.equals("OOO")) {
				return "O:" + i;
			}
		}

		if (isMatchfieldFull()) {
			System.out.println("Keiner hat gewonnen");
			return "draw";
		} else {
			return null;
		}

	}

	private boolean isMatchfieldFull() {
		int counter = 0;
		for (int i = 0; i < 9; i++) {
			if (matchfield[i] != null) {
				counter++;
			}
		}
		if (counter == 9) {
			return true;
		} else {
			return false;
		}
	}

}
