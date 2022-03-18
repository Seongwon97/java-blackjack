package blackjack.state;

import blackjack.card.Cards;
import blackjack.state.Hit;
import blackjack.state.State;
import org.junit.jupiter.api.Test;

import static blackjack.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;

class HitTest {

    @Test
    void hit() {
        Cards cards = new Cards(SPADE_JACK,
                SPADE_TWO);
        State state = new Hit(cards);

        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void hitDraw() {
        Cards cards = new Cards(SPADE_TWO,
                SPADE_JACK);
        State state = new Hit(cards);
        state = state.draw(SPADE_ACE);

        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void stay() {
        State state = new Hit(new Cards(SPADE_TWO, SPADE_JACK))
                .draw(SPADE_ACE)
                .stay();

        assertThat(state).isInstanceOf(Stay.class);
    }
}
