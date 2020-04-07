package com.hasanalpzengin.personalpage.entry;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class Project implements Serializable {
    String name;
    Date createdAt;
    Date updatedAt;
    String url;
    String description;
    String lang;
}
