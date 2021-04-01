package blaze98.microservices.multiplication.challenge;

import blaze98.microservices.multiplication.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ChallengeGeneratorServiceImpl implements ChallengeGeneratorService{
    private final static int MINIMUM_FACTOR = 11;
    private final static int MAXIMUM_FACTOR = 100;



    private Random random;
    ChallengeGeneratorServiceImpl(){
        this.random = new Random();
    }
    protected ChallengeGeneratorServiceImpl(final Random random){
        this.random = random;
    }

    @Override
    public Challenge randomChallenge(){
        return new Challenge(next(),next());
    }
    private int next(){
        return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR) + MINIMUM_FACTOR;
    }
}
