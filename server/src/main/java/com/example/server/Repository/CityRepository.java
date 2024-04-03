package com.example.server.Repository;

import com.example.server.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "select City from City", nativeQuery = true)
    List<City> getAllCity();


//    @Query("SELECT ct FROM City as ct WHERE ct.id = :id")
//    City findCityId(@Param("id") Long id);

    @Query("SELECT ct FROM City as ct WHERE ct.id = :id")
    City findCityId(@Param("id") Long id);

    City getById(Long id);
}
