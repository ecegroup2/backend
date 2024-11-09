package com.ece.backend.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DataSet {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private double heartrate;
    private double spo2;
    
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
