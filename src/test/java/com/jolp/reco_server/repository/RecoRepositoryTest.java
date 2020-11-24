package com.jolp.reco_server.repository;

import com.jolp.reco_server.model.Reco;
import com.jolp.reco_server.model.RecoResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RecoRepositoryTest {

    @Autowired
    RecoRepository recoRepository;

    @Test
    public void findByPiwikId() {
        HashMap<String, Long> map = new HashMap<>(1);
        map.put("aaaa", (long) 1);
        RecoResult recoResult = RecoResult.builder()
                        .id("aaaa")
                        .piwikId("aaaa")
                        .recoResult(map)
                        .build();

        recoRepository.save(recoResult);

        RecoResult findByPiwikId = recoRepository.findByPiwikId(recoResult.getPiwikId());
        assertThat(findByPiwikId.getPiwikId()).isEqualTo(recoResult.piwikId);
        assertThat(findByPiwikId.getRecoResult()).isEqualTo(recoResult.recoResult);

    }

}