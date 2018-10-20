package akshat.sound;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WAVPlayer {
	final Clip clip;
	public WAVPlayer(URL soundURL) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream stream = AudioSystem.getAudioInputStream(soundURL);
		AudioFormat format = stream.getFormat();
		DataLine.Info audioInfo = new DataLine.Info(Clip.class, format);
		clip = (Clip) AudioSystem.getLine(audioInfo);
		clip.open(stream);
	}
	
	public void playLoop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void play() {
		clip.start();
		clip.setFramePosition(0);
	}
	
	public void stop() {
		clip.stop();
	}
}
