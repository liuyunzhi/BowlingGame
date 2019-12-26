package bowling;

public class Game {
    private int itsScore = 0;

    public void add(final int pins) {
        itsScore += pins;
    }

    public int score() {
        return itsScore;
    }
}
