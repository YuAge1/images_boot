package com.example.images_boot.service;

import com.example.images_boot.model.Site;
import com.example.images_boot.model.Websites;
import com.example.images_boot.persistence.Repository;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.hibernate.annotations.Immutable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Component
public class StackoverflowService {
    @Autowired
    private Repository repository;
    @Autowired
    private Client client;

    public List<Websites> findAll() {
        try {
            return client.getSites().stream()
                    .map(this::toWebsite)
                    .filter(this::ignore)
                    .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean ignore(@NonNull Websites websites) {
        return !websites.getId().startsWith("meta");
    }

    private Websites toWebsite(@NonNull Site input){
        return new Websites(
                input.getSite_url().substring("https://".length(), input.getSite_url().length() - ".com".length()),
                input.getSite_url(),
                input.getFavicon_url(),
                input.getName(),
                input.getAudience());
    }

//    public List<Websites> findAll() {
//        return repository.findAll();
//    }

}
