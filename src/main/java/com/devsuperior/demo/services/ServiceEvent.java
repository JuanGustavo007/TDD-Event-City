package com.devsuperior.demo.services;

import com.devsuperior.demo.Repository.EventRepository;
import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceEvent {

    @Autowired
    private EventRepository repository;

    @Transactional
    public EventDTO update(Long id, EventDTO eventDTO){
        Event event = repository.getReferenceById(id);
        event.setName(eventDTO.getName());
        event.setDate(eventDTO.getDate());
        event.setUrl(eventDTO.getUrl());
        event.setCity(new City(eventDTO.getCityId(), null));
        event = repository.save(event);
        return new EventDTO(event);
    }

    @Transactional
    public List<EventDTO> findAll(){
        List<Event> list = repository.findAll();
        return list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
    }
}
