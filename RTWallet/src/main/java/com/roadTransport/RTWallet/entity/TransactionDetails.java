package com.roadTransport.RTWallet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
public class TransactionDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String userName;

    @Column
    private long userMobileNumber;

    @Column
    private long walletId;

    @Column
    private String netBankingId;

    @Column
    private String creditCardId;

    @Column
    private String DebitCardId;

    @Column
    private String paytmId;

    @Column
    private String phonePayId;

    @Column
    private double amount;

    @Column
    private double reverseAmount;

    @Column
    private double availableBalance;

    @Column
    private double updatedBalance;

    @Column
    private String transactionnNumber;

    @Column
    private boolean reverse;

    @Column
    private String reverseTransactioNumber;

    @Column
    private String transactionDate;

    @Column
    private String reverseTransactionDate;

    @Column
    private String description;

    @Column
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public double getUpdatedBalance() {
        return updatedBalance;
    }

    public void setUpdatedBalance(double updatedBalance) {
        this.updatedBalance = updatedBalance;
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

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userMobileNumber='" + userMobileNumber + '\'' +
                ", walletId='" + walletId + '\'' +
                ", netBankingId='" + netBankingId + '\'' +
                ", creditCardId='" + creditCardId + '\'' +
                ", DebitCardId='" + DebitCardId + '\'' +
                ", paytmId='" + paytmId + '\'' +
                ", phonePayId='" + phonePayId + '\'' +
                ", amount=" + amount +
                ", reverseAmount=" + reverseAmount +
                ", availableBalance=" + availableBalance +
                ", updatedBalance=" + updatedBalance +
                ", transactionnNumber='" + transactionnNumber + '\'' +
                ", reverse=" + reverse +
                ", reverseTransactioNumber='" + reverseTransactioNumber + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", reverseTransactionDate='" + reverseTransactionDate + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
