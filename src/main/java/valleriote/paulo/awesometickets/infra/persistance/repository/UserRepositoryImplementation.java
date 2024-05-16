package valleriote.paulo.awesometickets.infra.persistance.repository;

import org.springframework.stereotype.Repository;
import valleriote.paulo.awesometickets.domain.entity.User;
import valleriote.paulo.awesometickets.domain.repository.UserRepository;
import valleriote.paulo.awesometickets.infra.persistance.jpa.UserJpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImplementation implements UserRepository {
    private final UserJpaRepository repository;

    public UserRepositoryImplementation(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> find() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }
    @Override
    public void save(User user) {
        repository.saveAndFlush(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
