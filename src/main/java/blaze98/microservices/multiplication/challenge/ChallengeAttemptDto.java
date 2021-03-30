package blaze98.microservices.multiplication.challenge;

import lombok.Value;

@Value
public class ChallengeAttemptDto {
    int factorA,factorB;
    String userAlias;
    int guess;
}
