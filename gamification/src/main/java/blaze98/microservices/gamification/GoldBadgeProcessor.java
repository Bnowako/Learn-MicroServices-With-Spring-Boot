package blaze98.microservices.gamification;

import blaze98.microservices.gamification.domain.BadgeType;
import blaze98.microservices.gamification.domain.ScoreCard;

import java.util.List;
import java.util.Optional;

public class GoldBadgeProcessor implements BadgeProcessor{
    @Override
    public Optional<BadgeType> processForOptionalBadge(
            int currentScore,
            List<ScoreCard> scoreCardList,
            ChallengeSolvedDTO solved
    ){
        return currentScore > 400 ? Optional.of(BadgeType.GOLD) : Optional.empty();
    }
    @Override
    public BadgeType badgeType(){
        return BadgeType.GOLD;
    }
}
