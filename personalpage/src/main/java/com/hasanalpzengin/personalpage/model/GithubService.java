package com.hasanalpzengin.personalpage.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hasanalpzengin.personalpage.entry.Project;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class GithubService {
    private final RestTemplate restTemplate;

    public GithubService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    protected List<Project> getProjects() throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer efc573ac82048617db7ebb0cc1d24e8c2f300cd1");

        String body = "{\"query\":\"query{\\n    viewer\\n    {\\n        repositories(last: 100)\\n        {\\n            nodes\\n            {\\n                name\\n                createdAt\\n                updatedAt\\n                url\\n                description\\n                primaryLanguage{name}\\n            }\\n        }\\n    }\\n}\",\"variables\":{}}";

        HttpEntity request = new HttpEntity(body, headers);

        String url = "https://api.github.com/graphql";
        String projectsRaw = this.restTemplate.postForObject(url, request, String.class);
        JSONObject projectsJSON = new JSONObject(projectsRaw);

        JSONArray projectJSONArray = projectsJSON.getJSONObject("data").getJSONObject("viewer").getJSONObject("repositories").getJSONArray("nodes");
        List<Project> projects = new ArrayList<>();
        JSONObject jsonObject;

        for (int i=0; i<projectJSONArray.length(); i++){
            jsonObject = projectJSONArray.getJSONObject(i);
            projects.add(
                new Project(
                    jsonObject.getString("name"),
                    new Date(Instant.parse(jsonObject.getString("createdAt")).getEpochSecond()*1000),
                    new Date(Instant.parse(jsonObject.getString("updatedAt")).getEpochSecond()*1000),
                    jsonObject.getString("url"),
                    jsonObject.getString("description"),
                    jsonObject.getJSONObject("primaryLanguage").getString("name")

                )
            );
        }

        return projects;
    }

}
