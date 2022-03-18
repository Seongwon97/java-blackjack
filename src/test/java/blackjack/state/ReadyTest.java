package blackjack.state;

import org.junit.jupiter.api.Test;

import static blackjack.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadyTest {

    @Test
    void hit() {
        // 카드 두장을 넣으면 blackjack or Hit
        // hit
        final var state = new Ready().draw(SPADE_ACE)
                .draw(SPADE_TWO);

        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void hit2() {
        // 2, 10, 1 -> 13
        final var state = new Ready().draw(SPADE_TWO)
                .draw(SPADE_JACK)
                .draw(SPADE_ACE);

        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void hitBust() {
        // 2, 10, 10 -> Bust
        final var state = new Ready().draw(SPADE_TWO)
                .draw(SPADE_JACK)
                .draw(SPADE_TEN);

        assertThat(state).isInstanceOf(Bust.class);
    }

    @Test
    void blackjack() {
        // 블랙잭은 더이상 게임을 할 수 없다.
        final var state = new Ready().draw(SPADE_ACE)
                .draw(SPADE_JACK);

        assertThat(state).isInstanceOf(Blackjack.class);
    }

    @Test
    void blackjackDraw() {
        // 블랙잭은 더이상 게임을 할 수 없다.
        final var state = new Ready().draw(SPADE_ACE)
                .draw(SPADE_JACK);

        assertThrows(IllegalStateException.class,
                () -> state.draw(SPADE_TEN));
    }
}
