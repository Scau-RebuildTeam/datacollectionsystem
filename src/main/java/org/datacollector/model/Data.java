package org.datacollector.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by 哲帆 on 2018.8.21.
 */
@Document(collection = "Data")
public class Data {

    private String title;

    private String url;

    private String spider;

    private String date;

    public Data(String title, String url, String spider, String date) {
        this.title = title;
        this.url = url;
        this.spider = spider;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSpider() {
        return spider;
    }

    public void setSpider(String spider) {
        this.spider = spider;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
