package com.example.url_shortner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Url {
    @Id
    private String id;

    @Indexed(name = "org_url", direction = IndexDirection.ASCENDING)
    private String orgUrl;

    @Indexed(name= "new_url", direction = IndexDirection.ASCENDING)
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
