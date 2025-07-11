package com.example.learnerservice.Mapper;

import com.example.learnerservice.Dto.FormateurDTO;
import com.example.learnerservice.Model.Formateur;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface FormateurMapper {

    Formateur ToFormateurEntity(FormateurDTO formateurDTO);
    FormateurDTO ToFormateurDTO(Formateur formateur);


}
