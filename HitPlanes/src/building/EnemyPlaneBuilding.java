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
	//�õ�ǰ��ʱ����Ϊ������������������Ϊx������
	public static final Random rand = new Random(System.currentTimeMillis());
	
	//���ɵз��ɻ�
	public static final EnemyPlane createEnemyPlane(GamePlay gamePlay, int enemyPlaneType)
	{
		EnemyPlane enemyPlane = null;
		ImageIcon imageIcon;
		switch (enemyPlaneType) {
			case Config.ENEMYPLANE_MAX:
				//��������
				enemyPlane = new MaxEnemyPlane(gamePlay, 0, 0, enemyPlaneType);
				//���صз��ɻ�ͼƬ
				imageIcon = new ImageIcon(Config.ENEMYPLANE_MAX_IMAGE);
				enemyPlane.setHeight(imageIcon.getIconHeight());
				enemyPlane.setWidth(imageIcon.getIconWidth());
				//����Ѫ��
				enemyPlane.setBlood(Config.ENEMYPLANE_MAX_BLOOD);
				//����ͼƬ
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
