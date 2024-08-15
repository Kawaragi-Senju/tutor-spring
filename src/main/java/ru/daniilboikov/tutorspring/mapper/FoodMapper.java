package ru.daniilboikov.tutorspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Configuration;
import ru.daniilboikov.tutorspring.dto.FoodDTO;
import ru.daniilboikov.tutorspring.entity.Food;


@Configuration
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FoodMapper {
    Food fromDTO(FoodDTO foodDTO);
    FoodDTO toDto(Food food);
}
