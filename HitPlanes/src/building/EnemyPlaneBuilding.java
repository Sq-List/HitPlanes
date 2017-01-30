package building;

import java.util.Random;

import javax.swing.ImageIcon;

import entity.EnemyPlane;
import entity.MaxEnemyPlane;
import entity.MiddleEnemyPlane;
import entity.SmallEnemyPlane;
import tools.Config;
import ui.GamePlay;

public class EnemyPlaneBuilding
{
	//用当前的时间作为随机种子生成随机数作为x的坐标
	public static final Random rand = new Random(System.currentTimeMillis());
	
	//生成敌方飞机
	public static final EnemyPlane createEnemyPlane(GamePlay gamePlay, int enemyPlaneType)
	{
		EnemyPlane enemyPlane = null;
		ImageIcon imageIcon;
		switch (enemyPlaneType) {
			case Config.ENEMYPLANE_MAX:
				//创建对象
				enemyPlane = new MaxEnemyPlane(gamePlay, 0, 0, enemyPlaneType);
				//加载敌方飞机图片
				imageIcon = new ImageIcon(Config.ENEMYPLANE_MAX_IMAGE);
				enemyPlane.setHeight(imageIcon.getIconHeight());
				enemyPlane.setWidth(imageIcon.getIconWidth());
				//设置血量
				enemyPlane.setBlood(Config.ENEMYPLANE_MAX_BLOOD);
				//设置图片
				enemyPlane.setEnemyImageIcon(imageIcon);
				enemyPlane.setScore(Config.ENEMYPLANE_MAX_SCORE);
				break;
				
			case Config.ENEMYPLANE_MIDDLE:
				enemyPlane = new MiddleEnemyPlane(gamePlay, 0, 0, enemyPlaneType);
				imageIcon = new ImageIcon(Config.ENEMYPLANE_MIDDLE_IMAGE);
				enemyPlane.setHeight(imageIcon.getIconHeight());
				enemyPlane.setWidth(imageIcon.getIconWidth());
				enemyPlane.setBlood(Config.ENEMYPLANE_MIDDLE_BLOOD);
				enemyPlane.setEnemyImageIcon(imageIcon);
				enemyPlane.setScore(Config.ENEMYPLANE_MIDDLE_SCORE);
				break;
				
			case Config.ENEMYPLANE_SMALL:
				enemyPlane = new SmallEnemyPlane(gamePlay, 0, 0, enemyPlaneType);
				imageIcon = new ImageIcon(Config.ENEMYPLANE_SMALL_IMAGE);
				enemyPlane.setHeight(imageIcon.getIconHeight());
				enemyPlane.setWidth(imageIcon.getIconWidth());
				enemyPlane.setBlood(Config.ENEMYPLANE_SMALL_BLOOD);
				enemyPlane.setEnemyImageIcon(imageIcon);
				enemyPlane.setScore(Config.ENEMYPLANE_SMALL_SCORE);
				break;
		}
		int x = rand.nextInt(gamePlay.getWidth() - enemyPlane.getHeight());
		enemyPlane.setX(x);
		return enemyPlane;
	}
}
