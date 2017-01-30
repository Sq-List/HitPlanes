package ui;

import java.awt.Graphics;
import java.awt.PaintContext;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tools.Config;

public class GamePlayBackground extends JPanel
{
	private int x;
	private int y;
	private int yspeed;
	private int width;
	private int height;
	private ImageIcon gamePlayBackground;
	private GamePlay gamePlay;
	
	public GamePlayBackground(GamePlay gamePlay, ImageIcon imageIcon)
	{
		this.gamePlayBackground = imageIcon;
		this.gamePlay = gamePlay;
		this.width = imageIcon.getIconWidth();
		this.height = imageIcon.getIconHeight();
		this.x = 0;
		this.y = 0;
		this.yspeed = Config.GAME_PLAY_BACKGROUND_YSPEED;
	}
	
	//���������ı���
	public void draw(Graphics g)
	{
		y += yspeed;
		if (y > Config.GAME_HEIGHT)
		{
			//����80��ʹy�������ڴ�С���¹���ʱ����������
			y = 80;
		}
		g.drawImage(gamePlayBackground.getImage(), 0, y, width, height, 0, 0, width, height - y, gamePlay);
		g.drawImage(gamePlayBackground.getImage(), 0, 0, width, y, 0, height - y, width, height, gamePlay);
		
	}
}
