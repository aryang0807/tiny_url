package com.example.url_shortner.services;

import com.example.url_shortner.entity.Url;
import com.example.url_shortner.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UrlServiceImplement implements UrlService {
    @Autowired
    private UrlRepository urlRepository;
    private static int MAX_COLLISIONS = 10000000;                      // max collisions allowed in case of same tinyUrl

    public UrlServiceImplement() {
    }

    @Override
    public List<Url> getUrls() {
        return urlRepository.findAll();
    } // returns all the entries present in the DB

    @Override
    public String getTinyUrl(String testUrl) {
        String tinyUrl = "";
        Url present = urlRepository.findByOrgUrl(testUrl);

        if (present == null) {                                        //implementing shortener if testUrl is not present in DB
            for (int index = 0; index < testUrl.length(); index+=3) {
                 tinyUrl += testUrl.charAt(index);
            }

            if (testUrl.length() == 1) tinyUrl = testUrl;
            String finalUrl = tinyUrl;
            for (int probe = 0; probe < MAX_COLLISIONS; probe++) {      //  checking if same finalUrl is present or not
                Url collision = urlRepository.findByNewUrl(finalUrl);
                if (collision == null) break;
                int index = (int)(testUrl.length()*Math.random());
                finalUrl = tinyUrl.substring(0,index) +Integer.toString((int)(Math.random()*10000000))+ // placing a random number at random index
                        tinyUrl.substring(index);
            }

            tinyUrl = finalUrl;
            Url temp = new Url(testUrl, tinyUrl);
            urlRepository.save(temp);                              // saving the Url in DB
        } else {
            tinyUrl = present.getNewUrl();                           // if testUrl is already in DB return its tinyUrl
        }
        return tinyUrl;
    }

    @Override
    public String getOriginalUrl(String testUrl) {
        String originalUrl = "";
        Url present = urlRepository.findByNewUrl(testUrl);
        if (present == null) {
            originalUrl = "No such Url found";
        } else {
            originalUrl = present.getOrgUrl();                   // if testUrl is present in DB return its originalUrl
        }
        return originalUrl;
    }
}
