package blaze98.microservices.gamification;

import blaze98.microservices.gamification.domain.BadgeType;
import blaze98.microservices.gamification.domain.ScoreCard;

import java.util.List;
import java.util.Optional;

public class LuckyNumberBadgeProcessor implements BadgeProcessor{
    @Override
    public Optional<BadgeType> processForOptionalBadge(
            int currentScore,
            List<ScoreCard> scoreCardList,
            ChallengeSolvedDTO solved
    ){
        return solved.getFactorA() == 42 || solved.getFactorB() == 42 ? Optional.of(BadgeType.LUCKY_NUMBER) : Optional.empty();
    }
    @Override
    public BadgeType badgeType(){
        return BadgeType.LUCKY_NUMBER;
    }
}
