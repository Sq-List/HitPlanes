package tools;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.sound.midi.Instrument;
import javax.swing.ImageIcon;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Config
{
	//游戏的尺寸
	public final static int GAME_POS_X = 0;
	public final static int GAME_POS_Y = 0;
	public final static int GAME_WIDTH = 512;
	public final static int GAME_HEIGHT = 927;
	public final static int GAME_UP_HEIGHT = 35;	//窗口最上部分
	public final static int GAME_REPAINT_TIME = 50;
	
	//游戏中一些字体的设置
	public final static Font font = new Font("Dialog", Font.BOLD, 15);
	
	//游戏的图标
	public final static String ICON_IMAGE = "./image/Icon.png";
	
	//游戏的背景图和背景音乐
	public final static int GAME_PLAY_BACKGROUND_YSPEED = 5;
	public final static String START_BACKGROUND_IMAGE = "./image/Background/StartBackground.jpg";
	public final static String BACKGROUND_IMAGE = "./image/Background/Background.jpg";
	public final static String GAME_PLAY_BACKGROUND_IMAGE = "./image/Background/GamePlayBackground.png";
	public final static String GAME_OVER = "./image/Background/GameOver.png";
	public final static String BACKGROUND_MUSIC = "./music/game_music.wav";
	
	//按钮的尺寸、图片和音乐
	public final static int BUTTON_WIDTH = 132;
	public final static int BUTTON_HEIGHT = 71;
    public final static String BUTTON_NORMAL_IMAGE = "./image/Button/ButtonNormal.png";
    public final static String BUTTON_ONCLICK_IMAGE = "./image/Button/ButtonOnclick.png";
    public final static String BUTTON_HOVER_IMAGE = "./image/Button/ButtonHover.png";
    public final static String BUTTON_MUSIC = "./music/button.wav";
	
    //菜单画板的大小
	public final static int MENU_PANEL_WIDTH = 160;
	public final static int MENU_PANEL_HEIGHT = 248;
	
	//分数画板的大小
	public final static int SCORE_PANEL_WIDTH = 160;
    public final static int SCORE_PANEL_HEIGHT = 830;
    
    //加载游戏的图片
    public final static int GAME_LOADING_TIME = 800;
    public final static String COUNTDOWN_IAMGE_3 = "./image/3.png";
    public final static String COUNTDOWN_IAMGE_2 = "./image/2.png";
    public final static String COUNTDOWN_IAMGE_1 = "./image/1.png";
    public final static String COUNTDOWN_IAMGE_0 = "./image/0.png";
    
    //分数的图片
    public final static String NUM_0 = "./image/Prop/0.png";
    public final static String NUM_1 = "./image/Prop/1.png";
    public final static String NUM_2 = "./image/Prop/2.png";
    public final static String NUM_3 = "./image/Prop/3.png";
    public final static String NUM_4 = "./image/Prop/4.png";
    public final static String NUM_5 = "./image/Prop/5.png";
    public final static String NUM_6 = "./image/Prop/6.png";
    public final static String NUM_7 = "./image/Prop/7.png";
    public final static String NUM_8 = "./image/Prop/8.png";
    public final static String NUM_9 = "./image/Prop/9.png";
    
    //分数的起始位置
    public final static int SCORE_POSX = GAME_WIDTH - 50;
    public final static int SCORE_POSY = 10;
    
    //生命的起始位置
    public final static int BLOOD_POSX = 10;
    public final static int BLOOD_POSY = 40;

    //我方飞机的血量、尺寸、速度和图片
	public final static int MYPLANE_BLOOD = 3;
	public final static int MYPLANE_WIDTH = 33;
	public final static int MYPLANE_HEIGHT = 40;
	public final static int MYPLANE_YSPEED = 20;
	public final static int MYPLANE_XSPEED = 20;
	public final static String MYPLANE_SMALL_IMAGE = "./image/MyPlane/MySmallPlane.png";
	public final static String MYPLANE_MIDDLE_IMAGE = "./image/MyPlane/MyMiddlePlane.png";
	public final static String MYPLANE_MAX_IMAGE = "./image/MyPlane/MyMaxPlane.png";
	
	//我方子弹的伤害、移动速度和图片
	public final static int MYBULLET_SMALL = 0;
	public final static int MYBULLET_SMALL_KILL = 1;
	public final static int MYBULLET_SMALL_SPEED = 25;
	public final static String MYBULLET_SMALL_IMAGE = "./image/MyBullet/MySmallBullet.png";
	
	public final static int MYBULLET_MIDDLE = 1;
	public final static int MYBULLET_MIDDLE_KILL = 2;
	public final static int MYBULLET_MIDDLE_SPEED = 17;
	public final static int MYBULLET_MIDDLE_DURATION = 20000;
	public final static String MYBULLET_MIDDLE_IMAGE = "./image/MyBullet/MyMiddleBullet.png";
	
	public final static int MYBULLET_MAX = 2;
	public final static int MYBULLET_MAX_KILL = 3;
	public final static int MYBULLET_MAX_SPEED = 19;
	public final static int MYBULLET_MAX_DURATION = 10000;
	public final static String MYBULLET_MAX_IMAGE = "./image/MyBullet/MyMaxBullet.png";
	
	
	//敌方飞机的血量、移动速度、对应分数、出现的时间和图片
	public final static int ENEMYPLANE_SMALL = 0;
	public final static int ENEMYPLANE_SMALL_BLOOD = 3;
	public static int ENEMYPLANE_SMALL_SPEED = 8;
	public final static int ENEMYPLANE_SMALL_SPEED_START = 8;
	public final static int ENEMYPLANE_SMALL_SCORE = 500;
	public final static int ENEMYPLANE_SMALL_SHOW_TIME = 1000;
	public final static String ENEMYPLANE_SMALL_IMAGE = "./image/EnemyPlane/EnemySmallPlane.png";
	public final static String ENEMYPLANE_SMALL_KILLED_IMAGE = "./image/Boom/EnemySmallBoom.png";
	
	public final static int ENEMYPLANE_MIDDLE = 1;
	public final static int ENEMYPLANE_MIDDLE_BLOOD = 8;
	public static int ENEMYPLANE_MIDDLE_SPEED = 10;
	public final static int ENEMYPLANE_MIDDLE_SPEED_START = 10;
	public final static int ENEMYPLANE_MIDDLE_SCORE = 1000;
	public final static int ENEMYPLANE_MIDDLE_SHOW_TIME = 4000;
	public final static String ENEMYPLANE_MIDDLE_IMAGE = "./image/EnemyPlane/EnemyMiddlePlane.png";
	public final static String ENEMYPLANE_MIDDLE_KILLED_IMAGE = "./image/Boom/EnemyMiddleBoom.png";
	
	public final static int ENEMYPLANE_MAX = 2;
	public final static int ENEMYPLANE_MAX_BLOOD = 12;
	public static int ENEMYPLANE_MAX_SPEED = 15;
	public final static int ENEMYPLANE_MAX_SPEED_START = 15;
	public final static int ENEMYPLANE_MAX_SCORE = 2000;
	public final static int ENEMYPLANE_MAX_SHOW_TIME = 6000;
	public final static String ENEMYPLANE_MAX_IMAGE = "./image/EnemyPlane/EnemyMaxPlane.png";
	public final static String ENEMYPLANE_MAX_KILLED_IMAGE = "./image/Boom/EnemyMaxBoom.png";
	
	//敌方子弹的伤害、速度和图片
	public final static int ENEMYBULLET_SMALL = 0;
	public final static int ENEMYBULLET_SMALL_KILL = 1;
	public final static int ENEMYBULLET_SMALL_SPEED = 13;
	public final static String ENEMYBULLET_SMALL_IMAGE = "./image/EnemyBullet/EnemySmallBullet.png";
	
	public final static int ENEMYBULLET_MIDDLE = 1;
	public final static int ENEMYBULLET_MIDDLE_KILL = 2;
	public final static int ENEMYBULLET_MIDDLE_SPEED = 16;
	public final static String ENEMYBULLET_MIDDLE_IMGAE = "./image/EnemyBullet/EnemyMiddleBullet.png";
	
	public final static int ENEMYBULLET_MAX = 2;
	public final static int ENEMYBULLET_MAX_KILL = 3;
	public final static int ENEMYBULLET_MAX_SPEED = 21;
	public final static String ENEMYBULLET_MAX_IMGAE = "./image/EnemyBullet/EnemyMaxBullet.png";
	
	//加速时间
	public final static int SPEED_UP_TIME = 100000;
	
	//道具的移动速度和图片
	public final static int PROP_XSPEED = 3;
	public final static int PROP_YSPEED = 5;
	public final static String PROP_IMAGE = "./image/Prop/Prop.png";
}
