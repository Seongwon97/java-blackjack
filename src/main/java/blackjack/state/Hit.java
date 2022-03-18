package blackjack.state;

import blackjack.card.Card;
import blackjack.card.Cards;

public final class Hit extends Running {

    Hit(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        final var cards = cards().add(card);

        if (cards.isBust()) {
            return new Bust(cards);
        }
        // 21이 넘으면 bust
        return new Hit(cards);
    }

    @Override
    public State stay() {
        return new Stay(cards());
    }
}
