package com.example.images_boot.persistence;

import com.example.images_boot.model.Websites;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Repository extends MongoRepository<Websites, String> {
    List<Websites> findByWebsite(String website);

//    public List<Websites> findAll() {
//        return mongoTemplate.findAll(Websites.class);
//    }
}
