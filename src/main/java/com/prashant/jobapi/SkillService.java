package com.prashant.jobapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }

    public Skill createSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public List<Skill> getSkillByCategory(String category){
        return skillRepository.findSkillByCategory(category);
    }

}
