package com.roadTransport.RTWallet.model;

public class TransactionResponse {

    private long userMobileNumber;
    private String transactionnNumber;
    private boolean status;
    private String message;
    private boolean reverseStatus;

    public long getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(long userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getTransactionnNumber() {
        return transactionnNumber;
    }

    public void setTransactionnNumber(String transactionnNumber) {
        this.transactionnNumber = transactionnNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReverseStatus() {
        return reverseStatus;
    }

    public void setReverseStatus(boolean reverseStatus) {
        this.reverseStatus = reverseStatus;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "userMobileNumber='" + userMobileNumber + '\'' +
                ", transactionnNumber='" + transactionnNumber + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", reverseStatus=" + reverseStatus +
                '}';
    }
}
