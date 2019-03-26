package com.roadTransport.RTWallet.serviceImpl;

import com.roadTransport.RTWallet.entity.CouponDetails;
import com.roadTransport.RTWallet.model.CouponRequest;
import com.roadTransport.RTWallet.repository.CouponRepository;
import com.roadTransport.RTWallet.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public CouponDetails add(CouponRequest couponRequest) throws Exception {

        CouponDetails couponDetails = couponRepository.findByCoupon(couponRequest.getCoupon());

        if(couponDetails != null){
            throw new Exception("Coupon Already Exist.");
        }

        CouponDetails couponDetails1 = new CouponDetails();
        couponDetails1.setCashBack(couponRequest.getCashBack());
        couponDetails1.setCoupon(couponRequest.getCoupon());
        couponDetails1.setCouponCount(couponRequest.getCouponCount());
        couponDetails1.setCreatedTime(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        couponDetails1.setExipryDate(couponRequest.getExipryDate());
        couponDetails1.setMaxCashBack(couponRequest.getMaxCashBack());
        couponDetails1.setMinCashBack(couponRequest.getMinCashBack());
        couponDetails1.setMinTransactionAmount(couponRequest.getMinTransactionAmount());
        couponDetails1.setPercentage(couponRequest.getPercentage());
        couponDetails1.setStartDate(couponRequest.getStartDate());
        couponDetails1.setTotalCount(couponRequest.getTotalCount());

        couponRepository.saveAndFlush(couponDetails1);
        return couponDetails1;
    }

    @Override
    public CouponDetails getListByWallet(String coupon) throws Exception {

        CouponDetails couponDetails = couponRepository.findByCoupon(coupon);
        if (couponDetails==null){
            throw new Exception("Coupon not Exist.");
        }

        return couponDetails;
    }

    @Override
    public CouponDetails update(CouponRequest couponRequest) {

        CouponDetails couponDetails = couponRepository.findByCoupon(couponRequest.getCoupon());

        couponDetails.setCashBack(couponRequest.getCashBack());
        couponDetails.setCoupon(couponRequest.getCoupon());
        couponDetails.setCouponCount(couponRequest.getCouponCount());
        couponDetails.setModifiedTime(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        couponDetails.setExipryDate(couponRequest.getExipryDate());
        couponDetails.setMaxCashBack(couponRequest.getMaxCashBack());
        couponDetails.setMinCashBack(couponRequest.getMinCashBack());
        couponDetails.setMinTransactionAmount(couponRequest.getMinTransactionAmount());
        couponDetails.setPercentage(couponRequest.getPercentage());
        couponDetails.setStartDate(couponRequest.getStartDate());
        couponDetails.setTotalCount(couponRequest.getTotalCount());

        couponRepository.saveAndFlush(couponDetails);
        return couponDetails;
    }

    @Override
    public CouponDetails delete(String coupon) {
        CouponDetails couponDetails = couponRepository.findByCoupon(coupon);
        couponRepository.delete(couponDetails);
        return null;
    }
}
