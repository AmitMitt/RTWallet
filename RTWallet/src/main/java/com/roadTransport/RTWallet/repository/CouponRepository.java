package com.roadTransport.RTWallet.repository;

import com.roadTransport.RTWallet.entity.CouponDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CouponRepository extends JpaRepository<CouponDetails,Long> {

    @Query("select c from CouponDetails c where c.coupon = :coupon")
    public CouponDetails findByCoupon(@PathVariable("coupon") String coupon);
}
