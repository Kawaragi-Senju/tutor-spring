package ru.daniilboikov.tutorspring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "food", schema = "assortment")
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

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "update_on")
    private Date updatedOn;
}
