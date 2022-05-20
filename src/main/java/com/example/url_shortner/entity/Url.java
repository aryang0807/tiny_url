package com.example.url_shortner.entity;

import org.springframework.data.annotation.Id;

public class Url {
    @Id
    private String id;
    private String orgUrl;
    private String  newUrl;

    public Url(String orgUrl, String newUrl ) {
        this.orgUrl = orgUrl;
        this.newUrl = newUrl;
    }

    public Url(){
        super();
    }

    public String getOrgUrl() {
        return orgUrl;
    }

    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

}
