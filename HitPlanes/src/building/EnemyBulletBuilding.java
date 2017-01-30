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
				//��������
				enemyBullet = new EnemyBullet(gamePlay, x, y, Config.ENEMYBULLET_MAX_SPEED, enemyType);
				//��ȡͼƬ
				imageIcon = new ImageIcon(Config.ENEMYBULLET_MAX_IMGAE);
				//�������Ķ�������ͼƬ
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
