package com.eden.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eden.Repository.AppointmentRepository;
import com.eden.entity.AppointmentEntity;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<AppointmentEntity> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public AppointmentEntity createAppointment(AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }

    public AppointmentEntity updateAppointment(AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
