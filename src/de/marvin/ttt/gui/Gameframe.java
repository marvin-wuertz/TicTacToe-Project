/**
 * 
 */
package de.marvin.ttt.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Marvin Würtz
 * 
 * Copyright 09.06.2020 Marvin Würtz
 * TicTacToe-Project
 * 
 * Ich Initialisiere das Gameframe jedoch wird es noch nicht in das JFrame eingefuegt
 */
public class Gameframe implements ActionListener {
	JButton OL = new JButton("");
	JButton OM = new JButton("");
	JButton OR = new JButton("");
	JButton ML = new JButton("");
	JButton MM = new JButton("");
	JButton MR = new JButton("");
	JButton UL = new JButton("");
	JButton UM = new JButton("");
	JButton UR = new JButton("");
	
	JPanel gamePane; //Haupt panel ->Liegt auf dem frame. Auf diesem panel liegen der Links und rechts panel
	//game panel
	JPanel leftGamePanel = new JPanel();
	JPanel rightGamePanel = new JPanel();
	
	//Feldstreifen
	JPanel fieldStripe_v1 = new JPanel();
	JPanel fieldStripe_v2 = new JPanel();
	JPanel fieldStripe_h1 = new JPanel();
	JPanel fieldStripe_h2 = new JPanel();
	
	//Bild Container
	JLabel swapImgContainer = new JLabel("");
	JLabel currentPlayerContainer = new JLabel("");
	
	//Bilder
	ImageIcon circleImage = new ImageIcon(Gameframe.class.getResource("/de/marvin/ttt/gui/images/oPlayer.png"));
	ImageIcon swapImage = new ImageIcon(Gameframe.class.getResource("/de/marvin/ttt/gui/images/swapImg.png"));
	ImageIcon xImage = new ImageIcon(Gameframe.class.getResource("/de/marvin/ttt/gui/images/xPlayer.png"));
	
	Frames frameInstance;
	
	public Gameframe(Frames frame) {
		frameInstance = frame;
		initFrame();
	}
	
	public JPanel getGamePane() {
		return gamePane;
	}
	
