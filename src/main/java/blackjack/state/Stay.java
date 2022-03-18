package blackjack.state;

import blackjack.card.Cards;

public final class Stay extends Finished {

    Stay(final Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return 1; // 일단 1배(승패 비교해야함)
    }
}
