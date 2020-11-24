package com.jolp.reco_server.controller;

import com.jolp.reco_server.model.Reco;
import com.jolp.reco_server.service.RecoRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1/reco", produces = "application/json")
public class RecoRestController {
    public final RecoRestService recoRestService;

    public RecoRestController(RecoRestService recoRestService) {
        this.recoRestService = recoRestService;
    }

    @GetMapping(path = "/Reco/{piwikId}")
    public ResponseEntity<Reco> getReco(@PathVariable(value = "piwikId") String piwikId) {
        Reco reco = recoRestService.getReco(piwikId);
        return ResponseEntity.ok(reco);
    }
}
