package ro.utcn.sd.cata.dailyFit.dto;

import lombok.Data;

@Data
public class DiaryEntryDTO {
    private String foodName;
    private Integer quantity;
    private Integer userId;
}
