package com.example.learnerservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompetenceDto {
    private Long id ;
    private String nom ;
    private Long briefId;
}
