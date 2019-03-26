package com.roadTransport.RTWallet.model;

public class CouponResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CouponResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
