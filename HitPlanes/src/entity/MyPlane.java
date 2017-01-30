package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import ui.MainFrame;
import tools.Config;
import ui.GamePlay;

//�ҷ��ɻ�����
public class MyPlane
{
	//�ɻ�������
	private int x;
	private int y;
	
	//�ɻ��Ĵ�С
	private int width;
	private int height;
	private int temp;
	
	//�ɻ�������
	private int blood;
	
	//�ж��ĸ�����
	private boolean toUp;
	private boolean toDown;
	private boolean toRight;
	private boolean toLeft;
	
	//�жϷɻ��Ƿ���
	private boolean live;
	//�жϷɻ��Ƿ񿪻�
	private boolean fire;
	//�ӵ�������
	private int myBulletType;
	
	//�ҷ��ɻ���ͼƬ
	private ImageIcon myPlaneImage;
	private GamePlay gamePlay;
	
	
	public MyPlane(GamePlay gamePlay, int x, int y)
	{
		this.gamePlay = gamePlay;
		this.myPlaneImage = new ImageIcon(Config.MYPLANE_SMALL_IMAGE);
		this.live = true;
		this.x = x;
		this.y = y;
		this.blood = Config.MYPLANE_BLOOD;
		this.width = myPlaneImage.getIconWidth();
		this.height = myPlaneImage.getIconHeight();
		this.temp = height / 2;
		this.myBulletType = Config.MYBULLET_SMALL;
	}
	
	//�����ɻ�
	public void draw(Graphics g)
	{
		if (!live)
		{
			return ;
		}
		else
		{
			g.drawImage(myPlaneImage.getImage(), x, y, width, height, gamePlay);
		}
		move();
	}
	
	//�԰����Ĵ���
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		switch(key){
		case 'w':
		case 'W':
		case KeyEvent.VK_UP:
			toUp = true;
			break;
			
		case 's':
		case 'S':
		case KeyEvent.VK_DOWN:
			toDown = true;
			break;
			
		case 'a':
		case 'A':
		case KeyEvent.VK_LEFT:
			toLeft = true;
			break;
			
		case 'd':
		case 'D':
		case KeyEvent.VK_RIGHT:
			toRight = true;
			break;
			
		case KeyEvent.VK_SPACE:
			fire = true;
			break;
		}
	}
	
	//�԰����Ĵ���
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		switch(key){
		case 'w':
		case 'W':
		case KeyEvent.VK_UP:
			toUp = false;
			break;
			
		case 's':
		case 'S':
		case KeyEvent.VK_DOWN:
			toDown = false;
			break;
			
		case 'a':
		case 'A':
		case KeyEvent.VK_LEFT:
			toLeft = false;
			break;
			
		case 'd':
		case 'D':
		case KeyEvent.VK_RIGHT:
			toRight = false;
			
		case KeyEvent.VK_SPACE:
			fire = false;
			break;
		}
	}
	
	//�ɻ��ƶ�
	public void move()
	{
		if (toUp && !toDown && !toLeft && !toRight)
		{
			y -= Config.MYPLANE_YSPEED;
		}
		else if (!toUp && toDown && !toLeft && !toRight)
		{
			y += Config.MYPLANE_YSPEED;
		}
		else if (!toUp && !toDown && toLeft && !toRight)
		{
			x -= Config.MYPLANE_XSPEED;
		}
		else if (!toUp && !toDown && !toLeft && toRight)
		{
			x += Config.MYPLANE_YSPEED;
		}
		else if(toUp && !toDown && !toLeft && toRight)
		{
			y -= Config.MYPLANE_YSPEED;
			x += Config.MYPLANE_XSPEED;
		}
		else if(toUp && !toDown && toLeft && !toRight)
		{
			x -= Config.MYPLANE_XSPEED;
			y -= Config.MYPLANE_YSPEED;
		}
		else if (!toUp && toDown && toLeft && !toRight)
		{
			y += Config.MYPLANE_YSPEED;
			x -= Config.MYPLANE_XSPEED;
		}
		else if(!toUp && toDown && !toLeft && toRight)
		{
			y += Config.MYPLANE_YSPEED;
			x += Config.MYPLANE_XSPEED;
		}
		
		if (x + Config.MYPLANE_WIDTH > Config.GAME_WIDTH)
		{
			x = Config.GAME_WIDTH - Config.MYPLANE_WIDTH;
		}
		
		if (x < 0)
		{
			x = 0;
		}
		
		if (y + Config.MYPLANE_HEIGHT / 2 > Config.GAME_HEIGHT)
		{
			y = Config.GAME_HEIGHT - Config.MYPLANE_HEIGHT / 2;
		}
		
		if (y < Config.GAME_UP_HEIGHT)
		{
			y = Config.GAME_UP_HEIGHT;
		}
	}
	
	//����ͼƬ
	public void setMyPlaneImage(ImageIcon myPlaneImage)
	{
		this.myPlaneImage = myPlaneImage;
		this.width = myPlaneImage.getIconWidth();
		this.height = myPlaneImage.getIconHeight();
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle(x + temp, y, Config.MYPLANE_WIDTH, Config.MYPLANE_HEIGHT);
	}
	
	public int getBlood()
	{
		return blood;
	}
	
	public void setBlood(int blood)
	{
		this.blood = blood;
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

	public int getMyBulletType()
	{
		return myBulletType;
	}
	
	public void setMyBulletType(int myBulletType)
	{
		if (myBulletType >= 3)
		{
			myBulletType = 2;
		}
		this.myBulletType = myBulletType;
	}

	public int getX()
	{
		return x + temp;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean isLive()
	{
		return blood > 0;
	}
	
	public void setLive(boolean live)
	{
		this.live = live;
	}
	
	public boolean getFire()
	{
		return fire;
	}
	
	public void setFire(boolean fire)
	{
		this.fire = fire;
	}
}
