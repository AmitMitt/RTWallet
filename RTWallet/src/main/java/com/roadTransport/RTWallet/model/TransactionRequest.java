package com.roadTransport.RTWallet.model;

public class TransactionRequest {

    private String userName;
    private long userMobileNumber;
    private long walletId;
    private String netBankingId;
    private String creditCardId;
    private String DebitCardId;
    private String paytmId;
    private String phonePayId;
    private double amount;
    private String description;
    private boolean status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(long userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public String getNetBankingId() {
        return netBankingId;
    }

    public void setNetBankingId(String netBankingId) {
        this.netBankingId = netBankingId;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getDebitCardId() {
        return DebitCardId;
    }

    public void setDebitCardId(String debitCardId) {
        DebitCardId = debitCardId;
    }

    public String getPaytmId() {
        return paytmId;
    }

    public void setPaytmId(String paytmId) {
        this.paytmId = paytmId;
    }

    public String getPhonePayId() {
        return phonePayId;
    }

    public void setPhonePayId(String phonePayId) {
        this.phonePayId = phonePayId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "userName='" + userName + '\'' +
                ", userMobileNumber='" + userMobileNumber + '\'' +
                ", walletId='" + walletId + '\'' +
                ", netBankingId='" + netBankingId + '\'' +
                ", creditCardId='" + creditCardId + '\'' +
                ", DebitCardId='" + DebitCardId + '\'' +
                ", paytmId='" + paytmId + '\'' +
                ", phonePayId='" + phonePayId + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
