package valleriote.paulo.awesometickets.infra.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import valleriote.paulo.awesometickets.app.dto.http.ResponseDTO;
import valleriote.paulo.awesometickets.app.dto.user.UserCreateDTO;
import valleriote.paulo.awesometickets.app.dto.user.UserResponseDTO;
import valleriote.paulo.awesometickets.app.dto.user.UserUpdateDTO;
import valleriote.paulo.awesometickets.domain.service.user.UserService;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseDTO find(@PathVariable("id") String id) {
        UserResponseDTO user = this.userService.findById(id);

        if (user == null) {
            return new ResponseDTO("User not found", HttpStatus.OK, null);
        }

        return new ResponseDTO(null, HttpStatus.OK, user);
    }

    @GetMapping("/all")
    public ResponseDTO list() {
        Set<UserResponseDTO> userList = this.userService.list();
        return new ResponseDTO(null, HttpStatus.OK, userList);
    }

    @PostMapping
    public ResponseDTO create(@RequestBody UserCreateDTO userDTO) {
        UserResponseDTO user = this.userService.create(userDTO);
        return new ResponseDTO(null, HttpStatus.CREATED, user);
    }

    @PutMapping("/{id}")
    public ResponseDTO update(@PathVariable("id") String id, @RequestBody UserUpdateDTO userDTO) {
        this.userService.update(id, userDTO);
        return new ResponseDTO("User updated", HttpStatus.OK, null);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO delete(@PathVariable("id") String id) {
        this.userService.delete(id);
        return new ResponseDTO("User removed", HttpStatus.OK, null);
    }
}
