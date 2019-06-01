package ro.utcn.sd.cata.dailyFit.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcn.sd.cata.dailyFit.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

     Optional<User> findByNameAndPassword(String name, String password);

    Optional<User> findByUsername(String username);
}
