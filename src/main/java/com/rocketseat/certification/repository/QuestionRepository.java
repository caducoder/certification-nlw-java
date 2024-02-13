package com.rocketseat.certification.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocketseat.certification.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID>{

	List<Question> findByTechnology(String technology);
}
