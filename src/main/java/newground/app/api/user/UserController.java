package newground.app.api.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import newground.app.api.user.dtos.UserResponseDTO;
import newground.app.api.user.service.UserService;
import newground.app.api.user.dtos.UserRequestDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "User related operations.")
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Operation(summary = "Create a User")
  @PostMapping(headers = {
      "content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponseDTO> createUser(
      @RequestBody UserRequestDTO userRequestDTO) {
    UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
    return ResponseEntity.ok(userResponseDTO);
  }

  @GetMapping(value = "/{userId}")
  public ResponseEntity<UserResponseDTO> findUserById(@PathVariable String userId)
      throws Exception {
    UserResponseDTO userResponseDTO = userService.findUserById(userId);
    return ResponseEntity.ok(userResponseDTO);
  }
}
