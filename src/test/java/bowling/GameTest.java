package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void two_throws_no_mark() {
        game.add(5);
        game.add(4);

        assertEquals(9, game.score());
    }

    @Test
    void four_throws_no_mark() {
        game.add(5);
        game.add(4);
        game.add(7);
        game.add(2);

        assertEquals(18, game.score());
        assertEquals(9, game.scoreForFrame(1));
        assertEquals(18, game.scoreForFrame(2));
    }

    @Test
    void simple_spare() {
        game.add(3);
        game.add(7);
        game.add(3);

        assertEquals(13, game.scoreForFrame(1));
    }

    @Test
    void simple_frame_after_spare() {
        game.add(3);
        game.add(7);
        game.add(3);
        game.add(2);

        assertEquals(13, game.scoreForFrame(1));
        assertEquals(18, game.scoreForFrame(2));
        assertEquals(18, game.score());
    }

    @Test
    void simple_strike() {
        game.add(10);
        game.add(3);
        game.add(6);

        assertEquals(19, game.scoreForFrame(1));
        assertEquals(28, game.score());
    }

    @Test
    void perfect_game() {
        for (int i = 0; i < 12; i++) {
            game.add(10);
        }
        assertEquals(300, game.score());
    }

    @Test
    void strike_at_the_latest_throw() {
        for (int i = 0; i < 9; i++) {
            game.add(0);
            game.add(0);
        }
        game.add(2);
        game.add(8);
        game.add(10);
        assertEquals(20, game.score());
    }

    @Test
    void simple_game() {
        game.add(1);
        game.add(4);

        game.add(4);
        game.add(5);

        game.add(6);
        game.add(4);

        game.add(5);
        game.add(5);

        game.add(10);

        game.add(0);
        game.add(1);

        game.add(7);
        game.add(3);

        game.add(6);
        game.add(4);

        game.add(10);

        game.add(2);
        game.add(8);
        game.add(6);

        assertEquals(133, game.score());
    }

    @Test
    void heart_break() {
        for (int i = 0; i < 11; i++) {
            game.add(10);
        }
        game.add(9);

        assertEquals(299, game.score());
    }

    @Test
    void tenth_frame_spare() {
        for (int i = 0; i < 9; i++) {
            game.add(10);
        }
        game.add(9);
        game.add(1);
        game.add(1);

        assertEquals(270, game.score());
    }
}
