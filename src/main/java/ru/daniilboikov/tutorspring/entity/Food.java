package ru.daniilboikov.tutorspring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "food", schema = "foodshop")
@Data
public class Food {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "description")
    private String description;
}
