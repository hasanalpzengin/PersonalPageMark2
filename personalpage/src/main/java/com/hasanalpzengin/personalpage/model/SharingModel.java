package com.hasanalpzengin.personalpage.model;

import com.hasanalpzengin.personalpage.entry.Sharing;
import com.hasanalpzengin.personalpage.repository.SharingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class SharingModel {
    private final Logger LOG = LoggerFactory.getLogger(SharingModel.class);

    @Autowired
    SharingRepository sharingRepository;

    public Sharing createSharing(String image, String description){
        return sharingRepository.insert(new Sharing(image, description, new Date()));
    }

    public List<Sharing> listSharings(){
        return sharingRepository.findAll();
    }

    public Sharing getSharing(String id){
        return sharingRepository.findById(id).get();
    }

    public Boolean deleteSharing(String id){
        sharingRepository.deleteById(id);
        return true;
    }

}
