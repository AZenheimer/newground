package newground.app.api.user;

import newground.app.api.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  User findById(long id);
}
