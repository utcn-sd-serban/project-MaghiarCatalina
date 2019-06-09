package ro.utcn.sd.cata.dailyFit.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcn.sd.cata.dailyFit.entity.DiaryEntry;

public interface DiaryEntryRepository extends CrudRepository<DiaryEntry, Integer> {
}
