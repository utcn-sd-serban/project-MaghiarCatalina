package ro.utcn.sd.cata.dailyFit.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.cata.dailyFit.dto.FoodDTO;
import ro.utcn.sd.cata.dailyFit.entity.Food;
import ro.utcn.sd.cata.dailyFit.exception.FoodNotFoundException;
import ro.utcn.sd.cata.dailyFit.repository.FoodRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final ModelMapper modelMapper;

    @Autowired

    public FoodService(FoodRepository foodRepository, ModelMapper modelMapper) {
        this.foodRepository = foodRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public FoodDTO create(FoodDTO dto) {
        Food food = new Food();
        food.setId(null);
        modelMapper.map(dto, food);
        FoodDTO created = new FoodDTO();
        Food saved = foodRepository.save(food);
        modelMapper.map(saved, created);
        return created;
    }

    @Transactional
    public List<FoodDTO> viewAll() {
        List<FoodDTO> foodDTOS = new ArrayList<>();
        Iterator iterator = foodRepository.findAll().iterator();
       while (iterator.hasNext()){
           FoodDTO dto = new FoodDTO();
           modelMapper.map(iterator.next(),dto);
           foodDTOS.add(dto);
       }
       return foodDTOS;
    }

    @Transactional
    public List<FoodDTO> findByName(String name){
        List<FoodDTO> foodDTOS = new ArrayList<>();
        List<Food> foods = foodRepository.findByName(name);
        for(Food food:foods){
            FoodDTO foodDTO = new FoodDTO();
            modelMapper.map(food,foodDTO);
            foodDTOS.add(foodDTO);
        }
        return foodDTOS;
    }

    @Transactional
    public void deleteFood(Integer id){
         foodRepository.deleteById(id);
    }
}
