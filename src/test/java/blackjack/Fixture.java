package blackjack;

import blackjack.card.Card;
import blackjack.card.Denomination;
import blackjack.card.Suit;

public class Fixture {

    public static final Card SPADE_ACE = Card.of(Suit.SPADES, Denomination.ACE);
    public static final Card SPADE_TWO = Card.of(Suit.SPADES, Denomination.TWO);
    public static final Card SPADE_TEN = Card.of(Suit.SPADES, Denomination.TEN);
    public static final Card SPADE_JACK = Card.of(Suit.SPADES, Denomination.JACK);
}
