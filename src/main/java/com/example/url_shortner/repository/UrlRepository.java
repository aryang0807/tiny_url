package com.example.url_shortner.repository;

import com.example.url_shortner.entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
    Url findByOrgUrl (String orgUrl);
    Url findByNewUrl (String newUrl);
}
