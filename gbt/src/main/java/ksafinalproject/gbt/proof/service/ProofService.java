package ksafinalproject.gbt.proof.service;

import ksafinalproject.gbt.proof.dto.IProof;
import ksafinalproject.gbt.proof.model.Proof;

import java.util.List;
import java.util.Optional;

public interface ProofService {

    int saveProof(IProof iProof);

    int updateProof(IProof iProof, Long id);

    Optional<Proof> getProofById(Long id);

    List<Proof> getAllProof();

    int deleteProofById(Long id);

    List<Proof> getAllProofByUserId(Long userId);

    List<Proof> getAllProofByChallengeId(Long challengeId);

}
