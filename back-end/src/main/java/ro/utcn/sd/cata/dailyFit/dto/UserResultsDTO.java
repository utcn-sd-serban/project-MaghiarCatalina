package ro.utcn.sd.cata.dailyFit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResultsDTO {

    private Integer kcals;
    private Integer proteins;
    private Integer carbs;
    private Integer fats;
}
