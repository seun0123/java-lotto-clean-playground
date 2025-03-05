package domain;

import java.util.*;

public enum WinningRank {
    ZERO_MATCH(0, 0),
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private final int matchCount;
    private final int price;

    WinningRank(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static WinningRank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCH_WITH_BONUS;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(ZERO_MATCH);
    }

    public static List<WinningRank> getOrderedRanks() {
        return List.of(
                THREE_MATCH,
                FOUR_MATCH,
                FIVE_MATCH,
                FIVE_MATCH_WITH_BONUS,
                SIX_MATCH
        );
    }
}

