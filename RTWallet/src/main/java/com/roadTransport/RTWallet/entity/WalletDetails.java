package com.roadTransport.RTWallet.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class WalletDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    @NotNull
    private String ownerName;

    @Column(unique = true, length = 10)
    @NotNull
    private long walletId;

    @Column(length = 4)
    @NotNull
    private long walletPin;

    @Column
    @NotNull
    private double balance;

    @Column
    private String createdDate;

    @Column
    private String modifiedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public long getWalletPin() {
        return walletPin;
    }

    public void setWalletPin(long walletPin) {
        this.walletPin = walletPin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "WalletDetails{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", walletId=" + walletId +
                ", walletPin=" + walletPin +
                ", balance=" + balance +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }
}
