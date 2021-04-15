package blaze98.microservices.multiplication.challenge;

import blaze98.microservices.multiplication.GamificationServiceClient;
import blaze98.microservices.multiplication.user.User;
import blaze98.microservices.multiplication.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChallengeServiceImpl implements ChallengeService{

    private final UserRepository userRepository;
    private final ChallengeAttemptRepository challengeAttemptRepository;
    private final GamificationServiceClient gameClient;



    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttemptDto){

        User user = userRepository.findByAlias(challengeAttemptDto.getUserAlias())
                .orElseGet( () -> {
                    log.info("Creating new user with alias {}",
                            challengeAttemptDto.getUserAlias());
                    return userRepository.save
                            (new User(challengeAttemptDto.getUserAlias()));
                });


        boolean isCorrect = challengeAttemptDto.getGuess() ==
                challengeAttemptDto.getFactorA() * challengeAttemptDto.getFactorB();

        ChallengeAttempt checkedAttempt =
                new ChallengeAttempt(
                        null,
                        user,
                        challengeAttemptDto.getFactorA(),
                        challengeAttemptDto.getFactorB(),
                        challengeAttemptDto.getGuess(),
                        isCorrect);
        ChallengeAttempt storedAttempt = challengeAttemptRepository.save(checkedAttempt);

        boolean status = gameClient.sendAttempt(storedAttempt);
        log.info("Gamification service response: {}", status);

    return storedAttempt;
    }

    @Override
    public List<ChallengeAttempt> getStatsForUser(final String userAlias){
        return challengeAttemptRepository.findTop10ByUserAliasOrderByIdDesc(userAlias);
    }
}
