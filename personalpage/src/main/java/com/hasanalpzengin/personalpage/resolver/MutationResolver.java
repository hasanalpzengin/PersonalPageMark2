package com.hasanalpzengin.personalpage.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hasanalpzengin.personalpage.entry.Sharing;
import com.hasanalpzengin.personalpage.entry.Skill;
import com.hasanalpzengin.personalpage.model.SharingModel;
import com.hasanalpzengin.personalpage.model.SkillModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    @Autowired
    SharingModel sharingModel;
    @Autowired
    SkillModel skillModel;

    public Skill createSkill(String name, String category, int level){
        return skillModel.createSkill(name, category, level);
    }

    public Boolean deleteSkill(String id){
        return skillModel.deleteSkill(id);
    }

    public Sharing createSharing(String image, String description){
        return sharingModel.createSharing(image, description);
    }

    public Boolean deleteSharing(String id){
        return sharingModel.deleteSharing(id);
    }
}
