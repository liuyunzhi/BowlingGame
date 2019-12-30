package bowling;

public class Game {
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 0;
    private boolean firstThrow = true;

    public void add(final int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        if (firstThrow) {
            firstThrow = false;
            itsCurrentFrame++;
        } else {
            firstThrow = true;
        }
    }

    public int score() {
        return itsScore;
    }

    public int scoreForFrame(int theFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            int frameScore = firstThrow + secondThrow;
            if (frameScore == 10) {
                score += frameScore + itsThrows[ball];
            } else {
                score += frameScore;
            }
        }
        return score;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
