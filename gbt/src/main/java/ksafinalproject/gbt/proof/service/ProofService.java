package ksafinalproject.gbt.proof.service;

import ksafinalproject.gbt.proof.model.Proof;

import java.util.List;
import java.util.Optional;

public interface ProofService {

    int saveProof(Proof proof);

    Optional<Proof> getProofById(Long id);

    List<Proof> getAllProof();

    int deleteProofById(Long id);

    List<Proof> getAllProofByUserId(Long userId);

    List<Proof> getAllProofByChallengeId(Long challengeId);

}
