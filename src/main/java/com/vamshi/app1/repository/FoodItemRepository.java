package com.vamshi.app1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vamshi.app1.model.FoodItem;
@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long>{

}
