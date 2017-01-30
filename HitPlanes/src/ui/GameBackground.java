package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import tools.Config;

public class GameBackground extends JPanel
{
	private Image backgroundImage;
	
	public GameBackground(Image background)
	{
		this.backgroundImage = background;
	}
	
	//»­³ö±³¾°Í¼Æ¬
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(backgroundImage, Config.GAME_POS_X, Config.GAME_POS_Y, Config.GAME_WIDTH, Config.GAME_HEIGHT, this);
	}
}
