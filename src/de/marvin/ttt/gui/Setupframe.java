/**
 * 
 */
package de.marvin.ttt.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author Marvin Würtz
 * 
 * Copyright 09.06.2020 Marvin Würtz
 * TicTacToe-Project
 */
public class Setupframe implements ActionListener {
	private JPanel setupPane;
	private JTextField roomCode;
	
	JPanel header = new JPanel();
	JLabel headerImage = new JLabel("");
	JPanel leftSetupPanel = new JPanel();
	JButton onlineButton = new JButton("Start");
	JLabel onlineLabel = new JLabel("Online");
	JPanel rightSetupPanel = new JPanel();
	JButton twoPlayerButton = new JButton("1vs1");
	JButton botButton = new JButton("Bot");
	JLabel offlineLabel = new JLabel("Offline");
	
	ImageIcon setupHeader = new ImageIcon(Frames.class.getResource("/de/marvin/ttt/gui/images/setupHeader.gif")); 
	
	Frames frameInstance;
	
	public Setupframe(Frames frame) {
		frameInstance = frame;
		initFrame();
	}
	
	public JPanel getSetupPane() {
		return setupPane;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == twoPlayerButton) {
			 	frameInstance.setBot(false);
				frameInstance.playScene(1);
			} else if(e.getSource() == onlineButton) {
				JOptionPane.showMessageDialog(frameInstance.getFrame(), "Coming Soon");
			} else if(e.getSource() == botButton) {
				frameInstance.setBot(true);
				frameInstance.playScene(1);
			}
	}
	
	/**
	 * Hier wird das SetupPanel initialisiert jedoch nicht ins JFrame eingebunden -> Wechseln der scenen(Game/Setup) ohne neues Fenster erstellen moeglich
	 */
	private void initFrame() {
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
	
}
