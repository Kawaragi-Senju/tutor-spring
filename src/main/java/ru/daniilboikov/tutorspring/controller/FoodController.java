package ru.daniilboikov.tutorspring.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;
import ru.daniilboikov.tutorspring.dto.FoodDTO;
import ru.daniilboikov.tutorspring.dto.FoodUpdateDTO;
import ru.daniilboikov.tutorspring.service.FoodService;

@RestController("/food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;


    @PostMapping("/create")
    @Operation(summary = "Создает объект класса еда")
    public FoodDTO createFood(@RequestBody FoodDTO foodDTO){
        return foodService.create(foodDTO);
    }

    @GetMapping("/get-by-id/{id}")
    @Operation(summary = "Отдает еду по айди")
    public FoodDTO getById(@PathVariable("id") Integer id){
       return foodService.getById(id);
    }

    @GetMapping("/get-all")
    public PagedModel<FoodDTO> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return foodService.getAll(pageable);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable("id")Integer id){
        foodService.deleteById(id);
    }

    @PutMapping("/put-by-id/{id}")
    public FoodDTO updateById(@PathVariable("id")Integer id, @RequestBody FoodUpdateDTO foodUpdateDTO){
        return foodService.updateById(foodUpdateDTO, id);
    }
}
