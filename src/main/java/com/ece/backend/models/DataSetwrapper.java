package com.ece.backend.models;

public class DataSetwrapper {
    //  * The unique identifier for each data entry, representing the user's ID.
    private Long userId;
    //  * The heart rate measurement for the user.
    private double heartrate;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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
    //  *The blood oxygen saturation (SpO2) measurement for the user.
    private double spo2;
}
