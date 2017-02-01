package con.self.exercise.db.generate.runner;

import con.self.exercise.db.generate.dao.UserDao;
import con.self.exercise.db.generate.model.User;
import con.self.exercise.db.generate.util.NamesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by prime23 on 1/31/17.
 */
@Component
public class GenerateNoise implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(GenerateNoise.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... strings) throws Exception {
        List<String> firstNames = NamesUtil.firstNames();
        List<String> lastName = NamesUtil.lastNames();
        for(int i = 0; i < 1000; ++i) {
            Collections.shuffle(firstNames);
            Collections.shuffle(lastName);
            userDao.save(new User(firstNames.get(0), lastName.get(0), UUID.randomUUID()));
        }
    }
}
