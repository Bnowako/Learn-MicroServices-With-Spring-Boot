package blaze98.microservices.gamification;

import blaze98.microservices.gamification.domain.BadgeType;
import lombok.Value;

import java.util.List;

public interface GameService {
    GameResult newAttemptForUser(ChallengeSolvedEvent challenge);

    @Value
    class GameResult{
        int score;
        List<BadgeType> badges;
    }
}
