package de.marvin.ttt.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frames implements ActionListener {
	public JFrame frame = new JFrame();
	JButton nextButton = new JButton("Weiter Spielen");
	JButton openButton = new JButton("Aufdecken");
	JLabel text = new JLabel("Text");

	/*public void displayOther(int zahl, String spieler, String letzterSpieler) {
		frame.setLayout(null);
		nextButton.setBounds(250 - 65, 50, 130, 30);
		frame.add(nextButton);
		nextButton.addActionListener(this);
		openButton.setBounds(250 - 65, 100, 130, 30);
		frame.add(openButton);
		openButton.addActionListener(this);
		text.setText("Wurf von " + letzterSpieler + ": " + zahl);
		text.setBounds(150, 10, 200, 50);
		text.setVisible(true);
		frame.add(text);
		frame.setSize(200, 200);
		frame.setTitle("Was moechtest du tuen " + spieler + "?");
		frame.setBounds(800, 200, 500, 500);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextButton) {
			frame.dispose();
			Start.game.round(Start.game.getStarter());
		} else if (e.getSource() == openButton) {
			frame.dispose();
				Start.game.aufdecken(Start.game.realNum);
		}
	}*/
	
	public void playScene(int scene) {
		
	}
	
	public void updateFrame(int addField, int player) {
		
	}
	
}

