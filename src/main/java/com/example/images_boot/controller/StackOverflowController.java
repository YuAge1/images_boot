package com.example.images_boot.controller;

import com.example.images_boot.model.Websites;
import com.example.images_boot.service.StackoverflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stackoverflow")
public class StackOverflowController {
    @Autowired
    private StackoverflowService stackoverflowService;

//    @RequestMapping
//    public List<Websites> getListOfProviders(){
//        return stackoverflowService.findAll();
//    }
    @RequestMapping
    public List<Websites> getListOfProviders(){
        return stackoverflowService.findAll();
    }
}
