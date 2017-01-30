package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import tools.Config;
import ui.GamePlay;

public class Prop
{
	//道具的坐标
	private int x;
	private int y;
	
	//道具移动的速度
	private int xspeed;
	private int yspeed;
	
	//道具的大小
	private int width;
	private int height;
	private int temp;
	
	private boolean live;
	
	//道具水平移动的方向
	private boolean right;
	
	//道具的图片
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
	
	//画出道具
	public void draw(Graphics g)
	{
		if (live)
		{
			g.drawImage(propImage.getImage(), x, y, width, height, gamePlay);
		}
		move();
	}
	
	//道具的移动
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
