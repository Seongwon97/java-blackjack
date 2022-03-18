package blackjack;

import blackjack.state.Ready;
import blackjack.state.State;

public class Player {

    private State state = new Ready();

    public void draw(Deck deck) {
        state = state.draw(deck.pick());
    }
    // 플레이어 입장에서는 Interface를 사용하여 현제 상태를 모르게 된다. (유한 상태 기계)
    // 상태 패턴은 단위 테스트, 통합 테스트 등 테스트도 쉬워진다.
}
