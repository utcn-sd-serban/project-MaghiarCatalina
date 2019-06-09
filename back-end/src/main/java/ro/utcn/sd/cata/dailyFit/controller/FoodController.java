package ro.utcn.sd.cata.dailyFit.controller;

import org.springframework.web.bind.annotation.*;
import ro.utcn.sd.cata.dailyFit.dto.FoodDTO;
import ro.utcn.sd.cata.dailyFit.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/create")
    public FoodDTO createFood(@RequestBody FoodDTO foodDTO){
        return foodService.create(foodDTO);
    }

    @GetMapping("/view-all")
    public List<FoodDTO> viewALL(){
        return foodService.viewAll();
    }

    @GetMapping("/{name}")
    public List<FoodDTO> findByName(@PathVariable(value = "name")String name){
        return foodService.findByName(name);
    }
}
