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

import com.eden.Service.PropertyService;
import com.eden.entity.PropertyEntity;


@Controller
@RequestMapping("/properties")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public String listProperties(Model model) {
        List<PropertyEntity> properties = propertyService.getAllProperties();
        model.addAttribute("properties", properties);
        return "property/list";
    }

    @GetMapping("/{id}")
    public String getPropertyById(@PathVariable Long id, Model model) {
        PropertyEntity property = propertyService.getPropertyById(id).orElse(null);
        model.addAttribute("property", property);
        return "property/detail";
    }

    @PostMapping
    public String createProperty(@ModelAttribute PropertyEntity property) {
        propertyService.createProperty(property);
        return "redirect:/properties";
    }

    @PutMapping("/{id}")
    public String updateProperty(@PathVariable Long id, @ModelAttribute PropertyEntity property) {
        property.setId(id);
        propertyService.updateProperty(property);
        return "redirect:/properties";
    }

    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return "redirect:/properties";
    }
}
