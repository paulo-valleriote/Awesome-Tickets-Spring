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
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private LocalDateTime date;

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
