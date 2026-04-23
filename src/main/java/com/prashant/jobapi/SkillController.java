package com.prashant.jobapi;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @GetMapping()
    public List<Skill> getAllSkills(){
        return skillService.getAllSkills();
    }

    @GetMapping("/category/{category}")
    public List<Skill> getSkillByCategory(@PathVariable String category){
        List<Skill> skills= skillService.getSkillByCategory(category);
        if(skills.isEmpty())
            throw new NotFoundException("No skills found for category: " + category);
        return skills;
    }

    @PostMapping
    public Skill createSkill(@Valid @RequestBody Skill skill){
        return skillService.createSkill(skill);
    }

}
