package com.roadTransport.RTWallet.repository;

import com.roadTransport.RTWallet.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetails,Long> {

    @Query("select t from TransactionDetails t where t.transactionNumber = :transactionNumber")
    public TransactionDetails getByTransaction(@PathVariable("transactionNumber") String transactionNumber);

    @Query("select t from TransactionDetails t where t.userMobileNumber = :userMobileNumber")
    public TransactionDetails getByMdn(@PathVariable("userMobileNumber") long userMobileNumber);

}
