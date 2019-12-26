package bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    void one_throw() {
        final Game game = new Game();

        game.add(5);

        assertEquals(5, game.score());
    }

    @Test
    void two_throws_no_mark() {
        final Game game = new Game();

        game.add(5);
        game.add(4);

        assertEquals(9, game.score());
    }

    @Test
    void four_throws_no_mark() {
        final Game game = new Game();

        game.add(5);
        game.add(4);
        game.add(7);
        game.add(2);

        assertEquals(18, game.score());
        assertEquals(9, game.scoreForFrame(1));
        assertEquals(18, game.scoreForFrame(2));
    }
}
