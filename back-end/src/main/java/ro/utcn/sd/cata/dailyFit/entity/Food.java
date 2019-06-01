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
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer name;
    private Integer kcal;
    private Integer protein;
    private Integer carbs;
    private Integer fats;

    @OneToMany(mappedBy = "food")
    private List<DiaryEntry> diaryEntries = new ArrayList<>();


}
