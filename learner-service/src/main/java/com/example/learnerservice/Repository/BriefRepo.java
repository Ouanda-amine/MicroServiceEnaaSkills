package com.example.learnerservice.Repository;

import com.example.learnerservice.Model.Brief;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BriefRepo extends JpaRepository<Brief , Long> {
}
