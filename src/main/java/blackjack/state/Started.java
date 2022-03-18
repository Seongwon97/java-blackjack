package blackjack.state;

import blackjack.card.Cards;

public abstract class Started implements State {

    private final Cards cards;

    Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public final Cards cards() {
        return cards;
    }
}
