package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.Config;

public class GameMenu extends JPanel
{
	private GameButton startGameButton;
	private GameButton exitGameButton;
	private GameButton top10ScoresButton;
	
	public final static String START_GAME_BUTTON = "START_GAME_BUTTON";
	public final static String EXIT_GAME_BUTTON = "EXIT_GAME_BUTTON";
	public final static String SCORES_BUTTON = "SCORES_BUTTON";
	
	public GameMenu(MainFrame mainFrame)
	{
		this.initComponents(mainFrame);
	}
	
	private void initComponents(MainFrame mainFrame)
	{
		this.startGameButton = new GameButton("New Game");
		//添加监听对象为窗口
		this.startGameButton.addActionListener(mainFrame);
		//设置此组件激发的操作事件的命令名称
		this.startGameButton.setActionCommand(START_GAME_BUTTON);
		//设置控件是透明
		this.startGameButton.setOpaque(false);
		
		this.top10ScoresButton = new GameButton("Top 10 Scores");
		this.top10ScoresButton.addActionListener(mainFrame);
		this.top10ScoresButton.setActionCommand(SCORES_BUTTON);
		this.top10ScoresButton.setOpaque(false);
		
		this.exitGameButton = new GameButton("Exit Game");
		this.exitGameButton.addActionListener(mainFrame);
		this.exitGameButton.setActionCommand(EXIT_GAME_BUTTON);
		this.exitGameButton.setOpaque(false);
		
		GridLayout gridLayout = new GridLayout(3, 1, 0, 10);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(gridLayout);
		
		buttonPanel.add(startGameButton);
		buttonPanel.add(top10ScoresButton);
		buttonPanel.add(exitGameButton);
		
		Dimension d = new Dimension(Config.MENU_PANEL_WIDTH, Config.MENU_PANEL_HEIGHT);
		buttonPanel.setSize(d);
		buttonPanel.setPreferredSize(d);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		
		this.setOpaque(false);
		this.add(mainPanel);
	}
}
