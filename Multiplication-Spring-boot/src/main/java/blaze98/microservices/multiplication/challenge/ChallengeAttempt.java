package blaze98.microservices.multiplication.challenge;

import blaze98.microservices.multiplication.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeAttempt {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;
}
