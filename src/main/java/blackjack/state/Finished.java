package blackjack.state;

import blackjack.card.Card;
import blackjack.card.Cards;

public abstract class Finished extends Started {

    protected Finished(final Cards cards) {
        super(cards);
    }

    @Override
    public final State draw(final Card card) {
        throw new IllegalStateException();
    }

    @Override
    public final State stay() {
        throw new IllegalStateException();
    }

    @Override
    public final boolean isFinished() {
        return true;
    }

    @Override
    public final double profit(double money) {
        return money * earningRate();
    }

    protected abstract double earningRate();
}
