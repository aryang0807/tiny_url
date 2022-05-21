package com.example.url_shortner.services;

import com.example.url_shortner.entity.Url;

import java.util.List;

public interface UrlService {

    public List<Url> getUrls();

    public String getTinyUrl(String testUrl);
    public String getOriginalUrl(String testUrl);
}
