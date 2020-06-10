package de.marvin.ttt.gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.marvin.ttt.engine.Game;

/**
 * @author Marvin Würtz
 * 
 * Copyright 2020 Marvin Würtz
 * TicTacToe-Project
 * 
 * Die Klasse soll als Postbote zwischen der Spielengine und den Frames sein (Komunizierer)
 * Alles was in ein Frame geaendert werden soll oder in der Gameengine aufgerufen werden soll wird hierrueber verteilt
 */
public class Frames {
	private JFrame frame = new JFrame(); //Fenster
	
	//Icons importen
	private ImageIcon gameImage = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/gameImg.png"));
	private ImageIcon setupImage = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/setupImg.png"));
	
	private Game gameInstance;
	private Gameframe gameframe;
	private Setupframe setupframe;
	private JPanel gamePane;
	private JPanel setupPane;
	
	public Frames(Game game) {
		gameInstance = game;
		gameframe = new Gameframe(this);
		setupframe = new Setupframe(this);
		init();
	}
	
	public void endscreen(Color color, int id) {
		setWinnerBorder(color, id);
		gameframe.displayEnd(); 
		playScene(1); //Panel updaten (Neue Buttons werden nicht angezeigt)
	}
	
	public void endscreenDraw() {
		gameframe.displayEnd();
		playScene(1);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void init() {
		gamePane = gameframe.getGamePane();
		setupPane = setupframe.getSetupPane();
		playScene(2);
	}
	
	public void updateGameframe(int pos, int player) {
		gameframe.updateGameFrame(pos, player);
	}
	
	public void setWinnerBorder(Color color, int id) {
		gameframe.addBorder(color, id);
	}
	
	public void callTurn(int id) {
		gameInstance.turn(id);
	}
	
	//Smoother uebergang zwischen dem Game & Setup panel
	public void playScene(int scene) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funktion des Schließbuttons -> Beendet die Applikation
		frame.setResizable(false); //Feste Größe -> Nicht resizeable
		if(scene == 1) {
			gameInstance.reset();
			gamePane = gameframe.getGamePane();
			frame.setBounds(frame.getX(), frame.getY(), 450, 324); //Position und größe des JFrames
			frame.setTitle("Tic-Tac-Toe"); //Fenster Titel
			frame.setIconImage(gameImage.getImage()); //Image in der Taskleiste
			frame.setContentPane(gamePane); //"Hauptpanel" in Frame einfügen
		} else {
			setupPane = setupframe.getSetupPane();
			frame.setIconImage(setupImage.getImage()); //Image in der Taskleiste
			frame.setBounds(100, 100, 540, 500); //Position und größe des JFrames
			frame.setTitle("Tic-Tac-Toe Setup"); //Fenster Titel
			frame.setContentPane(setupPane); //"Hauptpanel" in Frame einfügen
		}
		frame.setVisible(true);
	}
	
	public void setBot(boolean bot) {
		gameInstance.setBot(bot);
	}
	
	public boolean isBot() { 
		return gameInstance.getBotStatus();
	}
	
}

