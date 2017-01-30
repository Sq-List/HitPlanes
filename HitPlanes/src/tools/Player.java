package tools;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player
{
	private Clip clip;
	
	public Player(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		//��ȡ�ļ�
		File file = new File(path);
		//ʹ��AudioSystem�е�getAudioInputStream��ȡ��Ƶ�ļ�
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		//��ÿ����ڻط���Ƶ�ļ�����Ƶ���ļ���
		clip = AudioSystem.getClip();
		//���صļ��������� open(AudioFormat) �� open(AudioInputStream) ������
		clip.open(audioInputStream);
	}
	
	public void play()
	{
		//���ò��ſ�ʼ��λ��
		clip.setFramePosition(0);
		//��ʼ����
		clip.start();
	}
	
	public void loop()
	{
		//ָʾѭ��Ӧ�������ڼ�����������ָ��������ѭ������ɵ�ֵ
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop()
	{
		//ֹͣ����
		clip.stop();
	}
}
