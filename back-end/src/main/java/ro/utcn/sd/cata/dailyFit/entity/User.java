package ro.utcn.sd.cata.dailyFit.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    private Integer height; //in cm
    private Float weight; //in kg
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Goal goal;
    private Integer kcals;
    private Integer proteins;
    private Integer carbs;
    private Integer fats;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Diary> diaryList = new ArrayList<>();

    public void addDiary(Diary diary) {
        diaryList.add(diary);
        diary.setUser(this);
    }

    public void removeDiary(Diary diary) {
        diaryList.remove(diary);
        diary.setUser(null);
    }
}
