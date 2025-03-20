package com.ece.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * The DataSet class represents a data entry for a user's health readings.
 * It contains fields for storing a user's ID, heart rate, and blood oxygen saturation (SpO2).
 * This class is mapped to a database table using JPA annotations.
 */

@Entity
public class DataSet {
    @Id
    //  * The unique identifier for each data entry, representing the user's ID.
    private Long userId;
    //  * The heart rate measurement for the user.
    private double heartrate;
    //  *The blood oxygen saturation (SpO2) measurement for the user.
    private double spo2;
    //  *Ecg graph points
    private double ecg[];

    public double[] getEcg() {
        return ecg;
    }
    public void setEcg(double[] ecg) {
        this.ecg = ecg;
    }
    public double getHeartrate() {
        return heartrate;
    }
    public void setHeartrate(double heartrate) {
        this.heartrate = heartrate;
    }
    
    
    public double getSpo2() {
        return spo2;
    }
    public void setSpo2(double spo2) {
        this.spo2 = spo2;
    }
    @Override
    public String toString() {
        return "DataSet [userId=" + userId + ", heartrate=" + heartrate + ", spo2=" + spo2 + "]";
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
