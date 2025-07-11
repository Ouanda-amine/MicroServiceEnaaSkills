package com.example.learnerservice.Service;

import com.example.learnerservice.Dto.BriefDTO;
import com.example.learnerservice.Mapper.BriefMapper;
import com.example.learnerservice.Model.Brief;
import com.example.learnerservice.Repository.BriefRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class BriefService {
    private final BriefMapper briefMapper;
    private final BriefRepo briefRepo;
    private RestTemplate restTemplate;


    public BriefDTO AddBrief(BriefDTO briefDTO){
        return briefMapper.ToBriehDto(briefRepo.save(briefMapper.ToBriefEntity(briefDTO)));
    }

    public List<BriefDTO> getAllBriefs(){
        return briefRepo.findAll().stream()
                .map(brief->briefMapper.ToBriehDto(brief))
                .toList();

    }

    public BriefDTO UpdateBrief(BriefDTO briefDTO , Long id){
        Brief brief = briefRepo.findById(id).get();
        brief.setTitre(briefDTO.getTitre());
        brief.setDescription(briefDTO.getDescription());
        return briefMapper.ToBriehDto(briefRepo.save(brief));
    }

    public BriefDTO getBriefById(Long id){
        return briefRepo.findById(id).map(briefMapper::ToBriehDto)
                .orElseThrow(()->new RuntimeException("brief not found"));
    }

    public void DeleteBrief(Long id){
        briefRepo.deleteById(id);
    }

    public BriefDTO getBriefWithCompetences(Long briefId) {
        Brief brief = briefRepo.findById(briefId).orElseThrow();

        // Appel REST au service Competence
        String competenceServiceUrl = "http://localhost:8081/competences/byBrief/" + briefId;
        ResponseEntity<List<Competence>> response = restTemplate.exchange(
                competenceServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Competence>>() {}
        );

        brief.setCompetences(response.getBody());
        return briefMapper.ToBriehDto(brief);
    }

}
