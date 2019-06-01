package ro.utcn.sd.cata.dailyFit.dto;

import lombok.Data;
import ro.utcn.sd.cata.dailyFit.entity.Gender;
import ro.utcn.sd.cata.dailyFit.entity.Goal;

@Data
public class UserCreateDTO {
    private String name;
    private String  password;
    private Integer height; //in cm
    private Float weight; //in kg
    private Integer age;
    private Gender gender;
    private Goal goal;
}
