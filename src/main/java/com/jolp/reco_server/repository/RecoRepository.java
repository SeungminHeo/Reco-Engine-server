package com.jolp.reco_server.repository;
import com.jolp.reco_server.model.RecoResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface RecoRepository extends MongoRepository<RecoResult, String>{
    RecoResult findByPiwikId(String piwikId);
}

