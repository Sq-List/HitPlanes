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
		//获取文件
		File file = new File(path);
		//使用AudioSystem中的getAudioInputStream获取音频文件
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		//获得可用于回放音频文件或音频流的剪辑
		clip = AudioSystem.getClip();
		//返回的剪辑必须用 open(AudioFormat) 或 open(AudioInputStream) 方法打开
		clip.open(audioInputStream);
	}
	
	public void play()
	{
		//设置播放开始的位置
		clip.setFramePosition(0);
		//开始播放
		clip.start();
	}
	
	public void loop()
	{
		//指示循环应该无限期继续而不是在指定数量的循环后完成的值
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop()
	{
		//停止播放
		clip.stop();
	}
}
