package com.example.url_shortner.controller;

import com.example.url_shortner.entity.Url;
import com.example.url_shortner.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String shortUrl(){
        return "Returns Shortened Url";
    }

    @GetMapping("/urls")                                             // called when a get request is sent to "/urls"
    public List<Url> getUrls(){
        return this.urlService.getUrls();
    }

    @GetMapping("/urls/")                                            // called when a get request is sent to /urls/?testUrl="value"
    public ResponseEntity<String> getTinyUrl(@RequestParam String testUrl){
        try {
            String tinyUrl = this.urlService.getTinyUrl(testUrl);
            return new ResponseEntity<>(tinyUrl, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Some error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tinyUrl/")                                        // called when a get request is sent to /tinyUrl/?testUrl="value"
    public ResponseEntity<String> getOriginalUrl(@RequestParam String testUrl){
        try {
            String originalUrl = this.urlService.getOriginalUrl(testUrl);
            return new ResponseEntity<>(originalUrl, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Some error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
