package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import tools.Config;
import ui.GamePlay;

//�з��ɻ��ĸ���ĳ���
public abstract class EnemyPlane
{
	private int x;
	private int y;
	public int speed;
	//����ɱ��õ��ķ���
	private int score;
	private boolean live;
	//�Ƿ�ǹ
	private boolean fire;
	private int blood;
	//�з��ɻ�����
	private int enemyType;
	
	private int width;
	private int height;
	private int tempx;
	private int tempy;
	//�з��ɻ���ͼƬ
	private ImageIcon enemyImageIcon;
	private GamePlay gamePlay;
	
	public EnemyPlane(GamePlay gamePlay, int x, int y, int enemyType)
	{
		this.gamePlay = gamePlay;
		this.enemyType = enemyType;
		this.x = x;
		this.y = y;
		this.live = true;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	//�����з��ɻ�
	public void draw(Graphics g)
	{
		if (live)
		{
			g.drawImage(enemyImageIcon.getImage(), x, y, width, height, gamePlay);
		}
		move();
	}
	
	//�ƶ�
	private void move()
	{
		y += speed;
		//����з��ɻ��ɳ�����  �򽫷ɻ�����Ϊ����
		if (y > Config.GAME_HEIGHT + height)
		{
			live = false;
		}
	}
	
	//���󷽷�  ÿ�ֵз��ɻ��������ֵ�ͼƬ��ͬ
	public abstract void drawKilled(Graphics g);
	
	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}
	
	public int getX()
	{
		return x + tempx;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y + height;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}

	public boolean isLive()
	{
		return blood > 0;
	}
	
	public void setLive(boolean live)
	{
		this.live = live;
	}

	public boolean isFire()
	{
		return fire;
	}
	
	public void setFire(boolean fire)
	{
		this.fire = fire;
	}
	
	public int getBlood()
	{
		return blood;
	}
	
	public void setBlood(int blood)
	{
		this.blood = blood;
	}

	public int getEnemyType()
	{
		return enemyType;
	}
	
	public void setEnemyType(int enemyType)
	{
		this.enemyType = enemyType;
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
	
	public void setEnemyImageIcon(ImageIcon enemyImageIcon)
	{
		this.enemyImageIcon = enemyImageIcon;
		this.width = enemyImageIcon.getIconWidth();
		this.height = enemyImageIcon.getIconHeight();
		this.tempx = width / 3;
		this.tempy = height / 2;
	}
}
