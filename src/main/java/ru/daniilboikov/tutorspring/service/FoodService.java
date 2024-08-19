package ru.daniilboikov.tutorspring.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import ru.daniilboikov.tutorspring.dto.FoodDTO;
import ru.daniilboikov.tutorspring.dto.FoodUpdateDTO;
import ru.daniilboikov.tutorspring.mapper.FoodMapper;
import ru.daniilboikov.tutorspring.repository.FoodRepository;
import ru.daniilboikov.tutorspring.entity.Food;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;
    private final ObjectMapper objectMapper;

    public FoodDTO create(FoodDTO foodDTO){
        Food food = foodMapper.fromDTO(foodDTO);
        return foodMapper.toDto(foodRepository.save(food));
    }

    public FoodDTO getById(Integer id){
        Food food = foodRepository.findById(id).get();
        return foodMapper.toDto(food);
    }

    public PagedModel<FoodDTO> getAll(Pageable pageable){
        Page<Food> food = foodRepository.findFoods(pageable);
        if (!food.isEmpty()){
            PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
                    pageable.getPageSize(),
                    pageable.getPageNumber(),
                    food.getTotalElements(),
                    food.getTotalPages());
            return PagedModel.of(foodMapper.toDTOList(food.getContent()), metadata);
        }
        return PagedModel.empty();
    }

    public void deleteById(Integer id){
        foodRepository.deleteById(id);
    }

    public FoodDTO updateById(FoodUpdateDTO foodUpdateDTO, Integer id){
        Food food = foodRepository.findById(id).get();
        try {
            objectMapper.updateValue(food, foodUpdateDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }
        return foodMapper.toDto(foodRepository.save(food));
    }

}
// metadata - доп инфа сверху