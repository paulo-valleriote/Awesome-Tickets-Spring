package valleriote.paulo.awesometickets.app.dto.registration;

import valleriote.paulo.awesometickets.app.dto.user.UserResponseDTO;

import java.util.Set;

public record RegistrationListDTO(UserResponseDTO user, Set<EventRegistrationDTO> events) {
}
