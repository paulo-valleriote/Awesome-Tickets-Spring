package valleriote.paulo.awesometickets.infra.security.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import valleriote.paulo.awesometickets.app.handler.exceptions.user.UserNotFoundException;
import valleriote.paulo.awesometickets.domain.entity.User;
import valleriote.paulo.awesometickets.domain.repository.UserRepository;
import valleriote.paulo.awesometickets.infra.persistance.repository.UserRepositoryImplementation;

import java.util.Optional;

@Service
@Log4j2
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthService(UserRepositoryImplementation userRepositoryImplementation) {
        this.userRepository = userRepositoryImplementation;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        return user.get();
    }
}