	/**
	 * Nach jedem zug wird das uebergebene Feld mit dem passenden icon versehen
	 */
	public void updateGameFrame(int pos, int player) {
		//TODO
		ImageIcon playerIcon;
		ImageIcon nextPlayerIcon;
		if(player == 0) {//0 = X
			playerIcon = xImage;
			nextPlayerIcon = circleImage;
		} else {
			playerIcon = circleImage;
			nextPlayerIcon = xImage;
		}
			switch (pos) {
			case 0:
				OL.setIcon(playerIcon);
				break;
			case 1:
				OM.setIcon(playerIcon);
				break;
			case 2:
				OR.setIcon(playerIcon);
				break;
			case 3:
				ML.setIcon(playerIcon);
				break;
			case 4:
				MM.setIcon(playerIcon);
				break;
			case 5:
				MR.setIcon(playerIcon);
				break;
			case 6:
				UL.setIcon(playerIcon);
				break;
			case 7:
				UM.setIcon(playerIcon);
				break;
			case 8:
				UR.setIcon(playerIcon);
				break;
			}
			currentPlayerContainer.setIcon(nextPlayerIcon);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == OL) {
			frameInstance.callTurn(0);
		} else if(e.getSource() == OM) {
			frameInstance.callTurn(1);
		} else if(e.getSource() == OR) {
			frameInstance.callTurn(2);
		} else if(e.getSource() == ML) {
			frameInstance.callTurn(3);
		} else if(e.getSource() == MM) {
			frameInstance.callTurn(4);
		} else if(e.getSource() == MR) {
			frameInstance.callTurn(5);
		} else if(e.getSource() == UL) {
			frameInstance.callTurn(6);
		} else if(e.getSource() == UM) {
			frameInstance.callTurn(7);
		} else if(e.getSource() == UR) {
			frameInstance.callTurn(8);
		}
	}

	/**
	 * Hier wird das GamePanel initialisiert jedoch nicht ins JFrame eingebunden -> Wechseln der scenen(Game/Setup) ohne neues Fenster erstellen moeglich
	 */
	private void initFrame() {
		gamePane = new JPanel(); //Haupt Container/Panel -> Links/Rechts panel liegen auf einem haupt panel
		gamePane.setBorder(new EmptyBorder(5, 5, 5, 5)); //Umrandung vom Haupt panel
		gamePane.setLayout(null);
		
		//Hintergrund position und größe
		leftGamePanel.setBackground(Color.DARK_GRAY);
		leftGamePanel.setBounds(0, 0, 148, 295);
		//Zum haupt panel hinzufügen
		gamePane.add(leftGamePanel);
		leftGamePanel.setLayout(null);
		
		/**
		 * Die Labels welche die Bilder halten werden die Positionen sowie größe und Bild zugeordnet
		 */
		//LabelIcon setzen -> Designbild
		swapImgContainer.setIcon(swapImage);
		//Position und größe festlegen
		swapImgContainer.setBounds(38, 11, 73, 84);
		
		currentPlayerContainer.setIcon(xImage);
		currentPlayerContainer.setBounds(38, 119, 64, 69);
		//Container hinzufügen
		leftGamePanel.add(swapImgContainer);
		leftGamePanel.add(currentPlayerContainer);
		
		rightGamePanel.setBackground(Color.GRAY);
		rightGamePanel.setBounds(147, 0, 297, 295);
		gamePane.add(rightGamePanel);
		rightGamePanel.setLayout(null);
		
		/**
		 * Die Streifen vom Spielfeld werden die Positionen sowie größe und Hintergrundfarbe zugeordnet
		 */
		//Feldstreifen initialisieren
		//Schwarze hintergrundfarbe um einen Shcwarzen streifen zu erstellen
		fieldStripe_v1.setBackground(Color.BLACK);
		//Position und größe festlegen
		fieldStripe_v1.setBounds(91, 11, 19, 262);
		
		fieldStripe_v2.setBackground(Color.BLACK);
		fieldStripe_v2.setBounds(189, 11, 19, 262);
		
		fieldStripe_h1.setBackground(Color.BLACK);
		fieldStripe_h1.setBounds(10, 90, 277, 15);
		
		fieldStripe_h2.setBackground(Color.BLACK);
		fieldStripe_h2.setBounds(10, 179, 277, 15);
		//Feldstreifen zum rechten Panel hinzufügen
		rightGamePanel.add(fieldStripe_v1);
		rightGamePanel.add(fieldStripe_v2);
		rightGamePanel.add(fieldStripe_h1);
		rightGamePanel.add(fieldStripe_h2);
		
		/**
		 * Die Buttons vom Spielfeld werden die Positionen sowie größe und Hintergrundfarbe zugeordnet.
		 * Die border wird entfernt vom Button um ihn "Unsichtbar" zu machen und ein ActionListener wird hinzugefügt.
		 */
		//Farbe für den Vordergrund -> Gleich wie die hintergrundfarbe vom container
		OL.setForeground(Color.GRAY);
		//Farbe für den Hintergrund -> Gleich wie die hintergrundfarbe vom container
		OL.setBackground(Color.GRAY);
		//Position und Größe
		OL.setBounds(10, 11, 80, 80);
		//Umrandug verstecken
		OL.setBorderPainted(false);
		OL.setFocusable(false);
		//ActionListener initialisieren -> Klickevent
		OL.addActionListener(this);

		OM.setForeground(Color.GRAY);
		OM.setBackground(Color.GRAY);
		OM.setBounds(111, 11, 80, 80);
		OM.setBorderPainted(false);
		OM.setFocusable(false);
		OM.addActionListener(this);
		
		OR.setForeground(Color.GRAY);
		OR.setBackground(Color.GRAY);
		OR.setBounds(207, 11, 80, 80);
		OR.setBorderPainted(false);
		OR.setFocusable(false);
		OR.addActionListener(this);
		
		
		ML.setForeground(Color.GRAY);
		ML.setBackground(Color.GRAY);
		ML.setBounds(10, 102, 80, 80);
		ML.setBorderPainted(false);
		ML.setFocusable(false);
		ML.addActionListener(this);
		
		MM.setForeground(Color.GRAY);
		MM.setBackground(Color.GRAY);
		MM.setBounds(111, 102, 80, 80);
		MM.setBorderPainted(false);
		MM.setFocusable(false);
		MM.addActionListener(this);
		
		MR.setForeground(Color.GRAY);
		MR.setBackground(Color.GRAY);
		MR.setBounds(207, 102, 80, 80);
		MR.setBorderPainted(false);
		MR.setFocusable(false);
		MR.addActionListener(this);
		
		UL.setForeground(Color.GRAY);
		UL.setBackground(Color.GRAY);
		UL.setBounds(10, 193, 80, 80);
		UL.setBorderPainted(false);
		UL.setFocusable(false);
		UL.addActionListener(this);
		
		UM.setForeground(Color.GRAY);
		UM.setBackground(Color.GRAY);
		UM.setBounds(111, 193, 80, 80);
		UM.setBorderPainted(false);
		UM.setFocusable(false);
		UM.addActionListener(this);
		
		UR.setForeground(Color.GRAY);
		UR.setBackground(Color.GRAY);
		UR.setBounds(207, 193, 80, 80);
		UR.setBorderPainted(false);
		UR.setFocusable(false);
		UR.addActionListener(this);
		//Buttons zum rechten "GameFrame" hinzufügen
		rightGamePanel.add(OL);
		rightGamePanel.add(OM);
		rightGamePanel.add(OR);
		rightGamePanel.add(ML);
		rightGamePanel.add(UL);
		rightGamePanel.add(MM);
		rightGamePanel.add(MR);
		rightGamePanel.add(UM);
		rightGamePanel.add(UR);
		
		//frame.setVisible(true); //Frame nach initialisieren von allem Sichtbar machen
	}
}
