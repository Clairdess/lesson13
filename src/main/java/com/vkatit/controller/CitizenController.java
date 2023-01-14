package com.vkatit.controller;


import com.vkatit.model.Citizen;
import com.vkatit.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @GetMapping("/citizens")
    public List<Citizen> getFirst10Citizens() {
        return citizenService.getFirst10Citizens();
    }

    @GetMapping("/citizens/{citizenId}")
    public Citizen getCitizenById(@PathVariable Long citizenId) {
        return citizenService.getCitizenById(citizenId);
    }
}
