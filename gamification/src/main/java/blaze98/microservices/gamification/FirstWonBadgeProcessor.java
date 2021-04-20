package blaze98.microservices.gamification;

import blaze98.microservices.gamification.domain.BadgeType;
import blaze98.microservices.gamification.domain.ScoreCard;

import java.util.List;
import java.util.Optional;

public class FirstWonBadgeProcessor implements BadgeProcessor{
    @Override
    public Optional<BadgeType> processForOptionalBadge(
            int currentScore,
            List<ScoreCard> scoreCardList,
            ChallengeSolvedEvent solved) {
        return scoreCardList.size() == 1 ?
                Optional.of(BadgeType.FIRST_WON) : Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.FIRST_WON;
    }
}
