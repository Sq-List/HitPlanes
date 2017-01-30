package ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.Config;

public class GameLoading extends JPanel
{
	private ImageIcon[] gameLoadingPlaneImgList;
	private JPanel gameLoadingPlane;
	private JLabel gameLoadingPlaneLabel;
	
	
	public GameLoading(MainFrame mainFrame)
	{
		initComponents(mainFrame);
	}
	
	private void initComponents(MainFrame mainFrame)
	{
		this.gameLoadingPlaneImgList = new ImageIcon[4];
		this.gameLoadingPlaneImgList[0] = new ImageIcon(Config.COUNTDOWN_IAMGE_0);
		this.gameLoadingPlaneImgList[1] = new ImageIcon(Config.COUNTDOWN_IAMGE_1);
		this.gameLoadingPlaneImgList[2] = new ImageIcon(Config.COUNTDOWN_IAMGE_2);
		this.gameLoadingPlaneImgList[3] = new ImageIcon(Config.COUNTDOWN_IAMGE_3);
		
		gameLoadingPlaneLabel = new JLabel();
		gameLoadingPlaneLabel.setOpaque(false);
		
		gameLoadingPlane = new JPanel(new FlowLayout());
		gameLoadingPlane.add(gameLoadingPlaneLabel);
		gameLoadingPlane.setOpaque(false);
		
		GridLayout gridLayout = new GridLayout(1, 1);
		
		this.setLayout(gridLayout);
		this.setOpaque(false);
		this.add(gameLoadingPlane);
	}

	public void loading()
	{
		int count = 4;
		for (int i = count - 1; i >= 0; i--)
		{
			gameLoadingPlaneLabel.setIcon(gameLoadingPlaneImgList[i]);
			if (i != 0)
			{
				try
				{
					Thread.sleep(Config.GAME_LOADING_TIME);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
