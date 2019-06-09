package ro.utcn.sd.cata.dailyFit.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ro.utcn.sd.cata.dailyFit.repository.UserRepository;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserSeed implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
    //to do
    }
}
