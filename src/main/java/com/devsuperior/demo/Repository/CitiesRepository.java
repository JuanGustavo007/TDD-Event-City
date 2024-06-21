package com.devsuperior.demo.Repository;

import com.devsuperior.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<City, Long> {
}
