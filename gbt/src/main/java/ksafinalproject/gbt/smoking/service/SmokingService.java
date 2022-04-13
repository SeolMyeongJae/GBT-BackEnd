package ksafinalproject.gbt.smoking.service;

import ksafinalproject.gbt.smoking.dto.OSmoking;
import ksafinalproject.gbt.smoking.dto.TotalSmoking;
import ksafinalproject.gbt.smoking.dto.ISmoking;

import java.util.List;
import java.util.Optional;

public interface SmokingService {
    int saveSmoking(ISmoking iSmoking);

    int updateSmoking(ISmoking iSmoking, Long id);

    Optional<OSmoking> getSmokingById(Long id);

    Optional<OSmoking> getTodaySmokingByUserId(Long userId);

    List<OSmoking> getAllSmoking();

    int deleteSmokingById(Long id);

    Optional<OSmoking> getSmokingByUserId(Long userId);

    List<OSmoking> getAllSmokingByUserId(Long userId);

    TotalSmoking getSmokingByDate(Long day, Long userId);

    TotalSmoking getSmokingByMonth(Long userId);
}
