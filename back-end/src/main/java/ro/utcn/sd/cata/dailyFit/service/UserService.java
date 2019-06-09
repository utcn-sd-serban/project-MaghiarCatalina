package ro.utcn.sd.cata.dailyFit.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.cata.dailyFit.dto.UserCreateDTO;
import ro.utcn.sd.cata.dailyFit.dto.UserLoginDTO;
import ro.utcn.sd.cata.dailyFit.dto.UserResultsDTO;
import ro.utcn.sd.cata.dailyFit.dto.UserReturnDTO;
import ro.utcn.sd.cata.dailyFit.entity.Gender;
import ro.utcn.sd.cata.dailyFit.entity.Goal;
import ro.utcn.sd.cata.dailyFit.entity.User;
import ro.utcn.sd.cata.dailyFit.exception.GenderNotFoundException;
import ro.utcn.sd.cata.dailyFit.exception.UserNotFoundException;
import ro.utcn.sd.cata.dailyFit.repository.UserRepository;

@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserService(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserReturnDTO create(UserCreateDTO userCreateDTO) {
        UserReturnDTO created = new UserReturnDTO();
        UserResultsDTO userResultsDTO = calculateCaloriesAndMacros(userCreateDTO);
        User createdUser = new User();
        modelMapper.map(userCreateDTO, createdUser);
        modelMapper.map(userResultsDTO, createdUser);
        modelMapper.map(userRepository.save(createdUser), created);
        return created;
    }

    private UserResultsDTO calculateCaloriesAndMacros(UserCreateDTO userCreateDTO) {

        Double calories;
        Double proteins, carbs, fats;
        if (userCreateDTO.getGender().equals(Gender.FEMALE)) {
            calories = (9.247 * userCreateDTO.getWeight() + 3.098 * userCreateDTO.getHeight() - 4.33 * userCreateDTO.getAge() + 447.593) * 1.35;
        } else if (userCreateDTO.getGender().equals(Gender.MALE)) {
            calories = (13.397 * userCreateDTO.getWeight() + 4.799 * userCreateDTO.getHeight() - 5.677 * userCreateDTO.getAge() + 88.362) * 1.35;
        } else {
            throw new GenderNotFoundException();
        }

        if (userCreateDTO.getGoal().equals(Goal.CUT)) {
            calories -= 0.2 * calories;
        } else if (userCreateDTO.getGoal().equals(Goal.BUILD)) {
            calories += +0.2 * calories;
        }
        proteins = 2.0 * userCreateDTO.getWeight();
        fats = 0.8 * userCreateDTO.getWeight();
        carbs = (calories - proteins * 4 - fats * 9) / 4;
        return new UserResultsDTO(calories.intValue(), proteins.intValue(), carbs.intValue(), fats.intValue());
    }

    @Transactional
    public UserReturnDTO findByNameAndPassword(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByNameAndPassword(userLoginDTO.getName(), userLoginDTO.getPassword())
                .orElseThrow(UserNotFoundException::new);
        UserReturnDTO userReturnDTO = new UserReturnDTO();
        modelMapper.map(user, userReturnDTO);
        return userReturnDTO;
    }
}
