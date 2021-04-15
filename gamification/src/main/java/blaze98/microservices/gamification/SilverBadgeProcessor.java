package blaze98.microservices.gamification;

import blaze98.microservices.gamification.domain.BadgeType;
import blaze98.microservices.gamification.domain.ScoreCard;

import java.util.List;
import java.util.Optional;

public class SilverBadgeProcessor implements BadgeProcessor{
    @Override
    public Optional<BadgeType> processForOptionalBadge(
            int currentScore,
            List<ScoreCard> scoreCardList,
            ChallengeSolvedDTO solved
    ){
        return currentScore > 40 ? Optional.of(BadgeType.SILVER) : Optional.empty();
    }
    @Override
    public BadgeType badgeType(){
        return BadgeType.SILVER;
    }
}
