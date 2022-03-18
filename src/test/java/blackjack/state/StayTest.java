package blackjack.state;

import blackjack.card.Cards;
import org.junit.jupiter.api.Test;

import static blackjack.Fixture.*;
import static org.junit.jupiter.api.Assertions.*;

class StayTest {

    @Test
    void stay() {
        final var state = new Stay(new Cards(SPADE_TWO, SPADE_JACK));

        assertThrows(IllegalStateException.class, state::stay);
    }

    @Test
    void draw() {
        final var state = new Stay(new Cards(SPADE_TWO, SPADE_JACK));

        assertThrows(IllegalStateException.class, () -> state.draw(SPADE_ACE));
    }

}
