package ru.daniilboikov.tutorspring.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.daniilboikov.tutorspring.dto.FoodDTO;
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
}
