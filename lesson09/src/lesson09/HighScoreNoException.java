package lesson09;

public class HighScoreNoException {
	private int score = 0;
	private boolean scoreSet = false;

	public HighScoreNoException() {
		score = 0;
		scoreSet = false;
	}

	public void setScore(int newScore) {
		score = newScore;
		scoreSet = true;
	}

	public int getScore() {
		if (!scoreSet)
			return -1;
		else
			return score;
	}

	// Short test program
	public static void main(String[] args) {
		HighScoreNoException highscore = new HighScoreNoException();
		System.out.println(highscore.getScore());
		highscore.setScore(100);
		System.out.println(highscore.getScore());
	}
}