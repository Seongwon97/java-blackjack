package blackjack.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private final List<Card> value;

    public Cards() {
        this(new ArrayList<>());
    }

    public Cards(final Card... value) {
        this(List.of(value));
    }

    public Cards(final List<Card> value) {
        this.value = value;
    }

    public boolean isBlackJack() {
        return 11 == sum() && hasAce();
    }

    private int sum() {
        return value.stream()
                .mapToInt(Card::point)
                .sum();
    }

    private boolean hasAce() {
        return value.stream()
                .anyMatch(Card::isAce);
    }

    public boolean isReady() {
        return value.size() < 2;
    }

    public Cards add(final Card card) {
        final var newValue = new ArrayList<>(value);
        newValue.add(card);

        return new Cards(newValue);
    }

    public boolean isBust() {
        return sum() > 21;
    }
}
