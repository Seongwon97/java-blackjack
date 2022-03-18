package blackjack.state;

import blackjack.card.Cards;

public final class Blackjack extends Finished {

    Blackjack(final Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return 1.5;
    }
}
