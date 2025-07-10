package com.example.learnerservice.Mapper;

import com.example.learnerservice.Dto.BriefDTO;
import com.example.learnerservice.Model.Brief;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BriefMapper {

    BriefDTO ToBriehDto(Brief brief);
    Brief ToBriefEntity(BriefDTO briefDTO);
}
