package com.hasanalpzengin.personalpage.model;

import com.hasanalpzengin.personalpage.entry.Skill;
import com.hasanalpzengin.personalpage.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class SkillModel {
    @Autowired
    SkillRepository skillRepository;

    public List<Skill> listCategories(){
        List<Skill> skills = skillRepository.findAll();
        Set<Skill> categories = new HashSet<>();
        skills.forEach((skill)->{
            if(skill.getCategory()!=null){
                categories.add(skill);
            }
        });
        skills.clear();
        skills.addAll(categories);
        return skills;
    }

    public List<Skill> findAllByCategory(String category){
        List<Skill> skills = skillRepository.findAll();
        Set<Skill> filteredSkills = new HashSet<>();
        skills.forEach((skill)->{
            if(skill.getCategory().contentEquals(category)){
                filteredSkills.add(skill);
            }
        });
        skills.clear();
        skills.addAll(filteredSkills);
        return skills;
    }

    public Skill createSkill(String name, String category, Integer level){
        return skillRepository.insert(new Skill(name, category, level));
    }

    public Boolean deleteSkill(String id){
        skillRepository.deleteById(id);
        return true;
    }

}
