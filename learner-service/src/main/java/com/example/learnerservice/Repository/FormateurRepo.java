package com.example.learnerservice.Repository;

import com.example.learnerservice.Model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepo extends JpaRepository<Formateur , Long> {
}
