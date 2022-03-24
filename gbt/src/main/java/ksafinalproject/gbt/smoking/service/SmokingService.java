package ksafinalproject.gbt.smoking.service;

import ksafinalproject.gbt.smoking.dto.SmokingDto;
import ksafinalproject.gbt.smoking.model.Smoking;

import java.util.List;
import java.util.Optional;

public interface SmokingService {
    int saveSmoking(Smoking smoking);

    Optional<Smoking> getSmokingById(Long id);

    List<Smoking> getAllSmoking();

    void deleteSmokingById(Long id);

    Optional<Smoking> getSmokingByUserId(Long userId);

    List<Smoking> getAllSmokingByUserId(Long userId);

    SmokingDto getSmokingByDate(Long day, Long userId);

    SmokingDto getSmokingByMonth(Long userId);
}
