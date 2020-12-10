package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Score {
	public static void createTimer() {
		Level.timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (Level.player.changeScore()) {
					setScore(Level.player.getPoints());
				}
				if (Level.player.getStop()) {
					System.out.print("STOPP:");
					Level.backgroud.stopMusic();
					stop();
					Level.backgroud.stop();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("You Have Won The Game!");
					alert.setHeaderText("Your High Score: " + Level.player.getPoints() + "!");
					alert.setContentText("Highest Possible Score: 1000");
					alert.show();
				}
			}
		};
	}

	public static void startScore() {
		Level.backgroud.playMusic();
		createTimer();
		Level.timer.start();
	}

	public void stopScore() {
		Level.timer.stop();
	}

	public static void setScore(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			Level.backgroud.add(new Digit(k, 30, 360 - shift, 25));
			shift += 30;
		}
	}
}