package com.eden.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eden.Service.AppointmentService;
import com.eden.entity.AppointmentEntity;


@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String listAppointments(Model model) {
        List<AppointmentEntity> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "appointment/list";
    }

    @GetMapping("/{id}")
    public String getAppointmentById(@PathVariable Long id, Model model) {
        AppointmentEntity appointment = appointmentService.getAppointmentById(id).orElse(null);
        model.addAttribute("appointment", appointment);
        return "appointment/detail";
    }

    @PostMapping
    public String createAppointment(@ModelAttribute AppointmentEntity appointment) {
        appointmentService.createAppointment(appointment);
        return "redirect:/appointments";
    }

    @PutMapping("/{id}")
    public String updateAppointment(@PathVariable Long id, @ModelAttribute AppointmentEntity appointment) {
        appointment.setId(id);
        appointmentService.updateAppointment(appointment);
        return "redirect:/appointments";
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
