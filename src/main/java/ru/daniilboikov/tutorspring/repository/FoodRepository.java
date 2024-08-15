package ru.daniilboikov.tutorspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.daniilboikov.tutorspring.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{
}
