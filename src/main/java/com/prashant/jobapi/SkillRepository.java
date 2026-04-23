package com.prashant.jobapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    public List<Skill> findSkillByCategory(String category);
}
