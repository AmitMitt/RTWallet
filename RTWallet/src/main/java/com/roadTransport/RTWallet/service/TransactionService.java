package com.roadTransport.RTWallet.service;

import com.roadTransport.RTWallet.entity.TransactionDetails;
import com.roadTransport.RTWallet.model.TransactionRequest;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    public TransactionDetails add(TransactionRequest transactionRequest);
    public TransactionDetails update(TransactionRequest transactionRequest);
    public TransactionDetails getByTransaction(String transactionNumber);
    public TransactionDetails getByMdn(String userMobileNumber);

}
