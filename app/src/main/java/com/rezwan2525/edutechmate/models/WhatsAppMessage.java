package com.rezwan2525.edutechmate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WhatsAppMessage {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("text")
    @Expose
    private String text;

    public WhatsAppMessage(){}

    public WhatsAppMessage(String phone, String text) {
        this.phone = phone;
        this.text = text;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}