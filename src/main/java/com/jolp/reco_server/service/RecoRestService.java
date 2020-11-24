package com.jolp.reco_server.service;

import com.jolp.reco_server.model.Reco;
import com.jolp.reco_server.model.RecoResult;
import com.jolp.reco_server.repository.RecoRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

@Component
public class RecoRestService {
    public final RecoRepository recoRepository;

    public RecoRestService(RecoRepository recoRepository) {
        this.recoRepository = recoRepository;
    }

    public Reco getReco(String piwikId) {
        RecoResult recoResult = recoRepository.findByPiwikId(piwikId);
        Reco reco = Reco.builder()
                .id(recoResult.getId())
                .piwikId(recoResult.getPiwikId())
                .itemId(maxFromRecoResult(recoResult.getRecoResult()))
                .build();
        return reco;
    }

    private String maxFromRecoResult(Map<String, Long> recoResult) {
        Optional<Map.Entry<String, Long>> max = recoResult.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        return max.get().getKey();
    }
}
