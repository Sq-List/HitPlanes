package entity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import tools.Config;
import ui.GamePlay;

//�з�С�ɻ�����
public class SmallEnemyPlane extends EnemyPlane
{
	
	public SmallEnemyPlane(GamePlay gamePlay, int x, int y, int enemyType)
	{
		super(gamePlay, x, y, enemyType);
		this.setSpeed(Config.ENEMYPLANE_SMALL_SPEED);
	}
	
	//�½��߳�ʵ�ַɻ�������
	public void drawKilled(Graphics g)
	{
		new Thread(new DrawKilled(g)).start();
	}
	
	//ʵ��Runnable�ӿڵ���  ����drawKilledRun����
	private class DrawKilled implements Runnable
	{
		Graphics g;
		public DrawKilled(Graphics g)
		{
			this.g = g;
		}

		@Override
		public void run()
		{
			drawKilledRun(g);
		}
	}
	
	//��д���󷽷�
	private void drawKilledRun(Graphics g)
	{
		ImageIcon imageIcon = new ImageIcon(Config.ENEMYPLANE_SMALL_KILLED_IMAGE);
		this.setEnemyImageIcon(imageIcon);
		this.setWidth(imageIcon.getIconWidth());
		this.setHeight(imageIcon.getIconHeight());
		super.draw(g);
	}
}
