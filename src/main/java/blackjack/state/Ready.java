package blackjack.state;

import blackjack.card.Card;
import blackjack.card.Cards;

import java.util.List;

public final class Ready extends Running {

    public Ready() {
        this(new Cards());
    }

    public Ready(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        final var cards = cards().add(card);
        if(cards.isReady()) {
            return new Ready(cards);
        }
        if (cards.isBlackJack()) {
            return new Blackjack(cards);
        }
        return new Hit(cards);
    }

    @Override
    public State stay() {
        throw new IllegalStateException();
    }

    public static State start(final Card first,
                              final Card second) {
        final var cards = new Cards(List.of(first,second));
        if (cards.isBlackJack()) {
            return new Blackjack(cards);
        }
        return new Hit(cards);
    }
}
