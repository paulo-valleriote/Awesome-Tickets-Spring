package valleriote.paulo.awesometickets.domain.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import valleriote.paulo.awesometickets.app.dto.user.UserCreateDTO;
import valleriote.paulo.awesometickets.app.dto.user.UserResponseDTO;
import valleriote.paulo.awesometickets.app.dto.user.UserUpdateDTO;
import valleriote.paulo.awesometickets.app.handler.exceptions.user.UserAlreadyExists;
import valleriote.paulo.awesometickets.app.handler.exceptions.user.UserNotFoundException;
import valleriote.paulo.awesometickets.domain.entity.User;
import valleriote.paulo.awesometickets.domain.repository.UserRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Set<UserResponseDTO> list() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(User::toDTO).collect(Collectors.toSet());
    }

    @Override
    public UserResponseDTO findById(String id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(UserNotFoundException::new)
                .toDTO();
    }

    @Override
    public UserResponseDTO create(UserCreateDTO dto) {
        if (userRepository.existsByUsername(dto.username())) {
            throw new UserAlreadyExists();
        }

        String encodedPassword = passwordEncoder.encode(dto.password());

        User newUser = new User(dto.username(), encodedPassword);
        userRepository.save(newUser);
        return newUser.toDTO();
    }

    @Override
    public void update(String id, UserUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        if (userRepository.existsByUsername(dto.username())) {
            throw new UserAlreadyExists();
        }

        if (dto.username() != null) {
            user.setUsername(dto.username());
        }

        if (dto.enabled() != null) {
            user.setEnabled(dto.enabled());
        }

        userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        user.setEnabled(false);
        userRepository.save(user);
    }
}
