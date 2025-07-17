package com.example.learnerservice.Repository;

import com.example.learnerservice.Model.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BriefRepo extends JpaRepository<Brief , Long> {
//    @Query(value = "SELECT count(id) from Brief b , formateur f where f.id = ?",nativeQuery = true)
//    Integer nbrbrief(Long id);

}
