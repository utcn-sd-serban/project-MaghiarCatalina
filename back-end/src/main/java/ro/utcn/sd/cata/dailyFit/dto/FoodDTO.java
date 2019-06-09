package ro.utcn.sd.cata.dailyFit.dto;

import lombok.Data;

@Data
public class FoodDTO {
    private String name;
    private Integer kcals;
    private Float proteins;
    private Float carbs;
    private Float fats;
}
