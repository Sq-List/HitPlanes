package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import tools.Config;
import ui.GamePlay;

public class Prop
{
	//���ߵ�����
	private int x;
	private int y;
	
	//�����ƶ����ٶ�
	private int xspeed;
	private int yspeed;
	
	//���ߵĴ�С
	private int width;
	private int height;
	private int temp;
	
	private boolean live;
	
	//����ˮƽ�ƶ��ķ���
	private boolean right;
	
	//���ߵ�ͼƬ
	private ImageIcon propImage;
	private GamePlay gamePlay;
	
	public Prop(GamePlay gamePlay, int x, int y)
	{
		Random random = new Random();
		this.gamePlay = gamePlay;
		this.propImage = new ImageIcon(Config.PROP_IMAGE);
		this.x = x;
		this.y = y;
		this.yspeed = Config.PROP_YSPEED;
		this.xspeed = Config.PROP_XSPEED;
		this.temp = width / 3;
		this.width = propImage.getIconWidth();
		this.height = propImage.getIconHeight();
		this.right = random.nextBoolean();
		this.live = true;
	}
	
	//��������
	public void draw(Graphics g)
	{
		if (live)
		{
			g.drawImage(propImage.getImage(), x, y, width, height, gamePlay);
		}
		move();
	}
	
	//���ߵ��ƶ�
	private void move()
	{
		if (right)
		{
			x += xspeed;
		}
		else
		{
			x -= xspeed;
		}
		
		y += yspeed;
		
		if (x > Config.GAME_WIDTH - width / 2 || x < 0)
		{
			right = !right;
		}
		
		if (y > Config.GAME_HEIGHT + height)
		{
			live = false;
		}
	}

	public Rectangle getRctangle()
	{
		return new Rectangle(x, y, width, height);
	}
	
	public boolean isLive()
	{
		return live;
	}
	
	public void setLive(boolean live)
	{
		this.live = live;
	}
}
