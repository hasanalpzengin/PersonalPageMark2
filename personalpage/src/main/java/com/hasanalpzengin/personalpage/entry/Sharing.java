package com.hasanalpzengin.personalpage.entry;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/*
* _id: ID!,
    image: String,
    description: String,
    createdAt: String
* */
@Document(collection = "sharings")
@Data
public class Sharing {
    private ObjectId _id;
    private String image;
    private String description;
    @CreatedDate
    private Date createdAt = new Date();

    public Sharing(String image, String description, Date createdAt){
        this.image = image;
        this.description = description;
        this.createdAt = createdAt;
    }
}
