package blaze98.microservices.multiplication.challenge;

import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


@Value
public class ChallengeAttemptDto {
    @Min(1) @Max(99)
    int factorA,factorB;
    @NotBlank
    String userAlias;
    @Positive(message = "HOw could you possibly get a negative result here?")
    int guess;
}
