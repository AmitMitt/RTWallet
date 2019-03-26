package com.roadTransport.RTWallet.model;

public class CouponRequest {

    private String coupon;
    private long couponCount;
    private long totalCount;
    private String startDate;
    private String exipryDate;
    private double cashBack;
    private long percentage;
    private double maxCashBack;
    private double minCashBack;
    private double minTransactionAmount;

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
        return "CouponRequest{" +
                "coupon='" + coupon + '\'' +
                ", couponCount=" + couponCount +
                ", totalCount=" + totalCount +
                ", startDate='" + startDate + '\'' +
                ", exipryDate='" + exipryDate + '\'' +
                ", cashBack=" + cashBack +
                ", percentage=" + percentage +
                ", maxCashBack=" + maxCashBack +
                ", minCashBack=" + minCashBack +
                ", minTransactionAmount=" + minTransactionAmount +
                '}';
    }
}
