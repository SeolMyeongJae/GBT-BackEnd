package ksafinalproject.gbt.smoking.controller;

import ksafinalproject.gbt.smoking.model.Smoking;
import ksafinalproject.gbt.smoking.service.SmokingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/smoking")
@RequiredArgsConstructor
@Slf4j
public class SmokingController {
    private final SmokingService smokingService;

    @PostMapping("/save")
    public int smokingSave(@RequestBody Smoking smoking) {
        try {
            if (smokingService.saveSmoking(smoking) == null) return 2;
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @PutMapping("/update")
    public int smokingUpdate(@RequestBody Smoking smoking) {
        try {
            if (smokingService.saveSmoking(smoking) == null) return 2;
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @GetMapping("/get/{id}")
    public Optional<Smoking> smokingGetById(@PathVariable Long id) {
        try {
            return smokingService.getSmokingById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/get/all")
    public List<Smoking> smokingGetAll() {
        try{
            return smokingService.getAllSmoking();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/get/user/{userId}")
    public Optional<Smoking> smokingGetByUserId(@PathVariable Long userId) {
        try {
            return smokingService.getSmokingByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }
}
