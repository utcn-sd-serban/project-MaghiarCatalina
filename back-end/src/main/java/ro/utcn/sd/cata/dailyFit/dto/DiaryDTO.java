package ro.utcn.sd.cata.dailyFit.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class DiaryDTO {
    private Integer totalKcal;
    private Integer totalProteins;
    private Integer totalCarbs;
    private Integer totalFats;
    private Date date;
}
