package ksafinalproject.gbt.smoking.controller;

import ksafinalproject.gbt.smoking.dto.SmokingDto;
import ksafinalproject.gbt.smoking.model.Smoking;
import ksafinalproject.gbt.smoking.service.SmokingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
        try {
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

    @GetMapping("/get/date/{day}/{userId}")
    public SmokingDto smokingGetByDate(@PathVariable Long day, @PathVariable Long userId) {
        List<Smoking> smokingList = smokingService.getAllSmokingByUserId(userId);
        List<Smoking> result = new ArrayList<>();
        Long total = 0L;
        SmokingDto smokingDto = new SmokingDto();
        LocalDate now = LocalDate.now();
        try {
            for (int i = 0; i < smokingList.size(); i++) {
                if (smokingList.get(i).getDate().isAfter(now.minusDays(day))) {
                    result.add(smokingList.get(i));
                    total += smokingList.get(i).getCount();
                }
            }
            smokingDto.setSmokingList(result);
            smokingDto.setTotal(total);
            return smokingDto;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }

    }

    @GetMapping("/get/date/month/{userId}")
    public SmokingDto smokingGetByDateMonth(@PathVariable Long userId) {
        List<Smoking> smokingList = smokingService.getAllSmokingByUserId(userId);
        List<Smoking> result = new ArrayList<>();
        Long total = 0L;
        SmokingDto smokingDto = new SmokingDto();
        LocalDate now = LocalDate.now();
        try {
            for (int i = 0; i < smokingList.size(); i++) {
                if (smokingList.get(i).getDate().getMonthValue() == now.getMonthValue()) {
                    result.add(smokingList.get(i));
                    total += smokingList.get(i).getCount();
                }
            }
            smokingDto.setSmokingList(result);
            smokingDto.setTotal(total);
            return smokingDto;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}