package newground.app.api.user.models;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User {

  @Transient
  public static final String SEQUENCE_NAME = "users_sequence";

  @Id
  long id;

  @NotNull String name;

  @NotNull String lastName;
}
