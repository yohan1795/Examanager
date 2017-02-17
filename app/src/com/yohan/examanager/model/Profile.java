package com.yohan.examanager.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Profile implements Serializable {

    private String id;
    private String name;
    private String gender;
    private String emailAddress;
    private String dob;
    private String contact;
    private BigDecimal aadharNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public BigDecimal getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNoStr) {
        this.aadharNo = BigDecimal.valueOf(Double.parseDouble(aadharNoStr));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}