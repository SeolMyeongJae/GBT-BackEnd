package ksafinalproject.gbt.smoking.controller;

import ksafinalproject.gbt.smoking.dto.SmokingDto;
import ksafinalproject.gbt.smoking.model.Smoking;
import ksafinalproject.gbt.smoking.service.SmokingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/smoking")
@RequiredArgsConstructor
@Slf4j
public class SmokingController {
    private final SmokingService smokingService;

    @PostMapping("")
    public int smokingSave(@RequestBody Smoking smoking) {
        try {
            return smokingService.saveSmoking(smoking);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("")
    public int smokingUpdate(@RequestBody Smoking smoking) {
        try {
            return smokingService.saveSmoking(smoking);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<Smoking> smokingGetById(@PathVariable Long id) {
        try {
            return smokingService.getSmokingById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<Smoking> smokingGetAll() {
        try {
            return smokingService.getAllSmoking();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/today/{userId}")
    public Optional<Smoking> smokingTodayGetByUserId(@PathVariable Long userId) {
        try {
            return smokingService.getTodaySmokingByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/user/{userId}")
    public List<Smoking> smokingGetAllByUserId(@PathVariable Long userId) {
        try {
            return smokingService.getAllSmokingByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/{day}/{userId}")
    public SmokingDto smokingGetByDate(@PathVariable Long day, @PathVariable Long userId) {
        try {
            return smokingService.getSmokingByDate(day, userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }

    }

    @GetMapping("/this-month/{userId}")
    public SmokingDto smokingGetByDateMonth(@PathVariable Long userId) {
        try{
            return smokingService.getSmokingByMonth((userId));
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}