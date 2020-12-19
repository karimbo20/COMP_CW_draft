package frogger_main;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyStage extends World{
	public int lvl = 0;
	MediaPlayer mediaPlayer;
	public void act(long now) {
		
	}
	
	public MyStage() {
		
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
	}
	
	public void playMusic() {
		String musicFile = "src/resources/frogger.mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	public void mute(boolean value) {
		if(value) {
			mediaPlayer.stop();
		}else {
			this.playMusic();
		}
	}

}



