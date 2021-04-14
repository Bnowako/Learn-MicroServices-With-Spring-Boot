package blaze98.microservices.gamification;

import blaze98.microservices.gamification.domain.BadgeCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BadgeRepository extends CrudRepository<BadgeCard,Long> {
    List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(Long userId);
}
