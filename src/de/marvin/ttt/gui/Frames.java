package de.marvin.ttt.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import de.marvin.ttt.engine.Game;

/**
 * @author Marvin Würtz
 * 
 * Copyright 2020 Marvin Würtz
 * TicTacToe-Project
 */
public class Frames implements ActionListener {
	private JFrame frame = new JFrame(); //Fenster
	private JPanel gamePane; //Haupt panel ->Liegt auf dem frame. Auf diesem panel liegen der Links und rechts panel
	
	private JPanel setupPane;
	private JTextField roomCode;
	
	//Bild Container
	JLabel swapImgContainer = new JLabel("");
	JLabel currentPlayerContainer = new JLabel("");
	
	//game panel
	JPanel leftGamePanel = new JPanel();
	JPanel rightGamePanel = new JPanel();
	
	//Feldstreifen
	JPanel fieldStripe_v1 = new JPanel();
	JPanel fieldStripe_v2 = new JPanel();
	JPanel fieldStripe_h1 = new JPanel();
	JPanel fieldStripe_h2 = new JPanel();
	//Icons importen
	ImageIcon gameImage = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/gameImg.png"));
	ImageIcon setupImage = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/setupImg.png"));
	ImageIcon swapImage = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/swapImg.png"));
	ImageIcon circleImage = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/oPlayer.png"));
	ImageIcon xImage = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/xPlayer.png"));
	ImageIcon setupHeader = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/setupHeader.gif")); //WICHTIG!!!
	
	JButton OL = new JButton("");
	JButton OM = new JButton("");
	JButton OR = new JButton("");
	JButton ML = new JButton("");
	JButton MM = new JButton("");
	JButton MR = new JButton("");
	JButton UL = new JButton("");
	JButton UM = new JButton("");
	JButton UR = new JButton("");
	
	
	JPanel header = new JPanel();
	JLabel headerImage = new JLabel("");
	JPanel leftSetupPanel = new JPanel();
	JButton onlineButton = new JButton("Start");
	JLabel onlineLabel = new JLabel("Online");
	JPanel rightSetupPanel = new JPanel();
	JButton twoPlayerButton = new JButton("1vs1");
	JButton botButton = new JButton("Bot");
	JLabel offlineLabel = new JLabel("Offline");
	
	private Game gameInstance;
	public Frames(Game game) {
		gameInstance = game;
		init();
	}
	
	public void init() {
		setupGameFrame();
		setupSetupFrame();
		playScene(2);
	}
	
	//Smoother uebergang zwischen dem Game & Setup panel
	public void playScene(int scene) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funktion des Schließbuttons -> Beendet die Applikation
		frame.setResizable(false); //Feste Größe -> Nicht resizeable
		if(scene == 1) {
			frame.setBounds(frame.getX(), frame.getY(), 450, 324); //Position und größe des JFrames
			frame.setTitle("Tic-Tac-Toe"); //Fenster Titel
			frame.setIconImage(gameImage.getImage()); //Image in der Taskleiste
			frame.setContentPane(gamePane); //"Hauptpanel" in Frame einfügen
		} else {
			frame.setIconImage(setupImage.getImage()); //Image in der Taskleiste
			frame.setBounds(100, 100, 540, 500); //Position und größe des JFrames
			frame.setTitle("Tic-Tac-Toe Setup"); //Fenster Titel
			frame.setContentPane(setupPane); //"Hauptpanel" in Frame einfügen
		}
		frame.setVisible(true);
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
	
