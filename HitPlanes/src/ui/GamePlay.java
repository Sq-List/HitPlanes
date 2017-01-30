package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import building.EnemyBulletBuilding;
import building.EnemyPlaneBuilding;
import building.MyBulletBuilding;
import entity.EnemyBullet;
import entity.EnemyPlane;
import entity.MyBullet;
import entity.MyPlane;
import entity.Prop;
import main.Main;
import tools.Config;
import tools.Player;

public class GamePlay extends JPanel implements KeyListener
{
	private Random random = new Random(System.currentTimeMillis());
	private MyPlane myPlane;
	private int smallEnemyPlaneShowTime;
	private int middleEnemyPlaneShowTime;
	private int maxEnemyPlaneShowTime;
	private int myBulletDuration;
	private int score;
	private int level;
	private Player backgoroundMusic;
	private GamePlayBackground gamePlayBackground;
	//volatile������������α���ͬ�̷߳��ʺ��޸ĵı���
	//�з��ӵ�������
	private volatile List<EnemyBullet> enemyBullets;
	//�з��ɻ�������
	private volatile List<EnemyPlane> enemyPlanes;
	//�ҷ��ӵ�������
	private volatile List<MyBullet> myBullets;
	//��������
	private volatile List<Prop> props;
	//��������
	private volatile List<Integer> scoreList;
	
