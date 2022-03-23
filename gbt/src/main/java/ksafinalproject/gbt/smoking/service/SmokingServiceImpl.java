package ksafinalproject.gbt.smoking.service;

import ksafinalproject.gbt.smoking.dto.SmokingDto;
import ksafinalproject.gbt.smoking.model.Smoking;
import ksafinalproject.gbt.smoking.repository.SmokingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmokingServiceImpl implements SmokingService {

    private final SmokingRepository smokingRepository;

    @Override
    public Smoking saveSmoking(Smoking smoking) {
        log.info("save smoking : {} ", smoking);
        try {
            return smokingRepository.save(
                    Smoking.builder()
                            .id(smoking.getId())
                            .count(smoking.getCount())
                            .date(LocalDate.now())
                            .userId(smoking.getUserId())
                            .provider(smoking.getProvider())
                            .build());
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Smoking> getSmokingById(Long id) {
        log.info("get smoking by id : {}", id);
        try {
            return smokingRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Smoking> getAllSmoking() {
        log.info("get all smoking");
        try {
            return smokingRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteSmokingById(Long id) {
        log.info("delete smoking by id");
        try {
            smokingRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
        }
    }

    @Override
    public Optional<Smoking> getSmokingByUserId(Long userId) {
        log.info("find smoking by userid : {}", userId);
        try {
            return smokingRepository.findSmokingByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Smoking> getAllSmokingByUserId(Long userId) {
        return smokingRepository.findAllByUserId(userId);
    }

    @Override
    public SmokingDto getSmokingByDate(Long day, Long userId) {
        List<Smoking> smokingList = smokingRepository.findAllByUserId(userId);
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

    @Override
    public SmokingDto getSmokingByMonth(Long userId) {
        List<Smoking> smokingList = smokingRepository.findAllByUserId(userId);
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
