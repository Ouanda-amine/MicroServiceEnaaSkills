package com.example.learnerservice.Controller;

import com.example.learnerservice.Dto.FormateurDTO;
import com.example.learnerservice.Service.FormateurService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FormateurController {
    public FormateurService formateurService;



    @PutMapping("/AddFormateur")
    public FormateurDTO AddFormateur(@RequestBody FormateurDTO formateurDTO){
        return formateurService.AddFormateur(formateurDTO);
    }

    @GetMapping("/AllFormateurs")
    public List<FormateurDTO> getAllFormateurs(){
        return formateurService.getAllFormateurs();
    }

    @PutMapping("/Formateur/{id}")
    public FormateurDTO UpdateFormateur(@RequestBody FormateurDTO formateurDTO ,@PathVariable Long id){
        return formateurService.UpdateFormateur(formateurDTO , id);
    }

    @GetMapping("/formateur/{id}")
    public FormateurDTO getFormateurById(Long id){
        return for
    }
}
