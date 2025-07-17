package com.example.learnerservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "EnaaSkills", url = "http://localhost:8081")
public interface CompetenceClient {

    @GetMapping("/competences/brief/{briefId}")
    List<Long> getCompetencesByBriefId(@PathVariable("briefId") Long briefId);
}







