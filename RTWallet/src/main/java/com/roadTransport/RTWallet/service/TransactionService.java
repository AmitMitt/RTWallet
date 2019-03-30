package com.roadTransport.RTWallet.service;

import com.roadTransport.RTWallet.entity.TransactionDetails;
import com.roadTransport.RTWallet.model.TransactionRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    public TransactionDetails add(TransactionRequest transactionRequest);
    public TransactionDetails getByTransaction(String transactionNumber) throws Exception;
    public List<TransactionDetails> getByMdn(Long userMobileNumber) throws Exception;

}
