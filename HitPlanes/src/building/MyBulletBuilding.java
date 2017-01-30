package building;

import javax.swing.ImageIcon;

import entity.EnemyBullet;
import entity.MyBullet;
import tools.Config;
import ui.GamePlay;

public class MyBulletBuilding
{
	public MyBullet createMyBullet(GamePlay gamePlay, int x, int y, int BulletType)
	{
		MyBullet myBullet = null;
		ImageIcon imageIcon = null;
		switch (BulletType) {
			case Config.MYBULLET_MAX:
				myBullet = new MyBullet(gamePlay, x, y, Config.MYBULLET_MAX_SPEED, Config.MYBULLET_MAX_KILL);
				imageIcon = new ImageIcon(Config.MYBULLET_MAX_IMAGE);
				myBullet.setBulletImageIcon(imageIcon);
				break;
				
			case Config.MYBULLET_MIDDLE:
				myBullet = new MyBullet(gamePlay, x, y, Config.MYBULLET_MIDDLE_SPEED, Config.MYBULLET_MIDDLE_KILL);
				imageIcon = new ImageIcon(Config.MYBULLET_MIDDLE_IMAGE);
				myBullet.setBulletImageIcon(imageIcon);
				break;
				
			case Config.MYBULLET_SMALL:
				myBullet = new MyBullet(gamePlay, x, y, Config.MYBULLET_SMALL_SPEED, Config.MYBULLET_SMALL_KILL);
				imageIcon = new ImageIcon(Config.MYBULLET_SMALL_IMAGE);
				myBullet.setBulletImageIcon(imageIcon);
				break;
		}
		return myBullet;
	}
}
