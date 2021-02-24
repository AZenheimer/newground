package newground.app.api.user.service;

import newground.app.api.user.dtos.UserRequestDTO;
import newground.app.api.user.dtos.UserResponseDTO;

public interface UserService {

  UserResponseDTO createUser(UserRequestDTO userRequestDTO);

  UserResponseDTO findUserById(String userId) throws Exception;
}
