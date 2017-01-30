package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import ui.GamePlay;

//我方子弹的类
public class MyBullet
{
	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	//子弹的伤害
	private int kill;
	private boolean live;
	//子弹的图片
	private ImageIcon bulletImageIcon;
	private GamePlay gamePlay;
	
	public MyBullet(GamePlay gamePlay, int x, int y, int speed, int kill)
	{
		this.gamePlay = gamePlay;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.kill = kill;
		this.live = true;
	}
	
	//设置子弹的图片
	public void setBulletImageIcon(ImageIcon bulletImageIcon)
	{
		this.bulletImageIcon = bulletImageIcon;
		this.width = bulletImageIcon.getIconWidth() / 2;
		this.height = bulletImageIcon.getIconHeight() / 2;
	}
	
	//画出子弹
	public void draw(Graphics g)
	{
		if (live)
		{
			g.drawImage(bulletImageIcon.getImage(), x, y, width, height, gamePlay);
		}
		move();
	}
	
	//子弹的移动
	private void move()
	{
		y -= speed;
		if (y < 0)
		{
			live = false;
		}
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getKill()
	{
		return kill;
	}
	
	public void setKill(int kill)
	{
		this.kill = kill;
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