	public GamePlay() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		init();
		initMusic();
	}

	private void initMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		backgoroundMusic = new Player(Config.BACKGROUND_MUSIC);
	}

	private void init()
	{
		this.addKeyListener(this);
		this.setSize(Config.GAME_WIDTH, Config.GAME_HEIGHT);
		this.setOpaque(false);
	}
	
	public void startGame()
	{
		smallEnemyPlaneShowTime = Config.ENEMYPLANE_SMALL_SHOW_TIME;
		middleEnemyPlaneShowTime = Config.ENEMYPLANE_MIDDLE_SHOW_TIME;
		maxEnemyPlaneShowTime = Config.ENEMYPLANE_MAX_SHOW_TIME;
		Config.ENEMYPLANE_SMALL_SPEED = Config.ENEMYPLANE_SMALL_SPEED_START;
		Config.ENEMYPLANE_MIDDLE_SPEED = Config.ENEMYPLANE_MIDDLE_SPEED_START;
		Config.ENEMYPLANE_MAX_SPEED = Config.ENEMYPLANE_MAX_SPEED_START;
		myBulletDuration = -1;
		ImageIcon imageIcon = new ImageIcon(Config.MYPLANE_SMALL_IMAGE);
		myPlane = new MyPlane(this, (Config.GAME_WIDTH - imageIcon.getIconWidth()) / 2, Config.GAME_HEIGHT - imageIcon.getIconHeight() - Config.GAME_UP_HEIGHT);
		gamePlayBackground = new GamePlayBackground(this, new ImageIcon(Config.GAME_PLAY_BACKGROUND_IMAGE));
		enemyPlanes = new ArrayList<EnemyPlane>();
		enemyBullets = new ArrayList<EnemyBullet>();
		myBullets = new ArrayList<MyBullet>();
		props = new ArrayList<Prop>();
		score = 0;
		level = 1;
		backgoroundMusic.loop();
		new Thread(new PaintThead()).start();
	}
	
	private void drawStr(Graphics g)
	{
		String string = "����ֵ��" + myPlane.getBlood();
		g.setFont(new Font("΢���ź�", Font.BOLD, 30));
		g.setColor(Color.BLUE);
		g.drawString(string, Config.BLOOD_POSX, Config.BLOOD_POSY);
	}
	
	private void drawScore(Graphics g, int posx, int posy)
	{
		Graphics2D g2d = (Graphics2D)g;
		scoreList = new ArrayList<Integer>();
		int temp = score;
		
		//Ϊ��ʹ�տ�ʼ��0Ҳ���뵽������
		while ((temp / 10) != 0)
		{
			scoreList.add(temp % 10);
			temp /= 10;
		}
		scoreList.add(temp % 10);
		
		//���÷�������ʵλ��
		int posX = posx;
		int posY = posy;
		
		//������
		ImageIcon imageIcon;
		for (int i = 0; i < scoreList.size(); i++)
		{
			switch (scoreList.get(i)) {
				case 0:
					imageIcon = new ImageIcon(Config.NUM_0);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 1:
					imageIcon = new ImageIcon(Config.NUM_1);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 2:
					imageIcon = new ImageIcon(Config.NUM_2);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 3:
					imageIcon = new ImageIcon(Config.NUM_3);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 4:
					imageIcon = new ImageIcon(Config.NUM_4);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 5:
					imageIcon = new ImageIcon(Config.NUM_5);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 6:
					imageIcon = new ImageIcon(Config.NUM_6);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 7:
					imageIcon = new ImageIcon(Config.NUM_7);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 8:
					imageIcon = new ImageIcon(Config.NUM_8);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
					
				case 9:
					imageIcon = new ImageIcon(Config.NUM_9);
					g2d.drawImage(imageIcon.getImage(), posX, posY, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, GamePlay.this);
					posX -= imageIcon.getIconWidth() / 2;
					break;
			}
		}
	}
	
	private void stopGame()
	{
		backgoroundMusic.stop();
	}
	
	private class PaintThead implements Runnable
	{

		@Override
		public void run()
		{
			while (myPlane.isLive())
			{
				for (int i = 0; i < props.size(); i++)
				{
					Prop prop = props.get(i);
					if (!prop.isLive())
					{
						synchronized (props)
						{
							props.remove(i);
						}
					}
					else
					{
						propsAndMyPlane(i);
					}
				}
				
				//�Եз����ӵ����м��
				for (int i = 0; i < enemyBullets.size(); i++)
				{
					EnemyBullet enemyBullet = enemyBullets.get(i);
					if (!enemyBullet.isLive())
					{
						synchronized (enemyBullets)
						{
							enemyBullets.remove(i);
						}
					}
					else
					{
						enemyBulletsAndMyPlane(i);
						enemyBulletsAndMyBullets(i);
					}
				}
				
				//���ҷ����ӵ����м��
				for (int i = 0; i < myBullets.size(); i++)
				{
					MyBullet myBullet = myBullets.get(i);
					if (!myBullet.isLive())
					{
						synchronized (myBullets)
						{
							myBullets.remove(i);
						}
					}
				}
				
				//�Եз��ķɻ����м��
				for (int i = 0; i < enemyPlanes.size(); i++)
				{
					EnemyPlane enemyPlane = enemyPlanes.get(i);
					if (!enemyPlane.isLive())
					{
						synchronized (enemyPlanes)
						{
							enemyPlanes.remove(i);
						}
					}
					else
					{
						enemyPlaneAndMyBullets(i);
						enemyPlaneAndMyPlane(i);
						
						Random random = new Random();
						//100���ڵ����������90  ����  �з��ɻ������������ҷ��ɻ�  ���õз��ɻ����ÿ�ǹ
						if (random.nextInt(100) > 80 && enemyPlane.isLive() && (enemyPlane.getX() < myPlane.getX() + (myPlane.getWidth() / 2)) && (enemyPlane.getX() > myPlane.getX() - (myPlane.getWidth() / 2)))
						{
							enemyPlane.setFire(true);
						}
						
						//�з��ɻ���ǹ���Ҵ��  ����ӵ�
						if (enemyPlane.isFire() && enemyPlane.isLive())
						{
							EnemyBullet enemyBullet = EnemyBulletBuilding.createEnemyBullet(GamePlay.this, enemyPlane.getX(), enemyPlane.getY(), enemyPlane.getEnemyType());
							synchronized (enemyBullets)
							{
								enemyBullets.add(enemyBullet);
							}
							enemyPlane.setFire(false);
						}
					}
				}
				
				//�ж��ҷ��ɻ��Ƿ�ǹ
				if (myPlane.getFire())
				{
					MyBullet myBullet = new MyBulletBuilding().createMyBullet(GamePlay.this, myPlane.getX(), myPlane.getY(), myPlane.getMyBulletType());
					synchronized (myBullets)
					{
						myBullets.add(myBullet);
					}
				}
				
				//�з��ɻ�����
				if (level < score / 10000)
				{
					level = score / 10000;
					Config.ENEMYPLANE_SMALL_SPEED = Config.ENEMYPLANE_SMALL_SPEED_START + level * 5;
					Config.ENEMYPLANE_MIDDLE_SPEED = Config.ENEMYPLANE_MIDDLE_SPEED_START + level * 5;
					Config.ENEMYPLANE_MAX_SPEED = Config.ENEMYPLANE_MAX_SPEED_START + level * 5;
				}
				
				//1000���ڵ����������998 ���� ���ߵĸ���������2  ���ɵ���
				if (random.nextInt(1000) > 995 && props.size() <= 2)
				{
					int x = random.nextInt(Config.GAME_WIDTH);
					Prop prop = new Prop(GamePlay.this, x, 0);
					synchronized (GamePlay.this.props)
					{
						props.add(prop);
					}
				}
				
				if (myBulletDuration != -1)
				{
					myBulletDuration -= Config.GAME_REPAINT_TIME;
					if (myBulletDuration == 0)
					{
						myPlane.setMyPlaneImage(new ImageIcon(Config.MYPLANE_SMALL_IMAGE));
						myPlane.setMyBulletType(Config.MYBULLET_SMALL);
						myBulletDuration = -1;
					}
				}
				
				//��һ��ʱ�����EnemySmallPlane
				if (smallEnemyPlaneShowTime > 0)
				{
					smallEnemyPlaneShowTime -= Config.GAME_REPAINT_TIME;
				}
				else
				{
					EnemyPlane smallPlane = new EnemyPlaneBuilding().createEnemyPlane(GamePlay.this, Config.ENEMYPLANE_SMALL);
					synchronized (enemyPlanes)
					{
						enemyPlanes.add(smallPlane);
					}
					
					smallEnemyPlaneShowTime = Config.ENEMYPLANE_SMALL_SHOW_TIME;
				}
				
				//��һ��ʱ�����EnemyMiddlePlane
				if (middleEnemyPlaneShowTime > 0)
				{
					middleEnemyPlaneShowTime -= Config.GAME_REPAINT_TIME;
				}
				else
				{
					EnemyPlane middlePlane = new EnemyPlaneBuilding().createEnemyPlane(GamePlay.this, Config.ENEMYPLANE_MIDDLE);
					synchronized (enemyPlanes)
					{
						enemyPlanes.add(middlePlane);
					}
					
					middleEnemyPlaneShowTime = Config.ENEMYPLANE_MIDDLE_SHOW_TIME;
				}
				
				//��һ��ʱ�����EnemyMaxPlane
				if (maxEnemyPlaneShowTime > 0)
				{
					maxEnemyPlaneShowTime -= Config.GAME_REPAINT_TIME;
				}
				else
				{
					EnemyPlane maxPlane = new EnemyPlaneBuilding().createEnemyPlane(GamePlay.this, Config.ENEMYPLANE_MAX);
					synchronized (enemyPlanes)
					{
						enemyPlanes.add(maxPlane);
					}
					
					maxEnemyPlaneShowTime = Config.ENEMYPLANE_MAX_SHOW_TIME;
				}
				
				GamePlay.this.repaint();
				
				try
				{
					Thread.sleep(Config.GAME_REPAINT_TIME);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		//���������ҷ��ɻ�����ײ
		public void propsAndMyPlane(int i)
		{
			Prop prop = props.get(i);
			if (prop.getRctangle().intersects(myPlane.getRectangle()))
			{
				prop.setLive(false);
				
				if (myPlane.getMyBulletType() < 2)
				{
					myPlane.setMyBulletType(myPlane.getMyBulletType() + 1);
					if (myPlane.getMyBulletType() == Config.MYBULLET_MIDDLE)
					{
						myPlane.setMyPlaneImage(new ImageIcon(Config.MYPLANE_MIDDLE_IMAGE));
						myBulletDuration = Config.MYBULLET_MIDDLE_DURATION;
					}
					else if (myPlane.getMyBulletType() == Config.MYBULLET_MAX)
					{
						myPlane.setMyPlaneImage(new ImageIcon(Config.MYPLANE_MAX_IMAGE));
						myBulletDuration = Config.MYBULLET_MAX_DURATION;
					}
				}
			}
		}
		
		//���з��ӵ����ҷ��ɻ�����ײ
		public void enemyBulletsAndMyPlane(int i)
		{
			if (i < enemyBullets.size())
			{
				EnemyBullet enemyBullet = enemyBullets.get(i);
				if (enemyBullet.getRectangle().intersects(myPlane.getRectangle()))
				{
					enemyBullet.setLive(false);
					synchronized (enemyBullets)
					{
						enemyBullets.remove(i);
					}
					
					int blood = myPlane.getBlood();
					myPlane.setBlood(blood - 1);
					synchronized (myPlane)
					{
						if (!myPlane.isLive())
						{
							GamePlay.this.stopGame();
						}
					}
				}
			}
		}
		
		//���з��ӵ����ҷ��ӵ�����ײ
		public void enemyBulletsAndMyBullets(int i)
		{
			if (i < enemyBullets.size())
			{
				EnemyBullet enemyBullet = enemyBullets.get(i);
				if (enemyBullet.getEnemyType() <= myPlane.getMyBulletType())
				{
					for (int j = 0; j < myBullets.size(); j++)
					{
						MyBullet myBullet = myBullets.get(j);
						if (enemyBullet.getRectangle().intersects(myBullet.getRectangle()))
						{
							enemyBullet.setLive(false);

							myBullet.setLive(false);
						}
					}
				}
			}
		}
		
		//���з��ɻ����ҷ��ɻ�����ײ
		public void enemyPlaneAndMyPlane(int i)
		{
			if (i < enemyPlanes.size())
			{
				EnemyPlane enemyPlane = enemyPlanes.get(i);
				if (enemyPlane.getRectangle().intersects(myPlane.getRectangle()))
				{
					myPlane.setBlood(0);
					myPlane.setLive(false);
					synchronized (myPlane)
					{
						if (!myPlane.isLive())
						{
							GamePlay.this.stopGame();
						}
					}
				}
			}
		}
		
		//���з��ɻ����ҷ��ӵ�����ײ
		public void enemyPlaneAndMyBullets(int i)
		{
			if (i < enemyPlanes.size())
			{
				EnemyPlane enemyPlane = enemyPlanes.get(i);
				
				for (int j = 0; j < myBullets.size(); j++)
				{
					MyBullet myBullet = myBullets.get(j);
					if (myBullet.getRectangle().intersects(enemyPlane.getRectangle()))
					{
						myBullet.setLive(false);
						
						enemyPlane.setBlood(enemyPlane.getBlood() - 1);
						if (!enemyPlane.isLive())
						{
							score += enemyPlane.getScore();
//							enemyPlane.setEnemyImageIcon(new ImageIcon(Config.ENEMYPLANE_SMALL_KILLED_IMAGE));
							enemyPlane.drawKilled(GamePlay.this.getComponentGraphics(getGraphics()));
						}
					}
				}
			}
		}
		
	}
	
	//����
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (myPlane.isLive())
		{
			//�������ı���
			gamePlayBackground.draw(g);

			//���ҷ��ɻ�
			myPlane.draw(g);
			
			//���з��ɻ�
			for (int i = 0; i < enemyPlanes.size(); i++)
			{
				EnemyPlane enemyPlane = enemyPlanes.get(i);
				enemyPlane.draw(g);
			}
			
			//���з��ӵ�
			for (int i = 0; i < enemyBullets.size(); i++)
			{
				EnemyBullet enemyBullet = enemyBullets.get(i);
				enemyBullet.draw(g);
			}
			
			//���ҷ��ӵ�
			for (int i = 0; i < myBullets.size(); i++)
			{
				MyBullet myBullet = myBullets.get(i);
				myBullet.draw(g);
			}
			
			//������
			for (int i = 0; i < props.size(); i++)
			{
				Prop prop = props.get(i);
				prop.draw(g);
			}
			
			//������
			drawScore(g, Config.SCORE_POSX, Config.SCORE_POSY);
			
			//������ֵ
			drawStr(g);
		}
		else
		{
			//����GAME OVER��ͼƬ
			ImageIcon imageIcon = new ImageIcon(Config.GAME_OVER);
			g.drawImage(imageIcon.getImage(), Config.GAME_WIDTH / 2 - imageIcon.getIconWidth() / 4, Config.GAME_HEIGHT / 2 - 100, imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, this);
			//��������
			drawScore(g, Config.GAME_WIDTH / 2 + 13 * scoreList.size(), Config.GAME_HEIGHT / 2);
		}
	}
	
	
	public int getScore()
	{
		return score;
	}

	public List<Integer> getScoreList()
	{
		return scoreList;
	}

	public MyPlane getMyPlane()
	{
		return myPlane;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		myPlane.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		myPlane.keyReleased(e);
	}

}
