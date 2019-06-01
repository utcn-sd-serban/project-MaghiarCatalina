package ro.utcn.sd.cata.dailyFit.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcn.sd.cata.dailyFit.entity.Food;

public interface FoodRepository extends CrudRepository<Food,Integer> {
}
