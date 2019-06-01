package ro.utcn.sd.cata.dailyFit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class UserReturnDTO {
    private Integer id;
    private String name;
    private Integer kcals;
    private Integer proteins;
    private Integer carbs;
    private Integer fats;
}
