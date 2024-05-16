package valleriote.paulo.awesometickets.domain.repository;

import valleriote.paulo.awesometickets.app.dto.user.UserUpdateDTO;
import valleriote.paulo.awesometickets.domain.entity.Event;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    List<T> find();
    Optional<T> findById(ID id);
    void save(T entity);
    void delete(ID id);
}
