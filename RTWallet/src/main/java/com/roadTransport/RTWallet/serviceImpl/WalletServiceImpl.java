package com.roadTransport.RTWallet.serviceImpl;

import com.roadTransport.RTWallet.entity.WalletDetails;
import com.roadTransport.RTWallet.model.TransactionRequest;
import com.roadTransport.RTWallet.model.WalletPinRequest;
import com.roadTransport.RTWallet.model.WalletRequest;
import com.roadTransport.RTWallet.repository.WalletRepository;
import com.roadTransport.RTWallet.service.TransactionService;
import com.roadTransport.RTWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionService transactionService;

    @Override
    public WalletDetails add(WalletRequest walletRequest) throws Exception {

       WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId());
       if (walletDetails != null){
           throw new Exception("Wallet Already Exist.");
       }

       WalletDetails walletDetails1 = new WalletDetails();
       walletDetails1.setBalance(0);
       walletDetails1.setCreatedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
       walletDetails1.setOwnerName(walletRequest.getOwnerName());
       walletDetails1.setWalletId(walletRequest.getWalletId());
       walletDetails1.setWalletPin(Base64.getEncoder().encodeToString(walletRequest.getWalletPin().getBytes()));

       walletRepository.saveAndFlush(walletDetails1);
        return walletDetails1;
    }

    @Override
    public WalletDetails getListByWallet(long walletId) throws Exception {

        WalletDetails walletDetails = walletRepository.findByWallet(walletId);
        return walletDetails;
    }

    @Override
    public WalletDetails update(WalletRequest walletRequest) {

        WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId());

        walletDetails.setModifiedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        walletDetails.setOwnerName(walletRequest.getOwnerName());
        walletRepository.saveAndFlush(walletDetails);

        return walletDetails;
    }

    @Override
    public WalletDetails delete(long walletId) {
        WalletDetails walletDetails = walletRepository.findByWallet(walletId);
        walletRepository.delete(walletDetails);
        return null;
    }

    @Override
    public WalletDetails updateBalance(WalletRequest walletRequest) {

       WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId());
       walletDetails.setBalance(walletDetails.getBalance());
       TransactionRequest transactionRequest = new TransactionRequest();
       transactionRequest.setWalletId(walletRequest.getWalletId());
       transactionRequest.setStatus(true);
       transactionRequest.setUserName(walletRequest.getOwnerName());
       transactionRequest.setUserMobileNumber(walletRequest.getWalletId());
       transactionRequest.setAmount(walletRequest.getBalance());
       transactionService.add(transactionRequest);
       walletRepository.saveAndFlush(walletDetails);
        return walletDetails;
    }

    @Override
    public WalletDetails getBalance(long walletId) {

        WalletDetails walletDetails = walletRepository.findByWallet(walletId);

        return walletDetails;
    }

    @Override
    public WalletDetails updateWalletPin(WalletPinRequest walletRequest) throws Exception {

        WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId());

        byte[] pin = Base64.getDecoder().decode(walletDetails.getWalletPin());
        String decodedString = new String(pin);

        if(walletRequest.getCurrentPin().equalsIgnoreCase(decodedString)){
            if(walletRequest.getNewPin().equalsIgnoreCase(walletRequest.getConfirmPin())){
                walletDetails.setWalletPin(Base64.getEncoder().encodeToString(walletRequest.getNewPin().getBytes()));
                walletRepository.saveAndFlush(walletDetails);
            }
            else {
                throw new Exception("New Pin is not same as Confirm Pin.");
            }
        }
        else {
            throw new Exception("Current pin is not match.");
        }
        return walletDetails;
    }

}
