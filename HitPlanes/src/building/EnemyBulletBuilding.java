package building;

import javax.swing.ImageIcon;

import entity.EnemyBullet;
import tools.Config;
import ui.GamePlay;

public class EnemyBulletBuilding
{
	public static EnemyBullet createEnemyBullet(GamePlay gamePlay, int x, int y, int enemyType)
	{
		EnemyBullet enemyBullet = null;
		ImageIcon imageIcon;
		switch (enemyType) {
			case Config.ENEMYPLANE_MAX:
				//创建对象
				enemyBullet = new EnemyBullet(gamePlay, x, y, Config.ENEMYBULLET_MAX_SPEED, enemyType);
				//获取图片
				imageIcon = new ImageIcon(Config.ENEMYBULLET_MAX_IMGAE);
				//给创建的对象设置图片
				enemyBullet.setBulletImage(imageIcon);
				break;
			
			case Config.ENEMYPLANE_MIDDLE:
				enemyBullet = new EnemyBullet(gamePlay, x, y, Config.ENEMYBULLET_MIDDLE_SPEED, enemyType);
				imageIcon = new ImageIcon(Config.ENEMYBULLET_MIDDLE_IMGAE);
				enemyBullet.setBulletImage(imageIcon);
				break;
			
			case Config.ENEMYPLANE_SMALL:
				enemyBullet = new EnemyBullet(gamePlay, x, y, Config.ENEMYBULLET_SMALL_SPEED, enemyType);
				imageIcon = new ImageIcon(Config.ENEMYBULLET_SMALL_IMAGE);
				enemyBullet.setBulletImage(imageIcon);
				break;
		}
		return enemyBullet;
	}
}
