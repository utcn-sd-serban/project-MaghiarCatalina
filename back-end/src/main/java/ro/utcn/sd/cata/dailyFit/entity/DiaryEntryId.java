package ro.utcn.sd.cata.dailyFit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DiaryEntryId implements Serializable {
    @Column(name = "diary_id")
    private Integer diaryId;

    @Column(name = "food_id")
    private Integer foodId;

}
