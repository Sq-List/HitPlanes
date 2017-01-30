package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.sound.midi.Instrument;
import javax.swing.ImageIcon;

import tools.Config;
import ui.GamePlay;

//敌方子弹的抽象
public class EnemyBullet
{
	private int yspeed;
	private int xspeed;
	//子弹是否向左
	private boolean right;
	private int x;
	private int y;
	private boolean live;
	private int width;
	private int height;
	private int enemyType;
	//子弹的图片
	private ImageIcon bulletImage;
	private GamePlay gamePlay;
	
	public EnemyBullet(GamePlay gamePlay, int x, int y, int yspeed, int enemyType)
	{
		Random random = new Random();
		this.gamePlay = gamePlay;
		this.enemyType = enemyType;
		this.x = x;
		this.y = y;
		this.live = true;
		this.right = random.nextBoolean();
		this.yspeed = yspeed;
		this.xspeed = random.nextInt(5);
	}
	
	//画出图片
	public void draw(Graphics g)
	{
		if (live)
		{
			g.drawImage(bulletImage.getImage(), x, y, width, height, gamePlay);
		}
		move();
	}
	
	//移动
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
		
		if (x > Config.GAME_WIDTH + width || x < 0)
		{
			live = false;
		}
		
		if (y > Config.GAME_HEIGHT + height)
		{
			live = false;
		}
		
	}
	
	//设置图片
	public void setBulletImage(ImageIcon bulletImage)
	{
		this.bulletImage = bulletImage;
		this.height = bulletImage.getIconHeight();
		this.width = bulletImage.getIconWidth();
	}
	
	public int getYspeed()
	{
		return yspeed;
	}
	
	public void setYspeed(int yspeed)
	{
		this.yspeed = yspeed;
	}

	public int getEnemyType()
	{
		return enemyType;
	}

	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}

	
	public int getHeight()
	{
		return height;
	}

	
	public void setHeight(int height)
	{
		this.height = height;
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

	
	public boolean isLive()
	{
		return live;
	}

	
	public void setLive(boolean live)
	{
		this.live = live;
	}
}
