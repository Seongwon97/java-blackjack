package blackjack.state;

import blackjack.card.Cards;

public abstract class Running extends Started {

    Running(final Cards cards) {
        super(cards);
    }

    @Override
    public final boolean isFinished() {
        return false;
    }

    @Override
    public final double profit(double money) {
        throw new IllegalStateException();
    }
}
