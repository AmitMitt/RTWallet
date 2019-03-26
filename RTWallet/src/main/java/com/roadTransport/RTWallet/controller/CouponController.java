package com.roadTransport.RTWallet.controller;

import com.roadTransport.RTWallet.entity.CouponDetails;
import com.roadTransport.RTWallet.model.CouponRequest;
import com.roadTransport.RTWallet.model.CouponResponse;
import com.roadTransport.RTWallet.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/add")
    public ResponseEntity<CouponResponse> add(@RequestBody CouponRequest couponRequest) throws Exception {

        CouponDetails couponDetails = couponService.add(couponRequest);
        CouponResponse couponResponse = new CouponResponse();
        couponResponse.setMessage("Coupon Add Successfully.");
        return ResponseEntity.ok(couponResponse);
    }

    @CachePut(value = "CouponDetails", key = "#coupon")
    @PutMapping("/update")
    public ResponseEntity<CouponResponse> update(@RequestBody CouponRequest couponRequest){

        CouponDetails couponDetails = couponService.update(couponRequest);
        CouponResponse couponResponse = new CouponResponse();
        couponResponse.setMessage("Coupon Update Successfully.");
        return ResponseEntity.ok(couponResponse);
    }

    @CacheEvict(value = "CouponDetails")
    @DeleteMapping("delete/{coupon}")
    public ResponseEntity<CouponResponse> delete(@PathVariable("coupon") String coupon){

        couponService.delete(coupon);
        CouponResponse couponResponse = new CouponResponse();
        couponResponse.setMessage("Successfully Deleted.");
        return ResponseEntity.ok(couponResponse);
    }

    @Cacheable(value = "CouponDetails", key = "#coupon")
    @GetMapping("getData/{coupon}")
    public ResponseEntity<CouponDetails> get(@PathVariable("coupon") String coupon) throws Exception {

        CouponDetails couponDetails = couponService.getListByWallet(coupon);
        return ResponseEntity.ok(couponDetails);
    }

}
