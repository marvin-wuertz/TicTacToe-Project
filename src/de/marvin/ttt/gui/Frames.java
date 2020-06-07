package de.marvin.ttt.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Marvin Würtz
 * 
 * Copyright 2020 Marvin Würtz
 * TicTacToe-Project
 */
public class Frames implements ActionListener {
	public JFrame frame = new JFrame(); //Fenster
	private JPanel gamePane; //Haupt panel ->Liegt auf dem frame. Auf diesem panel liegen der Links und rechts panel
	//Bild Container
	JLabel swapImgContainer = new JLabel("");
	JLabel currentPlayerContainer = new JLabel("");
	
	//Feldstreifen
	JPanel fieldStripe_v1 = new JPanel();
	JPanel fieldStripe_v2 = new JPanel();
	JPanel fieldStripe_h1 = new JPanel();
	JPanel fieldStripe_h2 = new JPanel();
	//Icons importen
	ImageIcon gameImage = new ImageIcon("image/gameImg.png");
	ImageIcon setupImage = new ImageIcon("image/setupImg.png");
	ImageIcon swapImage = new ImageIcon("image/swapImg.png");
	ImageIcon circleImage = new ImageIcon("image/oPlayer.png");
	ImageIcon xImage = new ImageIcon("image/xPlayer.png");
	
	JButton OL = new JButton("");
	JButton OM = new JButton("");
	JButton OR = new JButton("");
	JButton ML = new JButton("");
	JButton MM = new JButton("");
	JButton MR = new JButton("");
	JButton UL = new JButton("");
	JButton UM = new JButton("");
	JButton UR = new JButton("");
	
	public void playScene(int scene) {
		
	}
	
	public void updateGameFrame(int addField, int player) {

	}
	
	public void startGameFrame() {	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funktion des Schließbuttons -> Beendet die Applikation
		frame.setBounds(100, 100, 450, 324); //Position und größe des JFrames
		frame.setResizable(false); //Feste Größe -> Nicht resizeable
		frame.setTitle("Tic-Tac-Toe"); //Fenster Titel
		gamePane = new JPanel(); //Haupt Container/Panel -> Links/Rechts panel liegen auf einem haupt panel
		gamePane.setBorder(new EmptyBorder(5, 5, 5, 5)); //Umrandung vom Haupt panel
		frame.setContentPane(gamePane); //"Hauptpanel" in Frame einfügen
		gamePane.setLayout(null);
		frame.setIconImage(gameImage.getImage()); //Image in der Taskleiste
		
		//linkes panel
		JPanel leftPanel = new JPanel();
		//Hintergrund position und größe
		leftPanel.setBackground(Color.DARK_GRAY);
		leftPanel.setBounds(0, 0, 148, 295);
		//Zum haupt panel hinzufügen
		gamePane.add(leftPanel);
		leftPanel.setLayout(null);
		
		//Imagecontainer auf der Linken seite Initialisieren
		initImageContainer();
		//Container hinzufügen
		leftPanel.add(swapImgContainer);
		leftPanel.add(currentPlayerContainer);
		
		//Rechtes panel
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.GRAY);
		rightPanel.setBounds(147, 0, 297, 295);
		gamePane.add(rightPanel);
		rightPanel.setLayout(null);
		
		//Feldstreifen initialisieren
		initField();
		//Feldstreifen zum rechten Panel hinzufügen
		rightPanel.add(fieldStripe_v1);
		rightPanel.add(fieldStripe_v2);
		rightPanel.add(fieldStripe_h1);
		rightPanel.add(fieldStripe_h2);
		
		//Buttons initialisieren
		initButtons();
		//Buttons zum rechten "GameFrame" hinzufügen
		rightPanel.add(OL);
		rightPanel.add(OM);
		rightPanel.add(OR);
		rightPanel.add(ML);
		rightPanel.add(UL);
		rightPanel.add(MM);
		rightPanel.add(MR);
		rightPanel.add(UM);
		rightPanel.add(UR);
		
		frame.setVisible(true); //Frame nach initialisieren von allem Sichtbar machen
	}
	
	public void startSetupFrame() {
		//TODO
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == OL) {
			System.out.print("Oben Links");
		}
	}
	
	/**
	 * Die Labels welche die Bilder halten werden die Positionen sowie größe und Bild zugeordnet
	 */
	public void initImageContainer() {
		//LabelIcon setzen -> Designbild
		swapImgContainer.setIcon(swapImage);
		//Position und größe festlegen
		swapImgContainer.setBounds(38, 11, 73, 84);
		
		currentPlayerContainer.setIcon(xImage);
		currentPlayerContainer.setBounds(38, 119, 64, 69);
	}
	
	/**
	 * Die Streifen vom Spielfeld werden die Positionen sowie größe und Hintergrundfarbe zugeordnet
	 */
	public void initField() {
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
	}
	
	/**
	 * Die Buttons vom Spielfeld werden die Positionen sowie größe und Hintergrundfarbe zugeordnet.
	 * Die border wird entfernt vom Button um ihn "Unsichtbar" zu machen und ein ActionListener wird hinzugefügt.
	 */
	public void initButtons() {
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
	}
}

