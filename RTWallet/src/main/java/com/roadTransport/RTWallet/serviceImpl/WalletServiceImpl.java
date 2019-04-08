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
import java.util.Base64;
import java.util.Calendar;
import java.util.TimeZone;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionService transactionService;

    @Override
    public WalletDetails add(WalletRequest walletRequest) throws Exception {

       WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId(),walletRequest.getRoleName());
       if (walletDetails != null){
           throw new Exception("Wallet Already Exist.");
       }

       WalletDetails walletDetails1 = new WalletDetails();
       walletDetails1.setBalance(0);
       walletDetails1.setCreatedDate(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
       walletDetails1.setOwnerName(walletRequest.getOwnerName());
       walletDetails1.setWalletId(walletRequest.getWalletId());
       walletDetails1.setWalletPin(Base64.getEncoder().encodeToString(String.valueOf(walletRequest.getWalletPin()).getBytes()));
       walletDetails1.setRoleName(walletRequest.getRoleName());
       walletRepository.saveAndFlush(walletDetails1);
        return walletDetails1;
    }

    @Override
    public WalletDetails getListByWallet(long walletId,String roleName) throws Exception {

        WalletDetails walletDetails = walletRepository.findByWallet(walletId,roleName);
        return walletDetails;
    }

    @Override
    public WalletDetails update(WalletRequest walletRequest) {

        WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId(),walletRequest.getRoleName());

        walletDetails.setModifiedDate(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        walletDetails.setOwnerName(walletRequest.getOwnerName());
        walletRepository.saveAndFlush(walletDetails);

        return walletDetails;
    }

    @Override
    public WalletDetails delete(long walletId,String roleName) {
        WalletDetails walletDetails = walletRepository.findByWallet(walletId,roleName);
        walletRepository.delete(walletDetails);
        return null;
    }

    @Override
    public WalletDetails updateBalance(WalletRequest walletRequest) {

       WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId(),walletRequest.getRoleName());
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
    public WalletDetails getBalance(long walletId,String roleName) {

        WalletDetails walletDetails = walletRepository.findByWallet(walletId,roleName);

        return walletDetails;
    }

    @Override
    public WalletDetails updateWalletPin(WalletPinRequest walletRequest) throws Exception {

        WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId(),walletRequest.getRoleName());

        byte[] pin = Base64.getDecoder().decode(walletDetails.getWalletPin());
        String decodedString = new String(pin);

        if(walletRequest.getCurrentPin()==Long.parseLong(decodedString)){
            if(walletRequest.getNewPin()==(walletRequest.getConfirmPin())){
                walletDetails.setWalletPin(Base64.getEncoder().encodeToString(String.valueOf(walletRequest.getNewPin()).getBytes()));
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
