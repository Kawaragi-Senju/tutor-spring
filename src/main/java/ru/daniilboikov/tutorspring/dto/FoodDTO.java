package ru.daniilboikov.tutorspring.dto;

import lombok.Data;

@Data
public class FoodDTO {
    private Integer id;
    private String name;
    private Integer categoryId;
    private String description;
}
