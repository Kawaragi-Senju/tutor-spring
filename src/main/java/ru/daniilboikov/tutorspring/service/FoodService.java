package ru.daniilboikov.tutorspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.daniilboikov.tutorspring.dto.FoodDTO;
import ru.daniilboikov.tutorspring.mapper.FoodMapper;
import ru.daniilboikov.tutorspring.repository.FoodRepository;
import ru.daniilboikov.tutorspring.entity.Food;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodDTO create(FoodDTO foodDTO){
        Food food = foodMapper.fromDTO(foodDTO);
        return foodMapper.toDto(foodRepository.save(food));
    }

    public FoodDTO getById(Integer id){
        Food food = foodRepository.findById(id).get();
        return foodMapper.toDto(food);
    }
}
