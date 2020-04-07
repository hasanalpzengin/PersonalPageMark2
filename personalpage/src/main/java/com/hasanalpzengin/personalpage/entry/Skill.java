package com.hasanalpzengin.personalpage.entry;

/*
* _id: ID!,
    category: String,
    name: String!,
    level: Int!
* */

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "skills")
@Data
public class Skill {
    private ObjectId _id;
    private String category;
    private String name;
    private Integer level;

    public Skill(String name, String category, Integer level){
        this.name = name;
        this.category = category;
        this.level = level;
    }
}
