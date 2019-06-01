package ro.utcn.sd.cata.dailyFit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
public class DiaryEntry {

    @EmbeddedId
    private DiaryEntryId diaryEntryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("diaryId")
    private Diary diary;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodId")
    private Food food;

    private Integer quantity; //in grams

    public DiaryEntry(Diary diary,Food food,Integer quantity){
        this.diary=diary;
        this.food=food;
        this.diaryEntryId = new DiaryEntryId(diary.getId(),food.getId());
        this.quantity = quantity;
    }
}
