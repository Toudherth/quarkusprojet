package org.acme.entity;

public class CandidatOffre {

    private Long candidatId;

    private Long offreId;

    public CandidatOffre(Long candidatId, Long offreId) {
        this.candidatId = candidatId;
        this.offreId = offreId;
    }

    public Long getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(Long candidatId) {
        this.candidatId = candidatId;
    }

    public Long getOffreId() {
        return offreId;
    }

    public void setOffreId(Long offreId) {
        this.offreId = offreId;
    }
}
