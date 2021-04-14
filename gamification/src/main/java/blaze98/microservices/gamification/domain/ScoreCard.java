package blaze98.microservices.gamification.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCard {
    public static final int DEFAULT_SCORE = 10;

    @Id
    @GeneratedValue
    private Long cardId;
    private Long userId;
    private Long attemptId;
    @EqualsAndHashCode.Exclude
    private long scoreTimestamp;
    private int score;

    public ScoreCard(final Long userId, final Long attemptId){
        this(null,userId,attemptId,
                System.currentTimeMillis(),
                DEFAULT_SCORE);
    }
}
