package com.roadTransport.RTWallet.entity;

import javax.persistence.*;

@Table
@Entity
public class CouponDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String coupon;

    @Column
    private long couponCount;

    @Column
    private long totalCount;

    @Column
    private String startDate;

    @Column
    private String exipryDate;

    @Column
    private String createdTime;

    @Column
    private String modifiedTime;

    @Column
    private double cashBack;

    @Column
    private long percentage;

    @Column
    private double maxCashBack;

    @Column
    private double minCashBack;

    @Column
    private double minTransactionAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public long getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(long couponCount) {
        this.couponCount = couponCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExipryDate() {
        return exipryDate;
    }

    public void setExipryDate(String exipryDate) {
        this.exipryDate = exipryDate;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public long getPercentage() {
        return percentage;
    }

    public void setPercentage(long percentage) {
        this.percentage = percentage;
    }

    public double getMaxCashBack() {
        return maxCashBack;
    }

    public void setMaxCashBack(double maxCashBack) {
        this.maxCashBack = maxCashBack;
    }

    public double getMinCashBack() {
        return minCashBack;
    }

    public void setMinCashBack(double minCashBack) {
        this.minCashBack = minCashBack;
    }

    public double getMinTransactionAmount() {
        return minTransactionAmount;
    }

    public void setMinTransactionAmount(double minTransactionAmount) {
        this.minTransactionAmount = minTransactionAmount;
    }

    @Override
    public String toString() {
        return "CouponDetails{" +
                "id=" + id +
                ", coupon='" + coupon + '\'' +
                ", couponCount=" + couponCount +
                ", totalCount=" + totalCount +
                ", startDate='" + startDate + '\'' +
                ", exipryDate='" + exipryDate + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", cashBack=" + cashBack +
                ", percentage=" + percentage +
                ", maxCashBack=" + maxCashBack +
                ", minCashBack=" + minCashBack +
                ", minTransactionAmount=" + minTransactionAmount +
                '}';
    }
}
