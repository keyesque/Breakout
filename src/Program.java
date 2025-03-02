import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;
	public static JLabel highScore;
	public static JLabel latestRuns;
	public Program() {
		board = new GameBoard();
		setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);
		highScore = new JLabel("Highscore: 0", JLabel.CENTER);
		highScore.setPreferredSize(new Dimension(70, Game.screenHeight));
		latestRuns = new JLabel("0", JLabel.CENTER);
		latestRuns.setPreferredSize(new Dimension(70, Game.screenHeight));
		add(highScore, BorderLayout.WEST);
		add(latestRuns, BorderLayout.EAST);
		setResizable(false);
		setTitle("Breakout!");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}

	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}
	
	

}
