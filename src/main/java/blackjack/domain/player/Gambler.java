package blackjack.domain.player;

import blackjack.domain.BettingMoney;
import blackjack.domain.Name;
import blackjack.domain.card.GamblerCards;
import blackjack.domain.result.PlayerOutcome;
import blackjack.util.NullChecker;
import java.util.List;

public final class Gambler extends Player implements Drawable {

    private static final int BASES_SCORE_CAN_DRAW = 21;

    private final BettingMoney bettingMoney;

    public Gambler(Name name, BettingMoney bettingMoney) {
        this(name, bettingMoney, new GamblerCards());
    }

    public Gambler(Name name, BettingMoney bettingMoney, GamblerCards gamblerCards) {
        super(name, gamblerCards);
        NullChecker.validateNotNull(bettingMoney);
        this.bettingMoney = bettingMoney;
    }

    @Override
    public boolean canDraw() {
        return isEqualOrUnderScore(BASES_SCORE_CAN_DRAW);
    }

    public Integer getProfit(PlayerOutcome outcome) {
        return bettingMoney.profit(outcome);
    }

    @Override
    public List<String> getFirstTimeCardsInfo() {
        return getCardsInfos();
    }
}