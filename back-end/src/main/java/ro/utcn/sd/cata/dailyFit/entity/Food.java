package ro.utcn.sd.cata.dailyFit.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Food {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer kcals; //per 100g
    private Float proteins;
    private Float carbs;
    private Float fats;

    @OneToMany(mappedBy = "food")
    private List<DiaryEntry> diaryEntries = new ArrayList<>();


}
