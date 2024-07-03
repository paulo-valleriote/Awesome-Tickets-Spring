package valleriote.paulo.awesometickets.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import valleriote.paulo.awesometickets.app.dto.event.EventCreateDTO;
import valleriote.paulo.awesometickets.app.dto.event.EventResponseDTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @OneToMany(mappedBy = "event")
    private Set<Registration> registrations;

    @CreatedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;


    public Event(EventCreateDTO dto) {
        this.name = dto.name();
        this.date = dto.date();
    }

    public EventResponseDTO toDTO() {
        return new EventResponseDTO(id, name, date, createdAt);
    }
}
