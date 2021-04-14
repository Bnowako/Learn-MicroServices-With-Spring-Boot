package blaze98.microservices.gamification;

import blaze98.microservices.gamification.domain.BadgeType;
import blaze98.microservices.gamification.domain.ScoreCard;

import java.util.List;
import java.util.Optional;

public interface BadgeProcessor {
    Optional<BadgeType> processForOptionalBadge(
            int currentScore,
            List<ScoreCard> scoreCardList,
            ChallengeSolvedDTO solved);
    BadgeType badgeType();
}
