package blackjack.state;

import blackjack.card.Card;
import blackjack.card.Cards;

public interface State {

    State draw(final Card card);

    State stay();

    Cards cards();

    boolean isFinished();

    double profit(double money);
}
