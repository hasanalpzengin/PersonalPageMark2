package com.hasanalpzengin.personalpage.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hasanalpzengin.personalpage.entry.Project;
import com.hasanalpzengin.personalpage.entry.Sharing;
import com.hasanalpzengin.personalpage.entry.Skill;
import com.hasanalpzengin.personalpage.model.ProjectModel;
import com.hasanalpzengin.personalpage.model.SharingModel;
import com.hasanalpzengin.personalpage.model.SkillModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    SkillModel skillModel;
    @Autowired
    SharingModel sharingModel;
    @Autowired
    ProjectModel projectModel;

    public List<Skill> skills(String category){
        return skillModel.findAllByCategory(category);
    }

    public List<Skill> categories(){
        return skillModel.listCategories();
    }

    public List<Sharing> sharings(){
        return sharingModel.listSharings();
    }

    public List<Project> projects() throws JSONException { return  projectModel.getAllProjects(); }
}
