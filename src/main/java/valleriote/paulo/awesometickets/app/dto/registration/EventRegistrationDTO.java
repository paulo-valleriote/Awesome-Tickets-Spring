package valleriote.paulo.awesometickets.app.dto.registration;

import valleriote.paulo.awesometickets.app.dto.event.EventResponseDTO;

public record EventRegistrationDTO(String registrationId, EventResponseDTO event) {
}
