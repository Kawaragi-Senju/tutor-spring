package ru.daniilboikov.tutorspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.daniilboikov.tutorspring.dto.FoodDTO;
import ru.daniilboikov.tutorspring.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{

    @Query(""" 
             select fds from Food fds
            """)
    Page<Food> findFoods(Pageable pageable);
}

//пагинация