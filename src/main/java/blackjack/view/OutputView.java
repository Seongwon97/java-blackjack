package blackjack.view;

import blackjack.domain.*;
import blackjack.domain.card.Card;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.player.User;
import blackjack.domain.player.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String INPUT_USER_NAMES_GUIDE_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String DISTRIBUTE_CONFIRM_MESSAGE_FORMAT = "%s와 %s에게 %d장의 카드를 나누었습니다.";
    private static final String PLAYER_INFORMATION_FORMAT = "%s 카드: %s";
    private static final String COMMA_WITH_SPACE = ", ";
    private static final String ASK_ONE_MORE_CARD_MESSAGE_FORMAT = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String ASK_CORRECT_RESPONSE_MESSAGE = "y 또는 n을 입력해주세요.";
    private static final String DEALER_PLAY_CONFIRM_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String PLAYER_FINAL_INFORMATION_FORMAT = "%s 카드: %s - 결과 : %d";
    private static final String FINAL_RESULT_HEADER_MESSAGE = "## 최종 승패";

    public static void printInputUserNamesGuideMessage() {
        System.out.println(INPUT_USER_NAMES_GUIDE_MESSAGE);
    }

    public static void printDistributeConfirmMessage(Dealer dealer, Users users) {
        String userNames = String.join(COMMA_WITH_SPACE, users.getNames());
        System.out.println(NEW_LINE);
        System.out.println(String.format(DISTRIBUTE_CONFIRM_MESSAGE_FORMAT, dealer.getName(), userNames, Player.INITIAL_CARDS_SIZE));
    }

    public static void printInitialPlayerCards(Dealer dealer, Users users) {
        List<Player> players = new ArrayList<>();
        players.add(dealer);
        players.addAll(users.getUsers());

        for (Player player : players) {
            System.out.println(String.format(
                    PLAYER_INFORMATION_FORMAT, player.getName(), combineCards(player.getInitialCards())));
        }
    }

    public static void printUserCards(User user) {
        System.out.println(String.format(
                PLAYER_INFORMATION_FORMAT, user.getName(), combineCards(user.getCards())));
    }

    private static String combineCards(List<Card> cards) {
        return cards.stream()
                .map(OutputView::informationOf)
                .collect(Collectors.joining(COMMA_WITH_SPACE));
    }

    private static String informationOf(Card card) {
        return card.getType().getName() + card.getSymbol().getKoreanName();
    }

    public static void printAskOneMoreCardMessage(User user) {
        System.out.println(String.format(ASK_ONE_MORE_CARD_MESSAGE_FORMAT, user.getName()));
    }

    public static void printCorrectResponseMessage() {
        System.out.println(ASK_CORRECT_RESPONSE_MESSAGE);
    }

    public static void printDealerPlayConfirmMessage() {
        System.out.println(DEALER_PLAY_CONFIRM_MESSAGE);
    }

    public static void printPlayerFinalScore(Dealer dealer, Users users) {
        List<Player> players = new ArrayList<>();
        players.add(dealer);
        players.addAll(users.getUsers());

        for (Player player : players) {
            System.out.println(String.format(
                    PLAYER_FINAL_INFORMATION_FORMAT,
                    player.getName(), combineCards(player.getCards()), player.calculateScore()));
        }
    }

    public static void printGameResult(GameResult gameResult) {
        printDealerResult(gameResult);
        printUsersResult(gameResult);
    }

    private static void printDealerResult(GameResult gameResult) {
        System.out.println(NEW_LINE);
        System.out.println(FINAL_RESULT_HEADER_MESSAGE);
        System.out.println(String.format("딜러 : %d승 %d무 %d패",
                countDealerResult(gameResult, UserResult.LOSE),
                countDealerResult(gameResult, UserResult.DRAW),
                countDealerResult(gameResult, UserResult.WIN)
        ));
    }

    private static int countDealerResult(GameResult gameResult, UserResult userResult) {
        return (int) gameResult.getGameResult()
                .values()
                .stream()
                .filter(result -> result.equals(userResult))
                .count();
    }

    private static void printUsersResult(GameResult gameResult) {
        for (User user : gameResult.getGameResult().keySet()) {
            System.out.println(
                    String.format("%s : %s", user.getName(), gameResult.getKoreanName(user)));
        }
    }
}