	/**
	 * Hier wird das GamePanel initialisiert jedoch nicht ins JFrame eingebunden -> Wechseln der scenen(Game/Setup) ohne neues Fenster erstellen moeglich
	 */
	public void setupGameFrame() {	
		
		gamePane = new JPanel(); //Haupt Container/Panel -> Links/Rechts panel liegen auf einem haupt panel
		gamePane.setBorder(new EmptyBorder(5, 5, 5, 5)); //Umrandung vom Haupt panel
		gamePane.setLayout(null);
		
		//Hintergrund position und größe
		leftGamePanel.setBackground(Color.DARK_GRAY);
		leftGamePanel.setBounds(0, 0, 148, 295);
		//Zum haupt panel hinzufügen
		gamePane.add(leftGamePanel);
		leftGamePanel.setLayout(null);
		
		//Imagecontainer auf der Linken seite Initialisieren
		initGameImageContainer();
		//Container hinzufügen
		leftGamePanel.add(swapImgContainer);
		leftGamePanel.add(currentPlayerContainer);
		
		rightGamePanel.setBackground(Color.GRAY);
		rightGamePanel.setBounds(147, 0, 297, 295);
		gamePane.add(rightGamePanel);
		rightGamePanel.setLayout(null);
		
		//Feldstreifen initialisieren
		initField();
		//Feldstreifen zum rechten Panel hinzufügen
		rightGamePanel.add(fieldStripe_v1);
		rightGamePanel.add(fieldStripe_v2);
		rightGamePanel.add(fieldStripe_h1);
		rightGamePanel.add(fieldStripe_h2);
		
		//Buttons initialisieren
		initGameButtons();
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
	
	/**
	 * Hier wird das SetupPanel initialisiert jedoch nicht ins JFrame eingebunden -> Wechseln der scenen(Game/Setup) ohne neues Fenster erstellen moeglich
	 */
	public void setupSetupFrame() {

		setupPane = new JPanel(); //Haupt Container/Panel -> Links/Rechts panel liegen auf einem haupt panel
		setupPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //Umrandung vom Haupt panel
		setupPane.setLayout(null);
		
		//Header panel hinzufuegen -> In dieses kommt ein JLabel worin eine gif laueft -> "header"
		header.setBounds(0, 0, 540, 170);
		setupPane.add(header);
		header.setLayout(null);
		//Gif hinzufuegen
		headerImage.setIcon(setupHeader);
		headerImage.setBounds(0, -16, 540, 199);
		header.add(headerImage);
		
		//Linke seite
		leftSetupPanel.setBackground(Color.LIGHT_GRAY);
		leftSetupPanel.setBounds(0, 169, 196, 302);
		setupPane.add(leftSetupPanel);
		leftSetupPanel.setLayout(null);
		
		//Textfeld erstellen
		roomCode = new JTextField();
		//Schrift festlegen und hintergrund sowie text allignment
		roomCode.setFont(new Font("X-Files", Font.BOLD, 12));
		roomCode.setBackground(Color.GRAY);
		roomCode.setHorizontalAlignment(SwingConstants.CENTER);
		//Predef. text
		roomCode.setText("Roomcode here");
		//Position größe und hinzufügen
		roomCode.setBounds(26, 95, 145, 43);
		leftSetupPanel.add(roomCode);
		roomCode.setColumns(10);
		
		//Knopf um onlinespiel zu starten || In arbeit
		onlineButton.setForeground(Color.BLACK);
		onlineButton.setFont(new Font("X-Files", Font.BOLD, 12));
		onlineButton.setBackground(Color.GRAY);
		onlineButton.setBounds(41, 181, 118, 44);
		onlineButton.addActionListener(this);
		leftSetupPanel.add(onlineButton);
		
		//Positionieren des textes "Online" || Ueberschrifft linke seite
		onlineLabel.setForeground(Color.RED);
		onlineLabel.setFont(new Font("Magneto", Font.BOLD, 17));
		onlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		onlineLabel.setBounds(41, 22, 118, 35);
		leftSetupPanel.add(onlineLabel);
		
		//Rechte seite editieren gleiches prinzip wie linke seite
		rightSetupPanel.setBackground(Color.GRAY);
		rightSetupPanel.setBounds(196, 169, 338, 302);
		setupPane.add(rightSetupPanel);
		rightSetupPanel.setLayout(null);
		
		//Localer multiplayer button
		twoPlayerButton.setForeground(Color.BLACK);
		twoPlayerButton.setBackground(Color.LIGHT_GRAY);
		twoPlayerButton.setFont(new Font("X-Files", Font.BOLD, 12));
		twoPlayerButton.setBounds(115, 95, 118, 44);
		twoPlayerButton.addActionListener(this);
		rightSetupPanel.add(twoPlayerButton);
		
		//Localer singleplayer button -> gegen KI
		botButton.setForeground(Color.BLACK);
		botButton.setFont(new Font("X-Files", Font.BOLD, 12));
		botButton.setBackground(Color.LIGHT_GRAY);
		botButton.setBounds(115, 181, 118, 44);
		botButton.addActionListener(this);
		rightSetupPanel.add(botButton);
		
		//Ueberschrifft "Offline" rechte seite
		offlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		offlineLabel.setForeground(Color.RED);
		offlineLabel.setFont(new Font("Magneto", Font.BOLD, 17));
		offlineLabel.setBounds(115, 26, 118, 35);
		rightSetupPanel.add(offlineLabel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == OL) {
			gameInstance.turn(0);
		} else if(e.getSource() == OM) {
			gameInstance.turn(1);
		} else if(e.getSource() == OR) {
			gameInstance.turn(2);
		} else if(e.getSource() == ML) {
			gameInstance.turn(3);
		} else if(e.getSource() == MM) {
			gameInstance.turn(4);
		} else if(e.getSource() == MR) {
			gameInstance.turn(5);
		} else if(e.getSource() == UL) {
			gameInstance.turn(6);
		} else if(e.getSource() == UM) {
			gameInstance.turn(7);
		} else if(e.getSource() == UR) {
			gameInstance.turn(8);
		} else if(e.getSource() == twoPlayerButton) {
			playScene(1);
		} else if(e.getSource() == onlineButton) {
			JOptionPane.showMessageDialog(frame, "Coming Soon");
		} else if(e.getSource() == botButton) {
			JOptionPane.showMessageDialog(frame, "Coming Soon");
		}
	}
	
	//Koennte man auch weglassen bzw in die setupGameFrame() direkt reintuen
	/**
	 * Die Labels welche die Bilder halten werden die Positionen sowie größe und Bild zugeordnet
	 */
	public void initGameImageContainer() {
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
	public void initGameButtons() {
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

