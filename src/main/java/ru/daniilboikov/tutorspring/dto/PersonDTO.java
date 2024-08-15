package ru.daniilboikov.tutorspring.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PersonDTO {
    @Schema(description = "имя персона", example = "Эклер")
    private String name;
    @Schema(description = "фамилия персона", example = "Козявкин")
    private String surname;
    @Schema(description = "возраст персона", example = "12")
    private Integer age;
}
