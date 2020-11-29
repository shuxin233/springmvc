package com.springmvc.domain;

import java.util.List;

public class Brand {
    private int bid;
    private String bname;
    private String city;
    private String introduction;
    private List<Shop> Shops;

    public Brand(){};

    @Override
    public String toString() {
        return "brand{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", city='" + city + '\'' +
                ", introduction='" + introduction + '\'' +
                ", shops=" + Shops +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<Shop> getShops() {
        return Shops;
    }

    public void setShops(List<Shop> Shops) {
        this.Shops = Shops;
    }
}
