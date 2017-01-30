package ui;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import tools.Config;
import tools.Player;

public class GameButton extends JButton implements MouseListener
{
	private final String BUTTON_NORMAL = "BUTTON_NORMAL";
	private final String BUTTON_ONCLICK = "BUTTON_ONCLICK";
	private final String BUTTON_HOVER = "BUTTON_HOVER";
	private String str;
	private String buttonStatus;
	private Player buttonPlayer;
	
	
	public GameButton()
	{
		super();
		this.str = "";
		initButton();
	}
	
	public GameButton(String str)
	{
		super();
		this.str = str;
		initButton();
	}
	
	public void setStr(String str)
	{
		this.str = str;
	}
	
	private void initButton()
	{
		this.buttonStatus = BUTTON_NORMAL;
		//���ر߿�
		this.setBorderPainted(false);
		//��ť͸����
		this.setContentAreaFilled(false);
		//��ť��Ӽ���
		this.addMouseListener(this);
		//��ť��������
		try
		{
			this.buttonPlayer = new Player(Config.BUTTON_MUSIC);
		}
		catch (UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		Image buttonBackgroundImage = null;
		if (this.buttonStatus.equals(BUTTON_NORMAL))
		{
			buttonBackgroundImage = new ImageIcon(Config.BUTTON_NORMAL_IMAGE).getImage();
		}
		else if (this.buttonStatus.equals(BUTTON_ONCLICK))
		{
			buttonBackgroundImage = new ImageIcon(Config.BUTTON_ONCLICK_IMAGE).getImage();
		}
		else if (this.buttonStatus.equals(BUTTON_HOVER))
		{
			buttonBackgroundImage = new ImageIcon(Config.BUTTON_HOVER_IMAGE).getImage();
		}
		int buttonWidth = buttonBackgroundImage.getWidth(this);
		int buttonHeight = buttonBackgroundImage.getHeight(this);
		
		this.setSize(buttonWidth, buttonHeight);
		this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		
		//����ͼƬ���ư�ť
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(buttonBackgroundImage, 0, 0, buttonWidth, buttonHeight, this);
		
		//����FontMetricsʹ������� �� ��������
		//��ȡ��ǰ��������
		g.setFont(Config.font);
		FontMetrics metric = g.getFontMetrics();
		//����ָ�� Graphics ��������ָ�� String �ı߽�
		Rectangle2D rect = metric.getStringBounds(str, g);
		g2d.drawString(str, (float) (buttonWidth / 2 - rect.getWidth() / 2), (float) ((buttonHeight / 2) + ((metric.getAscent() + metric.getDescent()) / 2 - metric.getDescent())));
	}
	
	private void buttonClicked()
	{
		this.buttonStatus = BUTTON_ONCLICK;
	}
	
	private void buttonNormal()
	{
		this.buttonStatus = BUTTON_NORMAL;
	}
	
	private void buttonHover()
	{
		this.buttonStatus = BUTTON_HOVER;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		buttonClicked();
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		buttonClicked();
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		buttonNormal();
	}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		buttonHover();
		this.buttonPlayer.play();
	}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		buttonNormal();
	}
}
