package ro.utcn.sd.cata.dailyFit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sd.cata.dailyFit.dto.DiaryDTO;
import ro.utcn.sd.cata.dailyFit.dto.DiaryEntryDTO;
import ro.utcn.sd.cata.dailyFit.service.DiaryService;

import java.sql.Date;


@RestController
@RequestMapping("/diaries")
public class DiaryController {
    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping("/today/{id}")
    public DiaryDTO viewToday(@PathVariable(name = "id") Integer id){
        long millis=System.currentTimeMillis();
        Date date=new Date(millis);
        return diaryService.viewByDate(date,id);
    }

    @GetMapping("/{date}/{id}")
    public DiaryDTO viewByDate(@PathVariable(name = "date") Date date, @PathVariable(name = "id") Integer id){
        return diaryService.viewByDate(date,id);
    }

    @PostMapping("/today")
    public DiaryDTO addToDiary(@RequestBody DiaryEntryDTO diaryEntryDTO){
        return diaryService.addToDiary(diaryEntryDTO);
    }
}
