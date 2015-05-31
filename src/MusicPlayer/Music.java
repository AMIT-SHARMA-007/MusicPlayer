package MusicPlayer;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
	Media hit;
	MediaPlayer m;
	int index;

	String a = "";

	void play(int index) {
		if (index == 0) {
			a = new File("a.mp3").toURI().toString();
		} else if (index == 1) {
			a = new File("b.mp3").toURI().toString();
			;
		}

		try {
			if (m.getCurrentTime().toMillis() > 0)
				m.stop();
		} catch (NullPointerException ne) {
		}
		hit = new Media(a);
		m = new MediaPlayer(hit);
		System.out.println(m.getStatus().toString());
		// m.stop();
		// m.setStartTime(new Duration(100000));
		m.play();
	}
	
	void pause(){
		m.pause();
	}
	
	void resume(){
		m.play();
	}
	
	void stop(){
		m.stop();
	}
}
