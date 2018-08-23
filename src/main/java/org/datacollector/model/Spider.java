package org.datacollector.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Spider {
    @Id
    @Column(name = "spider_name")
    private String spiderName;

    private String url;

    private String title1;

    private String date1;

    private String title2;

    private String date2;

    /**
     * @return spider_name
     */
    public String getSpiderName() {
        return spiderName;
    }

    /**
     * @param spiderName set spider name
     */
    public void setSpiderName(String spiderName) {
        this.spiderName = spiderName == null ? null : spiderName.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url set spider init url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return title1
     */
    public String getTitle1() {
        return title1;
    }

    /**
     * @param title1 set spider init title1
     */
    public void setTitle1(String title1) {
        this.title1 = title1 == null ? null : title1.trim();
    }

    /**
     * @return date1
     */
    public String getDate1() {
        return date1;
    }

    /**
     * @param date1 set spider init date1
     */
    public void setDate1(String date1) {
        this.date1 = date1 == null ? null : date1.trim();
    }

    /**
     * @return title2
     */
    public String getTitle2() {
        return title2;
    }

    /**
     * @param title2 set spider init title2
     */
    public void setTitle2(String title2) {
        this.title2 = title2 == null ? null : title2.trim();
    }

    /**
     * @return date2
     */
    public String getDate2() {
        return date2;
    }

    /**
     * @param date2 set spider init date2
     */
    public void setDate2(String date2) {
        this.date2 = date2 == null ? null : date2.trim();
    }
}