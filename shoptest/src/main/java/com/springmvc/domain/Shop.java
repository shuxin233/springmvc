package com.springmvc.domain;

public class Shop {
    private int sid;
    private String sname;
    private int num;
    private int price;
    private String pic;
    private int bid;
    public Shop(){};

    public Shop(int sid, String sname, int num, int price, String pic, int bid) {
        this.sid = sid;
        this.sname = sname;
        this.num = num;
        this.price = price;
        this.pic = pic;
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "shop{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", bid=" + bid +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
