package lesson09;

public class HighScoreException {
	
	private int score = 0;
	private boolean scoreSet = false;
	
	public class ScoreNotSetException extends Exception {
		
		public ScoreNotSetException() {
			super("Score not set");
		}

		public ScoreNotSetException(String message) {
			super(message);
		}
	}

	public HighScoreException() {
		score = 0;
		scoreSet = false;
	}

	public void setScore(int newScore) {
		score = newScore;
		scoreSet = true;
	}

	public int getScore() throws ScoreNotSetException {
		if (!scoreSet)
			throw new ScoreNotSetException();
		else
			return score;
	}

	// Short test program
	public static void main(String[] args) {
		
		HighScoreException highscore = new HighScoreException();
		try {
			System.out.println(highscore.getScore());
		} catch (ScoreNotSetException e) {
			System.out.println(e.getMessage());
		}
		
		highscore.setScore(100);
		
		try {
			System.out.println(highscore.getScore());
		} catch (ScoreNotSetException e) {
			System.out.println(e.getMessage());
		}
	}



}