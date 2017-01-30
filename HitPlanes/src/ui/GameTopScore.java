package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Score;
import tools.Config;
import tools.MysqlConnection;

public class GameTopScore extends JPanel
{
	private MysqlConnection mysqlConnection = new MysqlConnection();
	private List<Score> scoresList;
	private GameButton backButton;
	private GameButton[] scoreButton;
	private final int COUNT = 10;
	private JLabel top10Label;
	public final static String BACK_BUTTON = "BACK";

	public GameTopScore(MainFrame mainFrame)
	{
		initComponents(mainFrame);
		this.scoresList = mysqlConnection.selectScore();
	}

	private void initComponents(MainFrame mainFrame)
	{
		top10Label = new JLabel("Top 10");
		top10Label.setFont(new Font("Dialog", Font.BOLD, 40));
		top10Label.setForeground(Color.BLUE);
		JPanel labelPanel = new JPanel();
		labelPanel.setOpaque(false);
		labelPanel.add(top10Label);
		
		JPanel scorePanel = new JPanel(new GridLayout(12, 1, 0, 5));
		scorePanel.setOpaque(false);
		
		scorePanel.add(labelPanel);
		
		scoreButton = new GameButton[COUNT];
		for (int i = 0; i < COUNT; i++)
		{
			scoreButton[i] = new GameButton();
			scorePanel.add(scoreButton[i]);
		}
		
		backButton = new GameButton("BACK");
		backButton.setActionCommand(BACK_BUTTON);
		backButton.addActionListener(mainFrame);
		scorePanel.add(backButton);
		
		Dimension d = new Dimension(Config.SCORE_PANEL_WIDTH, Config.SCORE_PANEL_HEIGHT);
		scorePanel.setSize(d);
		scorePanel.setPreferredSize(d);
		
		this.add(scorePanel);
		this.setOpaque(false);
	}
	
	public void loadScore()
	{
		int scoreSize = scoresList.size();
		for (int i = 0; i < scoreSize; i++)
		{
			Score score = scoresList.get(i);
			this.scoreButton[i].setStr(score.getUser_score() + "");
		}
	}
}
