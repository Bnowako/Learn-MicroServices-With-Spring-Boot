package blaze98.microservices.multiplication.challenge;

import java.util.List;

public interface ChallengeService {
    ChallengeAttempt verifyAttempt(ChallengeAttemptDto resultAttempt);
    List<ChallengeAttempt> getStatsForUser(String userAlias);
}
