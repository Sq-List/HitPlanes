package entity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import tools.Config;
import ui.GamePlay;

//敌方大飞机的类
public class MaxEnemyPlane extends EnemyPlane
{
	
	public MaxEnemyPlane(GamePlay gamePlay, int x, int y, int enemyType)
	{
		super(gamePlay, x, y, enemyType);
		this.setSpeed(Config.ENEMYPLANE_MAX_SPEED);
	}

	//重写抽象方法 新建线程实现飞机的死亡 
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

		//调用drawKilledRun方法
		@Override
		public void run()
		{
			drawKilledRun(g);
		}
	}
	
	//画出大敌机死亡图片
	private void drawKilledRun(Graphics g)
	{
		ImageIcon imageIcon = new ImageIcon(Config.ENEMYPLANE_MAX_KILLED_IMAGE);
		this.setEnemyImageIcon(imageIcon);
		this.setWidth(imageIcon.getIconWidth());
		this.setHeight(imageIcon.getIconHeight());
		super.draw(g);
	}
}
