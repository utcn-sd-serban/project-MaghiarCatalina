package ro.utcn.sd.cata.dailyFit.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Entity
@Data
public class Diary {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer totalKcal;
    private Integer totalProteins;
    private Integer totalCarbs;
    private Integer totalFats;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "diary")
    private List<DiaryEntry> diaryEntries = new ArrayList<>();


    public void addDiaryEntry(Food food, Integer quantity) {
        DiaryEntry diarEntry = new DiaryEntry(this,food,quantity);
        diaryEntries.add(diarEntry);
        food.getDiaryEntries().add(diarEntry);
    }

    public void removeDiaryEntry(Food food) {
        for (Iterator<DiaryEntry> iterator = diaryEntries.iterator();
             iterator.hasNext(); ) {
            DiaryEntry diaryEntrie = iterator.next();

            if (diaryEntrie.getDiary().equals(this) &&
                    diaryEntrie.getFood().equals(food)) {
                iterator.remove();
                diaryEntrie.getFood().getDiaryEntries().remove(diaryEntrie);
                diaryEntrie.setDiary(null);
                diaryEntrie.setFood(null);
            }
        }
    }

}
