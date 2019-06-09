package ro.utcn.sd.cata.dailyFit.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcn.sd.cata.dailyFit.entity.Diary;
import ro.utcn.sd.cata.dailyFit.entity.User;

import java.sql.Date;
import java.util.Optional;

public interface DiaryRepository extends CrudRepository<Diary, Integer> {

    Optional<Diary> findByDateAndUser(Date date, User user);
}
