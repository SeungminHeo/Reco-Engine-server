package com.jolp.reco_server.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import java.util.Map;

@Getter
@Setter
@Builder
public class RecoResult {
    @Id public String id;
    public final String piwikId;
    public final Map<String, Long> recoResult;

    public RecoResult(String id, String piwikId, Map<String, Long> recoResult) {
        this.id = id;
        this.piwikId = piwikId;
        this.recoResult = recoResult;
    }
}
