package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.services.ServiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class ControlerEvent {

    @Autowired
    private ServiceEvent serviceEvent;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents(){
        List<EventDTO> event = serviceEvent.findAll();
        return ResponseEntity.ok().body(event);
    }

    @PutMapping("/{id}")
    public EventDTO update(@PathVariable Long id, @RequestBody EventDTO eventDTO){
        EventDTO event = serviceEvent.update(id, eventDTO);
        return event;
    }

}
