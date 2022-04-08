package ksafinalproject.gbt.smoking.service;

import ksafinalproject.gbt.smoking.dto.ISmoking;
import ksafinalproject.gbt.smoking.dto.SmokingDto;
import ksafinalproject.gbt.smoking.model.Smoking;
import ksafinalproject.gbt.smoking.repository.SmokingRepository;
import ksafinalproject.gbt.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class SmokingServiceImpl implements SmokingService {

    private final SmokingRepository smokingRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public int saveSmoking(ISmoking iSmoking) {
        log.info("save smoking : {} ", iSmoking);
        List<Smoking> smokingList = smokingRepository.findAllByUserId(iSmoking.getUserId());
        LocalDate now = LocalDate.now();
        try {
            for (int i = 0; i < smokingList.size(); i++) {
                if (smokingList.get(i).getDate().getDayOfYear() == now.getDayOfYear() && smokingList.get(i).getDate().getYear() == now.getYear()) {
                    smokingList.get(i).setCount(smokingList.get(i).getCount() + 1);
                    return 2;
                }
            }
            smokingRepository.save(
                    Smoking.builder()
                            .id(iSmoking.getId())
                            .count(1L)
                            .date(LocalDate.now())
                            .user(userRepository.findById(iSmoking.getUserId()).orElseThrow())
                            .provider(iSmoking.getProvider())
                            .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Transactional
    @Override
    public int updateSmoking(ISmoking iSmoking, Long id) {
        log.info("update smoking : {}, id : {}", iSmoking, id);
        try {
            Smoking smoking2 = smokingRepository.findById(id).orElseThrow();
            smoking2.setCount(iSmoking.getCount());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<Smoking> getSmokingById(Long id) {
        log.info("find smoking by id : {}", id);
        try {
            return smokingRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Smoking> getAllSmoking() {
        log.info("find all smoking");
        try {
            return smokingRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteSmokingById(Long id) {
        log.info("delete smoking by id : {}", id);
        try {
            smokingRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
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
    public Optional<Smoking> getTodaySmokingByUserId(Long userId) {
        log.info("find today smoking by userid : {} ", userId);
        List<Smoking> smokingList = smokingRepository.findAllByUserId(userId);
        LocalDate now = LocalDate.now();
        try {
            for (int i = 0; i < smokingList.size(); i++) {
                if (smokingList.get(i).getDate().isAfter(now.minusDays(1))) {
                    return Optional.ofNullable(smokingList.get(i));
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Smoking> getAllSmokingByUserId(Long userId) {
        log.info("find all smoking by user id {}", userId);
        try {
            return smokingRepository.findAllByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public SmokingDto getSmokingByDate(Long day, Long userId) {
        log.info("find all smoking by day {}, user id {}", day, userId);
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
        log.info("find all this month smoking by user id {}", userId);
        List<Smoking> smokingList = smokingRepository.findAllByUserId(userId);
        List<Smoking> result = new ArrayList<>();
        Long total = 0L;
        SmokingDto smokingDto = new SmokingDto();
        LocalDate now = LocalDate.now();
        try {
            for (int i = 0; i < smokingList.size(); i++) {
                if (smokingList.get(i).getDate().getMonthValue() == now.getMonthValue() && smokingList.get(i).getDate().getYear() == now.getYear()) {
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