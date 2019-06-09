package ro.utcn.sd.cata.dailyFit.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.cata.dailyFit.dto.DiaryDTO;
import ro.utcn.sd.cata.dailyFit.dto.DiaryEntryDTO;
import ro.utcn.sd.cata.dailyFit.entity.Diary;
import ro.utcn.sd.cata.dailyFit.entity.DiaryEntry;
import ro.utcn.sd.cata.dailyFit.entity.Food;
import ro.utcn.sd.cata.dailyFit.entity.User;
import ro.utcn.sd.cata.dailyFit.exception.DiaryNotFoundException;
import ro.utcn.sd.cata.dailyFit.exception.UserNotFoundException;
import ro.utcn.sd.cata.dailyFit.repository.DiaryEntryRepository;
import ro.utcn.sd.cata.dailyFit.repository.DiaryRepository;
import ro.utcn.sd.cata.dailyFit.repository.FoodRepository;
import ro.utcn.sd.cata.dailyFit.repository.UserRepository;

import java.sql.Date;


@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final DiaryEntryRepository diaryEntryRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository, UserRepository userRepository, FoodRepository foodRepository,
                        ModelMapper modelMapper, DiaryEntryRepository diaryEntryRepository) {
        this.diaryRepository = diaryRepository;
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
        this.modelMapper = modelMapper;
        this.diaryEntryRepository = diaryEntryRepository;
    }

    @Transactional
    public DiaryDTO viewByDate(Date date, Integer user){
        User currentUser = userRepository.findById(user).orElseThrow(UserNotFoundException::new);
        Diary diary = diaryRepository.findByDateAndUser(date, currentUser).orElseThrow(DiaryNotFoundException::new);
        DiaryDTO diaryDTO = new DiaryDTO();
        modelMapper.map(diary,diaryDTO);
        return diaryDTO;
    }

    @Transactional
    public DiaryDTO addToDiary(DiaryEntryDTO diaryEntryDTO){
        DiaryDTO returnDTO = new DiaryDTO();
        long millis=System.currentTimeMillis();
        Date today=new Date(millis);
        Food food = foodRepository.findByName(diaryEntryDTO.getFoodName()).get(0);
        User user = userRepository.findById(diaryEntryDTO.getUserId()).orElseThrow(UserNotFoundException::new);
        if(diaryRepository.findByDateAndUser(today, user).isPresent()){
            Diary todayDiary = diaryRepository.findByDateAndUser(today,user).orElseThrow(DiaryNotFoundException::new);
            Integer totalKcal = diaryEntryDTO.getQuantity()*food.getKcals()/100 + todayDiary.getTotalKcal();
            Integer totalProteins = Math.round(diaryEntryDTO.getQuantity()*food.getProteins()/100 + todayDiary.getTotalProteins());
            Integer totalCarbs =  Math.round(diaryEntryDTO.getQuantity()*food.getCarbs()/100 + todayDiary.getTotalCarbs());
            Integer totalFats =  Math.round(diaryEntryDTO.getQuantity()*food.getFats()/100 + todayDiary.getTotalFats());
            todayDiary.setTotalKcal(totalKcal);
            todayDiary.setTotalProteins(totalProteins);
            todayDiary.setTotalCarbs(totalCarbs);
            todayDiary.setTotalFats(totalFats);
            Diary updatedDiary = diaryRepository.save(todayDiary);
            updatedDiary.addDiaryEntry(food,diaryEntryDTO.getQuantity());
            DiaryEntry diaryEntry = new DiaryEntry(updatedDiary,food,diaryEntryDTO.getQuantity());
            diaryEntryRepository.save(diaryEntry);
            modelMapper.map(updatedDiary,returnDTO);
        }
        else{
            Diary diary = new Diary();
            diary.setUser(user);
            diary.setDate(today);
            diary.setTotalKcal(diaryEntryDTO.getQuantity()*food.getKcals()/100);
            diary.setTotalProteins(Math.round(diaryEntryDTO.getQuantity()*food.getProteins()/100));
            diary.setTotalCarbs(Math.round(diaryEntryDTO.getQuantity()*food.getCarbs()/100));
            diary.setTotalFats(Math.round(diaryEntryDTO.getQuantity()*food.getFats()/100));
            Diary savedDiary = diaryRepository.save(diary);
            user.addDiary(savedDiary);
            DiaryEntry diaryEntry = new DiaryEntry(savedDiary,food,diaryEntryDTO.getQuantity());
            diaryEntryRepository.save(diaryEntry);
            modelMapper.map(savedDiary,returnDTO);
        }
        return returnDTO;
    }
}
