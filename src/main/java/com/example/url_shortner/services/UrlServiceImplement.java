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
    private static int MAX_COLLISIONS = 1000;

    public UrlServiceImplement() {
    }

    @Override
    public List<Url> getUrls() {
          return urlRepository.findAll();
    }

    @Override
    public String getTinyUrl(String testUrl) {

        String toFind= "";
        Url present = urlRepository.findByOrgUrl(testUrl);

        if(present==null){
            //      implementing shortener if not present in db
            for (int index=0;index<testUrl.length()/2;index++) {
                if (index % 2 == 0) toFind += testUrl.charAt(index);
                else toFind += testUrl.charAt(testUrl.length() - index - 1);
            }
            // checking for collisions
            if(testUrl.length()==1)toFind=testUrl;

            String tinyUrl = toFind;
            for(int probe = 0; probe<MAX_COLLISIONS; probe++){
                Url collision = urlRepository.findByNewUrl(tinyUrl);
                if(collision==null)break;
                tinyUrl = toFind + Integer.toString(probe);
            }

            toFind = tinyUrl;
            Url temp = new Url(testUrl, toFind);
            urlRepository.save(temp);
        }
        else {
            toFind=present.getNewUrl();
        }
        return toFind;
    }

    @Override
    public String getBigUrl(String testUrl) {
        String toFind= "";
        Url present = urlRepository.findByNewUrl(testUrl);
        if(present==null){
            toFind= "No such Url found";
        }else {
            toFind = present.getOrgUrl();
        }
        return toFind;
    }
}
