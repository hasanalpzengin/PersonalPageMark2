package com.hasanalpzengin.personalpage.model;

import com.hasanalpzengin.personalpage.entry.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProjectModel {
    @Autowired
    GithubService githubService;

    public List<Project> getAllProjects() throws JSONException {
        return githubService.getProjects();
    }
}
