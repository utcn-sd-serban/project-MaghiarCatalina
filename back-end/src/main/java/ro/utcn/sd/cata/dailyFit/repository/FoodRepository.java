package ro.utcn.sd.cata.dailyFit.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcn.sd.cata.dailyFit.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends CrudRepository<Food, Integer> {

    List<Food> findByName(String name);
}
