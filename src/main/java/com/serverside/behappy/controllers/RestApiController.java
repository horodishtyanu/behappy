package com.serverside.behappy.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverside.behappy.models.NegativeEmotionsPast;
import com.serverside.behappy.models.PreparatoryTechnique;
import com.serverside.behappy.repos.NegativeEmotionsPastRepo;
import com.serverside.behappy.repos.PreparatoryTechniqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiController {

    private final NegativeEmotionsPastRepo negativeEmotionsPastRepo;
    private final PreparatoryTechniqueRepo preparatoryTechniqueRepo;

    @Autowired
    public RestApiController(NegativeEmotionsPastRepo negativeEmotionsPastRepo, PreparatoryTechniqueRepo preparatoryTechniqueRepo) {
        this.negativeEmotionsPastRepo = negativeEmotionsPastRepo;
        this.preparatoryTechniqueRepo = preparatoryTechniqueRepo;
    }


    @PostMapping("/setNEP")
    public Object addNEP(@RequestBody String json){
        ObjectMapper om = new ObjectMapper();
        ArrayList<NegativeEmotionsPast> NEP = new ArrayList<>();
        try {
            NEP.addAll(om.readValue(json, new TypeReference<List<NegativeEmotionsPast>>(){}));
        }catch (IOException e){
            e.printStackTrace();
        }
        negativeEmotionsPastRepo.saveAll(NEP);
        return new ResponseEntity<>("NEP successful added!", HttpStatus.OK);
    }

    @PostMapping("/setPT")
    public Object addPT(@RequestBody String json){
        ObjectMapper om = new ObjectMapper();
        ArrayList<PreparatoryTechnique> PT = new ArrayList<>();
        try {
            PT.addAll(om.readValue(json, new TypeReference<List<PreparatoryTechnique>>(){}));
        }catch (IOException e){
            e.printStackTrace();
        }
        preparatoryTechniqueRepo.saveAll(PT);
        return new ResponseEntity<>("PT successful added!", HttpStatus.OK);
    }
}
