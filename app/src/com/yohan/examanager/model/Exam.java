package com.yohan.examanager.model;

import java.io.Serializable;

/**
 * Created by Admin on 15-02-17.
 */

public class Exam implements Serializable{

    private String id;
    private String syllabus;
    private String qualification;
    private String name;
    private String maxMarks;
    private String instructions;
    private String duration;
    private String description;
    private String datenTime;
    private String contactNo;
    public String getSyllabus() {
        return syllabus;
    }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatenTime() {
        return datenTime;
    }

    public void setDatenTime(String datenTime) {
        this.datenTime = datenTime;
    }

    public String getContactNo() {
        return contactNo;
    }

  /*  public String getDate() {

        return contactNo;
    }
    public String getTime() {
        return contactNo;
    }*/

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
