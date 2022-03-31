package ksafinalproject.gbt.proof.service;

import ksafinalproject.gbt.proof.model.Proof;
import ksafinalproject.gbt.proof.repository.ProofRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProofServiceImpl implements ProofService {

    private final ProofRepository proofRepository;

    @Override
    public int saveProof(Proof proof) {
        log.info("save proof : {}", proof);
        try {
            proofRepository.save(Proof.builder()
                    .content(proof.getContent())
                    .date(LocalDateTime.now())
                    .userId(proof.getUserId())
                    .challengeId(proof.getChallengeId())
                    .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<Proof> getProofById(Long id) {
        log.info("find proof by id : {}", id);
        try {
            return proofRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Proof> getAllProof() {
        log.info("find all proof");
        try {
            return proofRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteProofById(Long id) {
        log.info("delete proof by id : {}", id);
        try {
            proofRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
        }
    }

    @Override
    public List<Proof> getAllProofByUserId(Long userId) {
        log.info("find all proof by user id : {}", userId);
        try {
            return proofRepository.findAllByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Proof> getAllProofByChallengeId(Long challengeId) {
        log.info("find all proof by challenge id : {}", challengeId);
        try {
            return proofRepository.findAllByChallengeId(challengeId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
