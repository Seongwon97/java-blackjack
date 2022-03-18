package blackjack.state;

import blackjack.card.Cards;

public final class Bust extends Finished {

    Bust(final Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return -1;
    }
}
