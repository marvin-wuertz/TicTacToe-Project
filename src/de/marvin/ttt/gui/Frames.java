package de.marvin.ttt.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frames implements ActionListener {
	public JFrame frame = new JFrame();
	ImageIcon gameImage = new ImageIcon("image/gameImg.png");
	ImageIcon setupImage = new ImageIcon("image/setupImg.png");
	JButton OL = new JButton("");
	JButton OM = new JButton("");
	JButton OR = new JButton("");
	
	JButton ML = new JButton("");
	JButton MM = new JButton("");
	JButton MR = new JButton("");
	
	JButton UL = new JButton("");
	JButton UM = new JButton("");
	JButton UR = new JButton("");
	
	//JLabel text = new JLabel("Text");
	
	public void playScene(int scene) {
		
	}
	
	public void updateGameFrame(int addField, int player) {
		
	}
	
	public void startGameFrame() {
		frame.setLayout(null);
		frame.setSize(200, 200);
		frame.setTitle("Tic-Tac-Toe");
		frame.setBounds(800, 200, 500, 500);
		frame.setIconImage(gameImage.getImage());
		frame.setVisible(true);
	}
	
	public void startSetupFrame() {
		frame.setLayout(null);
		frame.setSize(200, 200);
		frame.setTitle("Tic-Tac-Toe Setup");
		frame.setBounds(800, 200, 500, 500);
		frame.setIconImage(setupImage.getImage());
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == nextButton) {
			frame.dispose();
			Start.game.round(Start.game.getStarter());
		} else if (e.getSource() == openButton) {
			frame.dispose();
				Start.game.aufdecken(Start.game.realNum);
		}*/
	}
	
}

