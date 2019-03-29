package com.roadTransport.RTWallet.serviceImpl;

import com.roadTransport.RTWallet.entity.TransactionDetails;
import com.roadTransport.RTWallet.entity.WalletDetails;
import com.roadTransport.RTWallet.model.TransactionRequest;
import com.roadTransport.RTWallet.repository.TransactionRepository;
import com.roadTransport.RTWallet.service.TransactionService;
import com.roadTransport.RTWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        transactionDetails.setReverseTransactioNumber();
        }
        else {
            transactionDetails.setReverse(false);
            transactionDetails.setReverseAmount(0);
        }
        transactionDetails.setStatus(transactionRequest.isStatus());
        transactionDetails.setTransactionDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        transactionDetails.setUpdatedBalance(walletDetails.getBalance());
        transactionDetails.setUserMobileNumber(transactionRequest.getUserMobileNumber());
        transactionDetails.setTransactionnNumber();
        transactionDetails.setUserName(transactionRequest.getUserName());
        transactionDetails.setWalletId(transactionDetails.getWalletId());
        transactionRepository.saveAndFlush(transactionDetails);

        return transactionDetails;
    }

    @Override
    public TransactionDetails update(TransactionRequest transactionRequest) {
        return null;
    }

    @Override
    public TransactionDetails getByTransaction(String transactionNumber) {
        return null;
    }

    @Override
    public TransactionDetails getByMdn(String userMobileNumber) {
        return null;
    }
}
