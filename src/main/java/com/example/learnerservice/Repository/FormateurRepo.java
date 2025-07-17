package com.example.learnerservice.Repository;

import com.example.learnerservice.Model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormateurRepo extends JpaRepository<Formateur , Long> {

}
