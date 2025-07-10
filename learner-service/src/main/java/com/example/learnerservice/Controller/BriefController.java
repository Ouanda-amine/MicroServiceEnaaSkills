package com.example.learnerservice.Controller;

import com.example.learnerservice.Dto.BriefDTO;
import com.example.learnerservice.Service.BriefService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BriefController {

    public BriefService briefService;

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


}
