package blaze98.microservices.multiplication.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.BDDAssertions.then;
public class ChallengeServiceTest {
    private ChallengeService challengeService;

    @BeforeEach
    public void setUp(){
        challengeService = new ChallengeServiceImpl();
    }
    @Test
    public void checkCorrectAttemptTest(){
        ChallengeAttemptDto challengeAttemptDto =
                new ChallengeAttemptDto(50,60,"john_doe",3000);
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDto);

        then(resultAttempt.isCorrect()).isTrue();
    }

    @Test
    public void checkWrongAttemptTest(){
        ChallengeAttemptDto challengeAttemptDto =
                new ChallengeAttemptDto(20,20,"jogh_deo",3000);
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDto);

        then(resultAttempt.isCorrect()).isFalse();

    }
}
