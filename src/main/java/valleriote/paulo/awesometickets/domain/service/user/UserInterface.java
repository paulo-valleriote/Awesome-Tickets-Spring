package valleriote.paulo.awesometickets.domain.service.user;

import valleriote.paulo.awesometickets.app.dto.user.UserCreateDTO;
import valleriote.paulo.awesometickets.app.dto.user.UserUpdateDTO;
import valleriote.paulo.awesometickets.domain.entity.User;

import java.util.List;

public interface UserInterface {
    User findById(String id);
    List<User> list();
    void create(UserCreateDTO dto);
    void update(String id, UserUpdateDTO dto);
    void delete(String id);
}
