package valleriote.paulo.awesometickets.domain.repository;

import valleriote.paulo.awesometickets.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
}
