package ksafinalproject.gbt.proof.controller;

import ksafinalproject.gbt.proof.model.Proof;
import ksafinalproject.gbt.proof.service.ProofService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/proof")
@RequiredArgsConstructor
@Slf4j
public class ProofController {

    private final ProofService proofService;

    @PostMapping("")
    public int proofSave(@RequestBody Proof proof) {
        try {
            return proofService.saveProof(proof);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("")
    public int proofUpdate(@RequestBody Proof proof) {
        try {
            return proofService.saveProof(proof);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<Proof> proofGetById(@PathVariable Long id) {
        try {
            return proofService.getProofById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<Proof> proofGetAll() {
        try {
            return proofService.getAllProof();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int proofDeleteById(@PathVariable Long id) {
        try {
            proofService.deleteProofById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/user/{userId}")
    public List<Proof> proofGetAllByUserId(@PathVariable Long userId) {
        try {
            return proofService.getAllProofByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/challenge/{challengeId}")
    public List<Proof> proofGetAllByChallengeId(@PathVariable Long challengeId) {
        try {
            return proofService.getAllProofByChallengeId(challengeId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

}
