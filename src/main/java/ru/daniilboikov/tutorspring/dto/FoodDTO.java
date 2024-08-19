package ru.daniilboikov.tutorspring.dto;

import lombok.Data;
import java.sql.Date;

@Data
public class FoodDTO {
    private Integer id;
    private String name;
    private Integer categoryId;
    private String description;
    private Date createDate;
    private Date updateDate;
}
