package com.eden.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eden.Repository.PropertyRepository;
import com.eden.entity.PropertyEntity;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<PropertyEntity> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Optional<PropertyEntity> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    public PropertyEntity createProperty(PropertyEntity property) {
        return propertyRepository.save(property);
    }

    public PropertyEntity updateProperty(PropertyEntity property) {
        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
