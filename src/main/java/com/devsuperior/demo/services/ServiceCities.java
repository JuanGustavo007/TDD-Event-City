package com.devsuperior.demo.services;

import com.devsuperior.demo.Repository.CitiesRepository;
import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceCities {

    @Autowired
    private CitiesRepository repository;


    @Transactional
    public List<CityDTO> findAll() {
        List<City> cityDTO = repository.findAll(Sort.by("name"));
        return cityDTO.stream().map(x -> new CityDTO(x)).toList();
    }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CityDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Id not found " + id);
        }else {
            repository.deleteById(id);
        }

    }
}
