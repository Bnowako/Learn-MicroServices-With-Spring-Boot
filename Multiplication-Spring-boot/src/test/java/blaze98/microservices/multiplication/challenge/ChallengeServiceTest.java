//package blaze98.microservices.multiplication.challenge;
//
//import blaze98.microservices.multiplication.GamificationServiceClient;
//import blaze98.microservices.multiplication.user.User;
//import blaze98.microservices.multiplication.user.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.BDDAssertions.then;
//import static org.mockito.AdditionalAnswers.returnsFirstArg;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class ChallengeServiceTest {
//    private ChallengeService challengeService;
//
//
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private ChallengeAttemptRepository challengeAttemptRepository;
//
//    @BeforeEach
//    public void setUp(){
//
//        challengeService = new ChallengeServiceImpl(
//                userRepository,
//                challengeAttemptRepository
//        );
//        given(challengeAttemptRepository.save(any())).will(returnsFirstArg());
//
//    }
//    @Test
//    public void checkCorrectAttemptTest(){
//        //given
//        ChallengeAttemptDto challengeAttemptDto =
//                new ChallengeAttemptDto(50,60,"john_doe",3000);
//        //when
//        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDto);
//        //then
//        then(resultAttempt.isCorrect()).isTrue();
//
//        verify(userRepository).save(new User("john_doe"));
//        verify(challengeAttemptRepository).save(resultAttempt);
//    }
//
//    @Test
//    public void checkWrongAttemptTest(){
//        ChallengeAttemptDto challengeAttemptDto =
//                new ChallengeAttemptDto(20,20,"john_doe",3000);
//        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDto);
//
//        then(resultAttempt.isCorrect()).isFalse();
//    }
//
//    @Test
//    public void checkExistingUserTest(){
//        //given
//        User existingUser = new User(1L, "john_doe");
//        given(userRepository.findByAlias("john_doe"))
//                .willReturn(Optional.of((existingUser)));
//        ChallengeAttemptDto challengeAttemptDto =
//                new ChallengeAttemptDto(50,60,"john_doe",5000);
//        //when
//        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDto);
//        //then
//        then(resultAttempt.isCorrect()).isFalse();
//        then(resultAttempt.getUser()).isEqualTo(existingUser);
//        verify(userRepository, never()).save(any());
//        verify(challengeAttemptRepository).save(resultAttempt);
//    }
//
//    @Test
//    public void retrieveStatsTest(){
//        //given
//        User user = new User("john_doe");
//        ChallengeAttempt attempt1 = new ChallengeAttempt(1L,user,50,60,3010,false);
//        ChallengeAttempt attempt2 = new ChallengeAttempt(2L,user,50,60,3051,false);
//        List<ChallengeAttempt> lastAttempts = List.of(attempt1,attempt2);
//        given(challengeAttemptRepository.findTop10ByUserAliasOrderByIdDesc("johh_doe"))
//                .willReturn(lastAttempts);
//        //when
//        List<ChallengeAttempt> latestAttemptResult = challengeService.getStatsForUser("john_doe");
//
//        //then
//        then(latestAttemptResult).isEqualTo(lastAttempts);
//    }
//
//}
