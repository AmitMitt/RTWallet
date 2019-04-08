package com.roadTransport.RTWallet.repository;

import com.roadTransport.RTWallet.entity.WalletDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface WalletRepository extends JpaRepository<WalletDetails,Long> {

   @Query("select w from WalletDetails w where w.walletId = :walletId and w.roleName = :roleName")
    public WalletDetails findByWallet(@PathVariable("walletId") long walletId, @PathVariable("roleName") String roleName);
}
