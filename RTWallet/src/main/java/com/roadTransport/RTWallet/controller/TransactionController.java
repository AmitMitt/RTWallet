package com.roadTransport.RTWallet.controller;

import com.roadTransport.RTWallet.entity.TransactionDetails;
import com.roadTransport.RTWallet.model.TransactionRequest;
import com.roadTransport.RTWallet.model.TransactionResponse;
import com.roadTransport.RTWallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity<TransactionResponse> add(@RequestBody TransactionRequest transactionRequest){

        TransactionDetails transactionDetails = transactionService.add(transactionRequest);
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setReverseStatus(transactionDetails.isReverse());
        transactionResponse.setStatus(transactionDetails.isStatus());
        transactionResponse.setTransactionnNumber(transactionDetails.getTransactionnNumber());
        transactionResponse.setUserMobileNumber(transactionDetails.getUserMobileNumber());
        if(transactionDetails.isReverse() == false){
            transactionResponse.setMessage("Reverse in process.");
        }
        else {
        transactionResponse.setMessage("Transaction Successfully.");
        }
        return ResponseEntity.ok(transactionResponse);
    }

    @Cacheable(value = "TransactionDetails", key = "#transactionNumber")
    @GetMapping("getByTransaction/{transactionNumber}")
    public ResponseEntity<TransactionDetails> getByTransaction(@PathVariable("transactionNumber") String transactionNumber) throws Exception {

        TransactionDetails transactionDetails = transactionService.getByTransaction(transactionNumber);
        return ResponseEntity.ok(transactionDetails);
    }

    @Cacheable(value = "TransactionDetails", key = "#userMobileNumber")
    @GetMapping("getByMdn/{userMobileNumber}")
    public ResponseEntity<List<TransactionDetails>> getByMdn(@PathVariable("userMobileNumber") Long userMobileNumber) throws Exception {

        List<TransactionDetails> transactionDetails = transactionService.getByMdn(userMobileNumber);
        return ResponseEntity.ok(transactionDetails);
    }

}
