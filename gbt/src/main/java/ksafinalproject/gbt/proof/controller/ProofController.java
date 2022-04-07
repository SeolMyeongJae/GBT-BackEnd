package ksafinalproject.gbt.proof.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.proof.dto.IProof;
import ksafinalproject.gbt.proof.model.Proof;
import ksafinalproject.gbt.proof.service.ProofService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"인증"})
@RestController
@CrossOrigin
@RequestMapping("/api/proof")
@RequiredArgsConstructor
@Slf4j
public class ProofController {

    private final ProofService proofService;

    @PostMapping("")
    public int proofSave(@RequestBody IProof iProof) {
        try {
            return proofService.saveProof(iProof);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("/{id}")
    public int proofUpdate(@RequestBody IProof iProof, @PathVariable Long id) {
        try {
            return proofService.updateProof(iProof, id);
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
            return proofService.deleteProofById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/all/user/{userId}")
    public List<Proof> proofGetAllByUserId(@PathVariable Long userId) {
        try {
            return proofService.getAllProofByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/challenge/{challengeId}")
    public List<Proof> proofGetAllByChallengeId(@PathVariable Long challengeId) {
        try {
            return proofService.getAllProofByChallengeId(challengeId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

}
