package com.company.AndresInciarteCarLotJpaRepository.Dao;


import com.company.AndresInciarteCarLotJpaRepository.Dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {

    //make
    List<Car> findByMake(String make);
    //color
    List<Car> findByColor(String color);
    //make and color
    List<Car> findByMakeAndColor(String make, String color);
    //get by id
//    Car findById(Integer id);

//    @Modifying
//    @Query("update User u set u.firstname = ?1 where u.lastname = ?2")
//    int setFixedFirstnameFor(String firstname, String lastname);
//    String setFixedMakeFor(String make, String newMake);
//    String setFixedModelFor(String model, String newModel);
//    String setFixedYearFor(String year, String newYear);
//    String setFixedColorFor(String color, String newColor);
//    Integer setFixedIdFor(Integer id, Integer newId);

//    @Modifying
//    @Query("delete from car where id = ?1")
//    void deleteCarById(Integer id);
}
