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
    private double reverseAmount;
    private String transactionnNumber;
    private boolean reverse;
    private String reverseTransactioNumber;
    private String transactionDate;
    private String reverseTransactionDate;
    private String description;
    private boolean status;
    private boolean reverseStatus;

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

    public double getReverseAmount() {
        return reverseAmount;
    }

    public void setReverseAmount(double reverseAmount) {
        this.reverseAmount = reverseAmount;
    }

    public String getTransactionnNumber() {
        return transactionnNumber;
    }

    public void setTransactionnNumber(String transactionnNumber) {
        this.transactionnNumber = transactionnNumber;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public String getReverseTransactioNumber() {
        return reverseTransactioNumber;
    }

    public void setReverseTransactioNumber(String reverseTransactioNumber) {
        this.reverseTransactioNumber = reverseTransactioNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getReverseTransactionDate() {
        return reverseTransactionDate;
    }

    public void setReverseTransactionDate(String reverseTransactionDate) {
        this.reverseTransactionDate = reverseTransactionDate;
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

    public boolean isReverseStatus() {
        return reverseStatus;
    }

    public void setReverseStatus(boolean reverseStatus) {
        this.reverseStatus = reverseStatus;
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
                ", reverseAmount=" + reverseAmount +
                ", transactionnNumber='" + transactionnNumber + '\'' +
                ", reverse=" + reverse +
                ", reverseTransactioNumber='" + reverseTransactioNumber + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", reverseTransactionDate='" + reverseTransactionDate + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", reverseStatus=" + reverseStatus +
                '}';
    }
}
