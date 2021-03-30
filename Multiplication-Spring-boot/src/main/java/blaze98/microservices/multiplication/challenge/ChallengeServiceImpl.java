package blaze98.microservices.multiplication.challenge;

import blaze98.microservices.multiplication.user.User;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService{
    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttemptDto){
        boolean isCorrect = challengeAttemptDto.getGuess() ==
                challengeAttemptDto.getFactorA() * challengeAttemptDto.getFactorB();
        User user = new User(null, challengeAttemptDto.getUserAlias());
        ChallengeAttempt checkedAttempt =
                new ChallengeAttempt(
                        null,
                        user.getId(),
                        challengeAttemptDto.getFactorA(),
                        challengeAttemptDto.getFactorB(),
                        challengeAttemptDto.getGuess(),
                        isCorrect);
    return checkedAttempt;
    }
}
