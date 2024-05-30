package com.eden.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eden.entity.PropertyEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
}
