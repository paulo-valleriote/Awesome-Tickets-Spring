package valleriote.paulo.awesometickets.infra.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import valleriote.paulo.awesometickets.domain.entity.Registration;

import java.util.Set;

@Component
public interface RegistrationJpaRepository extends JpaRepository<Registration, String> {
    @Query(
            """
                SELECT registration FROM Registration registration
                INNER JOIN registration.user user
                INNER JOIN registration.event event
                WHERE user.id = :userId
            """
    )
    public Set<Registration> findAllByUserId(@Param("userId") String userId);

    @Query(
            """
                SELECT registration FROM Registration registration
                INNER JOIN registration.user user
                INNER JOIN registration.event event
                WHERE user.id = :userId
                AND event.id = :eventId
            """
    )
    public Registration findByUserIdAndEventId(@Param("userId") String userId, @Param("eventId") String eventId);
}
