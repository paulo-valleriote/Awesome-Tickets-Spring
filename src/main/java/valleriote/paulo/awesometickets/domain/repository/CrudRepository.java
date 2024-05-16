package valleriote.paulo.awesometickets.domain.repository;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T, ID> {
    Set<T> find();
    Optional<T> findById(ID id);
    void save(T entity);
    void delete(ID id);
}
