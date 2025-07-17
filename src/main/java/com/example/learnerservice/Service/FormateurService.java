package com.example.learnerservice.Service;

import com.example.learnerservice.Dto.FormateurDTO;
import com.example.learnerservice.Mapper.FormateurMapper;
import com.example.learnerservice.Model.Formateur;
import com.example.learnerservice.Repository.FormateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormateurService {
    private final FormateurMapper formateurMapper;
    private final FormateurRepo formateurRepo;

    public FormateurDTO AddFormateur(FormateurDTO formateurDTO){
        return formateurMapper.ToFormateurDTO(formateurRepo.save(formateurMapper.ToFormateurEntity(formateurDTO)));

    }

    public List<FormateurDTO> getAllFormateurs(){
        return formateurRepo.findAll().stream()
                .map(formateur -> formateurMapper.ToFormateurDTO(formateur))
                .toList();
    }

    public FormateurDTO getFormateurById(Long id){
        return formateurRepo.findById(id).map(formateur -> formateurMapper.ToFormateurDTO(formateur))
                .orElseThrow(()->new RuntimeException("formateur not found"));
    }

    public FormateurDTO UpdateFormateur(FormateurDTO formateurDTO , Long id){
        Formateur formateur = formateurRepo.findById(id).get();
        formateur.setNom(formateurDTO.getNom());
        return formateurMapper.ToFormateurDTO(formateurRepo.save(formateur));
    }

    public void DeleteFormateur(Long id){
        formateurRepo.deleteById(id);
    }
}
