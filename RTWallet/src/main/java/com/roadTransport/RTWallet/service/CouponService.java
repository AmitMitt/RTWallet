package com.roadTransport.RTWallet.service;

import com.roadTransport.RTWallet.entity.CouponDetails;
import com.roadTransport.RTWallet.model.CouponRequest;
import org.springframework.stereotype.Service;

@Service
public interface CouponService {

    public CouponDetails add (CouponRequest couponRequest) throws Exception;
    public CouponDetails getListByWallet(String coupon) throws Exception;
    public CouponDetails update(CouponRequest couponRequest);
    public CouponDetails delete(String coupon);

}
