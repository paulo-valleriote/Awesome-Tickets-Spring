package valleriote.paulo.awesometickets.domain.service.user;

import valleriote.paulo.awesometickets.app.dto.user.UserCreateDTO;
import valleriote.paulo.awesometickets.app.dto.user.UserResponseDTO;
import valleriote.paulo.awesometickets.app.dto.user.UserUpdateDTO;
import valleriote.paulo.awesometickets.domain.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    UserResponseDTO findById(String id);
    Set<UserResponseDTO> list();
    UserResponseDTO create(UserCreateDTO dto);
    void update(String id, UserUpdateDTO dto);
    void delete(String id);
}
