package com.jolp.reco_server.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
public class Reco {
    @Id public String id;
    public String piwikId;
    public String itemId;

    public Reco() {}
    public Reco(String id, String piwikId, String itemId) {
        this.id = id;
        this.piwikId = piwikId;
        this.itemId = itemId;
    }

}
