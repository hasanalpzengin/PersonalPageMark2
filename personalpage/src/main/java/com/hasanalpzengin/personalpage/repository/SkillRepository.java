package com.hasanalpzengin.personalpage.repository;

import com.hasanalpzengin.personalpage.entry.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends MongoRepository<Skill, String> {
}
