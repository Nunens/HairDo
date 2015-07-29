/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.hakeem.hairdo.dto;

/**
 *
 * @author admin
 */
public class MstyleDTO {

    private int mstyleID;
    private double price;
    private long date;
    private String status;
    private int styleID;
    private int stylistID;
    private StyleDTO style;
    private StylistDTO stylist;

    public MstyleDTO() {

    }

    public int getMstyleID() {
        return mstyleID;
    }

    public void setMstyleID(int mstyleID) {
        this.mstyleID = mstyleID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStyleID() {
        return styleID;
    }

    public void setStyleID(int styleID) {
        this.styleID = styleID;
    }

    public int getStylistID() {
        return stylistID;
    }

    public void setStylistID(int stylistID) {
        this.stylistID = stylistID;
    }

    public StyleDTO getStyle() {
        return style;
    }

    public void setStyle(StyleDTO style) {
        this.style = style;
    }

    public StylistDTO getStylist() {
        return stylist;
    }

    public void setStylist(StylistDTO stylist) {
        this.stylist = stylist;
    }

}
