package newground.app.api.user.service;

import newground.app._sequencegenerator.SequenceGeneratorService;
import newground.app.api.user.UserRepository;
import newground.app.api.user.dtos.UserRequestDTO;
import newground.app.api.user.dtos.UserResponseDTO;
import newground.app.api.user.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final static String ERR_MSG_USER_NOT_FOUND = "User with given user id not found in database";

  private final UserRepository userRepository;

  private final SequenceGeneratorService sequenceGeneratorService;

  public UserServiceImpl(UserRepository userRepository,
      SequenceGeneratorService sequenceGeneratorService) {
    this.userRepository = userRepository;
    this.sequenceGeneratorService = sequenceGeneratorService;
  }

  @Override
  public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
    User newUser = User.builder()
        .id(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME))
        .name(userRequestDTO.getName())
        .lastName(userRequestDTO.getLastName())
        .build();

    userRepository.save(newUser);

    return UserResponseDTO.builder().userId(String.valueOf(newUser.getId())).build();
  }

  @Override
  public UserResponseDTO findUserById(String userId) throws Exception {
    User user = userRepository.findById(Long.parseLong(userId));
    if (user == null) {
      throw new Exception(ERR_MSG_USER_NOT_FOUND);
    }

    return UserResponseDTO.builder()
        .userId(userId)
        .lastName(user.getLastName())
        .name(user.getName())
        .build();
  }
}
