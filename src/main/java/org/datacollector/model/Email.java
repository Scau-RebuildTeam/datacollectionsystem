package org.datacollector.model;

import javax.persistence.Id;

public class Email {
    @Id
    private String address;

    private String name;

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address set email address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set contact name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}