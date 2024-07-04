package com.dyon.pesanaja;

import java.io.Serializable;

public class Order implements Serializable {
    private String nameCustomer, note;
    private Integer id, rice, chicken, catfish, mineral, tea, orange;

    public Order() {
    }

    public Order(Integer id, String nameCustomer, Integer friedRice, Integer friedChicken, Integer friedCatFish, Integer mineral, Integer tea, Integer orange, String note){
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.rice = friedRice;
        this.chicken = friedChicken;
        this.catfish = friedCatFish;
        this.mineral = mineral;
        this.tea = tea;
        this.orange = orange;
        this.note = note;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCustomer() { return nameCustomer; }

    public void setNameCustomer(String nameCustomer) { this.nameCustomer = nameCustomer; }

    public Integer getRice() { return rice; }

    public void setRice(Integer rice) { this.rice = rice; }

    public Integer getChicken() { return chicken; }

    public void setChicken(Integer chicken) { this.chicken = chicken; }

    public Integer getCatfish() { return catfish; }

    public void setCatfish(Integer catfish) { this.catfish = catfish; }

    public Integer getMineral() { return mineral; }

    public void setMineral(Integer mineral) { this.mineral = mineral; }

    public Integer getTea() { return tea; }

    public void setTea(Integer tea) { this.tea = tea; }

    public Integer getOrange() { return orange; }

    public void setOrange(Integer orange) { this.orange = orange; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }
}
