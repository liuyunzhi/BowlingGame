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
}
