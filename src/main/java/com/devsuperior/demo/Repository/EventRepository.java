package com.devsuperior.demo.Repository;

import com.devsuperior.demo.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
