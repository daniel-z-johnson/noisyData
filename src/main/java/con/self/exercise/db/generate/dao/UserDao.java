package con.self.exercise.db.generate.dao;

import con.self.exercise.db.generate.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by prime23 on 1/31/17.
 */
public interface UserDao extends CrudRepository<User, Long> {
}
