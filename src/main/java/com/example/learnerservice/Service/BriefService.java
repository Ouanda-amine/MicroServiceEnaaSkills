package com.example.learnerservice.Service;

import com.example.learnerservice.Dto.BriefDTO;
import com.example.learnerservice.Mapper.BriefMapper;
import com.example.learnerservice.Model.Brief;
import com.example.learnerservice.Model.Formateur;
import com.example.learnerservice.Repository.BriefRepo;
import com.example.learnerservice.Repository.FormateurRepo;
import com.example.learnerservice.feign.CompetenceClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class BriefService {

    private final BriefMapper briefMapper;
    private final BriefRepo briefRepo;
    private RestTemplate restTemplate;
    private FormateurRepo formateurRepo;


    @Autowired
    CompetenceClient competenceClient;



    public ResponseEntity<String> getBriefWithCompetences(Long id , String titre , String description , Formateur formateurId ) {
        List<Long> competences = competenceClient.getCompetencesByBriefId(id);
        Brief brief =new Brief();
        brief.setTitre(titre);
        brief.setDescription(description);
        brief.setFormateur(formateurId);
        brief.setCompetencesIds(competences);

        briefRepo.save(brief);

        return new ResponseEntity<>("success" , HttpStatus.CREATED);




    }







    public BriefDTO AddBrief(BriefDTO briefDTO){

        var formateur = formateurRepo.findById(briefDTO.getIdFormateur()).orElse(null);

        var resultat = briefRepo.save(new Brief(null , briefDTO.getTitre() , briefDTO.getDescription() , formateur)) ;

        return briefMapper.ToBriehDto(resultat);
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


}
