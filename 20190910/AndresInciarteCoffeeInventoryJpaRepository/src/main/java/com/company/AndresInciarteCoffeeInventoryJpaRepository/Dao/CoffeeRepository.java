package com.company.AndresInciarteCoffeeInventoryJpaRepository.Dao;

import com.company.AndresInciarteCoffeeInventoryJpaRepository.Dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

// find Coffees by Roaster, Coffees by Type, and Coffees by Roaster and Type.
    List<Coffee> findByRoaster(Integer roasterId);

    List<Coffee> findByType(String type);

    List<Coffee> findByRoasterAndType(Integer roasterId, String type);

}
