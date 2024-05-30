package com.eden.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eden.entity.AppointmentEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
