package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tools.Config;
import tools.MysqlConnection;
import tools.Player;

public class MainFrame extends JFrame implements ActionListener
{
	private GameBackground gameBackground;
	private GameMenu gameMenu;
	private GameTopScore gameTopScore;
	private GameLoading gameLoading;
	private GamePlay gamePlay;
	
	public MainFrame()
	{
		init();
		Menu();
	}

	private void init()
	{
		this.setTitle("王牌战机");
		this.setIconImage(new ImageIcon(Config.ICON_IMAGE).getImage());
		this.setSize(Config.GAME_WIDTH, Config.GAME_HEIGHT + Config.GAME_UP_HEIGHT);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((d.width - Config.GAME_WIDTH) / 2, (d.height - Config.GAME_HEIGHT - Config.GAME_UP_HEIGHT) / 2, Config.GAME_WIDTH, Config.GAME_HEIGHT + Config.GAME_UP_HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void Menu()
	{
		Container c = this.getContentPane();
		c.removeAll();
		this.repaint();
		
		//设置背景图片
		Image backgroundImage = new ImageIcon(Config.START_BACKGROUND_IMAGE).getImage();
		gameBackground = new GameBackground(backgroundImage);
		
		//获取菜单画板
		if (this.gameMenu == null)
		{
			this.gameMenu = new GameMenu(this);
		}
		
		c.add(gameBackground);
		//利用GridLayout布局设置菜单的垂直位置
		gameBackground.setLayout(new BorderLayout());
		JPanel jPanel = new JPanel(new GridLayout(5, 1, 10, 90));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		gameBackground.add(jPanel, BorderLayout.NORTH);
		gameBackground.add(this.gameMenu, BorderLayout.CENTER); 
		//显示画面
		this.validate();
	}
	
	private void TopScore()
	{
		Container c = this.getContentPane();
		c.removeAll();
		this.repaint();
		
		Image backgroundImage = new ImageIcon(Config.BACKGROUND_IMAGE).getImage();
		gameBackground = new GameBackground(backgroundImage);
		
		if (gameTopScore == null)
		{
			gameTopScore = new GameTopScore(this);
		}
		
		//加载分数并写在按钮上
		gameTopScore.loadScore();
		
		c.add(gameBackground);
		gameBackground.setLayout(new BorderLayout());
		JPanel jPanel = new JPanel(new GridLayout(5, 1, 10, 1));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		gameBackground.add(jPanel, BorderLayout.NORTH);
		gameBackground.add(this.gameTopScore, BorderLayout.CENTER);
		this.validate();
	}
	
	private void startGameAction()
	{
		new Thread(new startGameClass()).start();
	}
	
	private void loadingGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		Container c = this.getContentPane();
		c.removeAll();
		this.repaint();
		
		Image backgroundImage = new ImageIcon(Config.BACKGROUND_IMAGE).getImage();
		gameBackground = new GameBackground(backgroundImage);

		gameLoading = new GameLoading(this);
		
		c.add(gameBackground);
		gameBackground.setLayout(new FlowLayout());
		gameBackground.add(gameLoading);
		gameLoading.loading();
		
		startGame();
	}
	
	private class startGameClass implements Runnable
	{

		@Override
		public void run()
		{
			try
			{
				loadingGame();
			}
			catch (UnsupportedAudioFileException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (LineUnavailableException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	private void startGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		Container c = this.getContentPane();
		c.removeAll();
		this.repaint();
		
		c.setLayout(new BorderLayout());
		c.add(gameBackground);
		gameBackground.setLayout(new BorderLayout());
		gamePlay = new GamePlay();
		gameBackground.add(gamePlay, BorderLayout.CENTER);
		gamePlay.setOpaque(false);
		gamePlay.startGame();
		this.validate();
		
		//KeyListener监听必需在窗体显示之后调用requestFocus方法使其获得焦点，否则KeyListener事件无法触发，鼠标点击事件、拖动事件等则不需要
		gamePlay.requestFocus();
		
		while (gamePlay.getMyPlane().isLive())
		{
			try
			{
				Thread.sleep(Config.GAME_REPAINT_TIME);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		addScore(gamePlay.getScore());
		GameOver();
		
	}
	
	private void GameOver()
	{
		gamePlay.setLayout(new BorderLayout());
		JPanel gamePlayUp = new JPanel(new GridLayout(2, 1, 0, 520));
		gamePlayUp.setOpaque(false);
		gamePlay.add(gamePlayUp, BorderLayout.NORTH);
		
		JPanel gamePlayCenter = new JPanel(new FlowLayout());
		gamePlayCenter.setLayout(null);
		gamePlayCenter.setOpaque(false);
		gamePlay.add(gamePlayCenter, BorderLayout.CENTER);
		
		GameButton backButton = new GameButton("Back");
		backButton.setActionCommand(GameTopScore.BACK_BUTTON);
		backButton.addActionListener(this);
		gamePlayCenter.add(backButton);
		backButton.setBounds(Config.GAME_WIDTH / 2 - Config.BUTTON_WIDTH / 2, 0, Config.BUTTON_WIDTH, Config.BUTTON_HEIGHT);
		
		this.validate();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String actionCmd = e.getActionCommand();
		if (actionCmd.equals(GameMenu.START_GAME_BUTTON))
		{
			startGameAction();
		}
		else if (actionCmd.equals(GameMenu.SCORES_BUTTON))
		{
			TopScore();
		}
		else if (actionCmd.equals(GameMenu.EXIT_GAME_BUTTON))
		{
			exitGame();
		}
		else if (actionCmd.equals(GameTopScore.BACK_BUTTON))
		{
			Menu();
		}
	}
	
	
	private void addScore(int score)
	{
		MysqlConnection mysqlConnection = new MysqlConnection();
		mysqlConnection.insertScore(score);
	}

	private void exitGame()
	{
		System.exit(0);
	}
}
