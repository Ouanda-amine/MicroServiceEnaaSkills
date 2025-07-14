package com.example.learnerservice.Controller;

import com.example.learnerservice.Dto.BriefDTO;
import com.example.learnerservice.Dto.CompetenceDto;
import com.example.learnerservice.Model.Brief;
import com.example.learnerservice.Repository.BriefRepo;
import com.example.learnerservice.Repository.FormateurRepo;
import com.example.learnerservice.Service.BriefService;
import com.example.learnerservice.feign.CompetenceClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/briefs")
@AllArgsConstructor
public class BriefController {

    public BriefService briefService;
    public FormateurRepo formateurRepo;




    @Autowired
    private BriefRepo briefRepository;

    @Autowired
    private CompetenceClient competenceClient;

    @GetMapping("/{id}/with-competences")
    public Brief getBriefWithCompetences(@PathVariable Long id) {
        Brief brief = briefRepository.findById(id).orElseThrow();
        List<Long> competences = competenceClient.getCompetencesByBriefId(id);
        brief.setCompetencesIds(competences);
        return brief;
    }




    @PostMapping("/AddBrief")
    public BriefDTO AddBrief(@RequestBody BriefDTO briefDTO){
        return briefService.AddBrief(briefDTO);
    }

    @GetMapping("/AllBriefs")
    public List<BriefDTO> getAllBriefs(){
        return briefService.getAllBriefs();
    }

    @PutMapping("/Brief/{id}")
    public BriefDTO UpdateBrief(@RequestBody BriefDTO briefDTO , @PathVariable Long id){
        return briefService.UpdateBrief(briefDTO , id);
    }

    @GetMapping("/brief/{id}")
    public BriefDTO getBriefById(@PathVariable Long id){
        return briefService.getBriefById(id);
    }

    @DeleteMapping("/deleteBrief/{id}")
    public void deleteBrief(@PathVariable Long id ){
        briefService.DeleteBrief(id);
    }


}
