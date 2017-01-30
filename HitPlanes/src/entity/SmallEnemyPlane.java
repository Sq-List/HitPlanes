package entity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import tools.Config;
import ui.GamePlay;

//敌方小飞机的类
public class SmallEnemyPlane extends EnemyPlane
{
	
	public SmallEnemyPlane(GamePlay gamePlay, int x, int y, int enemyType)
	{
		super(gamePlay, x, y, enemyType);
		this.setSpeed(Config.ENEMYPLANE_SMALL_SPEED);
	}
	
	//新建线程实现飞机的死亡
	public void drawKilled(Graphics g)
	{
		new Thread(new DrawKilled(g)).start();
	}
	
	//实现Runnable接口的类  调用drawKilledRun方法
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
	
	//重写抽象方法
	private void drawKilledRun(Graphics g)
	{
		ImageIcon imageIcon = new ImageIcon(Config.ENEMYPLANE_SMALL_KILLED_IMAGE);
		this.setEnemyImageIcon(imageIcon);
		this.setWidth(imageIcon.getIconWidth());
		this.setHeight(imageIcon.getIconHeight());
		super.draw(g);
	}
}
