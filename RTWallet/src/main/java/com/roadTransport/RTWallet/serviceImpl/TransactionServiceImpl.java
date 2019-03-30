package com.roadTransport.RTWallet.serviceImpl;

import com.roadTransport.RTWallet.entity.TransactionDetails;
import com.roadTransport.RTWallet.entity.WalletDetails;
import com.roadTransport.RTWallet.model.TransactionRequest;
import com.roadTransport.RTWallet.repository.TransactionRepository;
import com.roadTransport.RTWallet.service.TransactionService;
import com.roadTransport.RTWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

   @Autowired
   private TransactionRepository transactionRepository;

   @Autowired
   private WalletService walletService;

    @Override
    public TransactionDetails add(TransactionRequest transactionRequest) {

        TransactionDetails transactionDetails = new TransactionDetails();
        WalletDetails walletDetails = walletService.getBalance(transactionDetails.getWalletId());
        transactionDetails.setAmount(transactionRequest.getAmount());
        transactionDetails.setAvailableBalance(walletDetails.getBalance());
        transactionDetails.setCreditCardId(transactionRequest.getCreditCardId());
        transactionDetails.setDebitCardId(transactionRequest.getDebitCardId());
        transactionDetails.setDescription(transactionRequest.getDescription());
        transactionDetails.setNetBankingId(transactionRequest.getNetBankingId());
        transactionDetails.setPaytmId(transactionRequest.getPaytmId());
        transactionDetails.setPhonePayId(transactionRequest.getPhonePayId());

        if (transactionDetails.isStatus()==false){
        transactionDetails.setReverse(true);
        transactionDetails.setReverseAmount(transactionRequest.getAmount());
        transactionDetails.setReverseTransactionDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        transactionDetails.setReverseTransactioNumber(GenerateTransactionNumber.generateTransactionNumber());
        }
        else {
            transactionDetails.setReverse(false);
            transactionDetails.setReverseAmount(0);
        }
        transactionDetails.setStatus(transactionRequest.isStatus());
        transactionDetails.setTransactionDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        transactionDetails.setUpdatedBalance(walletDetails.getBalance());
        transactionDetails.setUserMobileNumber(transactionRequest.getUserMobileNumber());
        transactionDetails.setTransactionnNumber(GenerateTransactionNumber.generateTransactionNumber());
        transactionDetails.setUserName(transactionRequest.getUserName());
        transactionDetails.setWalletId(transactionDetails.getWalletId());
        transactionRepository.saveAndFlush(transactionDetails);

        return transactionDetails;
    }

    @Override
    public TransactionDetails getByTransaction(String transactionNumber) throws Exception {

        TransactionDetails transactionDetails = transactionRepository.getByTransaction(transactionNumber);
        if(transactionDetails==null){
            throw new Exception("Transaction not available.");
        }
        return transactionDetails;
    }

    @Override
    public List<TransactionDetails> getByMdn(Long userMobileNumber) throws Exception {

        List<TransactionDetails> transactionDetails = transactionRepository.getByMdn(userMobileNumber);
        if(transactionDetails.isEmpty()){
            throw new Exception("Transaction not available.");
        }
        return transactionDetails;
    }
}
