package blackjack;

import blackjack.card.Card;
import blackjack.card.Denomination;
import blackjack.card.Suit;
import org.junit.jupiter.api.Test;

import static blackjack.Fixture.SPADE_ACE;
import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @Test
    void of() {
        assertThat(SPADE_ACE).isSameAs(Card.of(Suit.SPADES, Denomination.ACE));
    }
}
